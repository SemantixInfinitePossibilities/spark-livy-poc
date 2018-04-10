# Livy and Spark
POC about Livy installation and functionality

## Installation
* Two repositories: 
  * Apache: 
  * Cloudera: https://github.com/cloudera/livy
* Cloudera's available packages (0.2.0 and 0.3.0): https://archive.cloudera.com/beta/livy/

## Installation from Cloudera's packages
Referência: https://plenium.wordpress.com/2017/11/13/install-hue-spark-notebook-with-livy-on-cloudera/
* Download and extract a package (i.e, 0.3.0) into a directory
* Run: ` ./bin/livy-server` 
* If a error happened because of `Cannot write log directory */apps/livy-server-0.3.0/logs`, so create the `log`folder manually and run again.
* Verify in browser:  `http://localhost:8998/`

#Using
* Some tests in browser or in a REST Client: 
  `http://localhost:8998/batches`

