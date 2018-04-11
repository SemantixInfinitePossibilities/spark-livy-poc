# Livy and Spark
POC about Livy installation and functionality

## Installation
* Two repositories: 
  * Apache: 
  * Cloudera: https://github.com/cloudera/livy

### Installation from Cloudera's packages
Referência: https://plenium.wordpress.com/2017/11/13/install-hue-spark-notebook-with-livy-on-cloudera/
Cloudera's available packages (0.2.0 and 0.3.0): https://archive.cloudera.com/beta/livy/

* Download and extract a package (i.e, 0.3.0) into a directory
* Before to run, set the environment variables:
  ```
   export SPARK_HOME=/usr/lib/spark
   export HADOOP_CONF_DIR=/etc/hadoop/conf
  ```
  * Start the livy server:
  ```
    ./bin/livy-server
  ```
 
* If a error happened because of `Cannot write log directory */apps/livy-server-0.3.0/logs`, so create the `log`folder manually and run again.
* Verify in browser:  `http://localhost:8998/`

### Installation from Repositories
  * Checkout or download the project from a repository. For instance:
  ``` 
  git clone https://github.com/cloudera/livy.git
  cd livy
  ```
  * Build and package:
  
    `mvn package  # to avoid tests problems use: mvn package -Dmaven.test.skip=true `
  
  * Remarks: At cloudera repository, currently, the master branch and *0.3.0* tag is not working, but *0.2.0* tag.
  
  * The package is generated in folder `assembly/target`. Extract and move/copy to desired folder;
  ```
    unzip assembly/target/livy-server-0.2.0.zip`
    mv assembly/target/livy-server-0.2.0.zip` /opt/livy
  ```
 * Before to run, set the environment variables:
  ```
   export SPARK_HOME=/usr/lib/spark
   export HADOOP_CONF_DIR=/etc/hadoop/conf
  ```
 * Start the livy server:
  ```
    ./bin/livy-server
  ```
 * Verify in browser:  `http://localhost:8998/`

### Docker
https://github.com/tobilg/docker-livy


## Using
Tests done in browser or using a REST Client.
* Queriyng current spark jobs:
  ```
   http://localhost:8998/batches`
  `curl -X GET "http://localhost:8998/batches"
  ```
* Queriyng a job:
```
 curl -X GET "http://localhost:8998/batches/1"
```
* Submiting a job. To use a local file edit the  
   ```
   curl 'Content-Type: application/json' -X POST -d "http://localhost:8998/batches/1" \
  "{
   "className": "org.apache.spark.examples.SparkPi",
   "executorMemory": "20g",
   "args": [2000],
   "file": "/home/semantix/temp/spark-examples_2.11-2.3.0.jar"
  }"
   ```
*  
