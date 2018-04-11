# Livy and Spark
POC about Livy installation and functionality

## Installation
* Two repositories: 
  * Apache: 
  * Cloudera: https://github.com/cloudera/livy

## Installation from Cloudera's packages
Referência: https://plenium.wordpress.com/2017/11/13/install-hue-spark-notebook-with-livy-on-cloudera/
Cloudera's available packages (0.2.0 and 0.3.0): https://archive.cloudera.com/beta/livy/

* Download and extract a package (i.e, 0.3.0) into a directory
* Run: ` ./bin/livy-server` 
* If a error happened because of `Cannot write log directory */apps/livy-server-0.3.0/logs`, so create the `log`folder manually and run again.
* Verify in browser:  `http://localhost:8998/`

## Installation from Repositories
  * Checkout or download the project from a repository. For instance:
  ``` 
  git clone https://github.com/cloudera/livy.git
  cd livy
  ```
  * Build and package:
  
    `mvn package  # to avoid tests problems use: mvn package -Dmaven.test.skip=true `
  
  * Remarks: At cloudera repository, currently, the master branch and *0.3.0* tag is not working, but *0.2.0* tag.
  
  * The package is generated in folder `assembly/target`: 
  
     `ls assembly/target/livy-server-0.2.0.zip`

## Docker
https://github.com/tobilg/docker-livy


## Using
Tests done in browser or using a REST Client.
* Queryng current spark jobs:
  `http://localhost:8998/batches`
  `curl -X GET "http://localhost:8998/batches"`

