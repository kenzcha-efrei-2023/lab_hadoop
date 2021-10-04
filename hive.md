# Apache Hive TP

## 1 Hive Beeline Client
### 1.1 Create a connection to Beeline Client 

* connexion to Hadoop : `ssh c.mauvezin@163.172.102.44`
> trace : `Last login: Wed Sep 29 17:35:07 2021 from nat-in-drelab.groupe-efrei.fr`
  
* Initialize Kerberos ticket : `kinit`

* Connecting to server : `!connect jdbc:hive2://hadoop-master01.efrei.online:2181,hadoop-master02.efrei.online:2181,hadoop-master03.efrei.online:2181/;serviceDiscoveryMode=zooKeeper;zooKeeperNamespace=hiveserver2`
> 21/09/30 16:57:47 [main]: INFO jdbc.HiveConnection: Connected to hadoop-master01.efrei.online:10001<\br>
Connected to: Apache Hive (version 3.1.2.1.0.3.0-223)<br />
Driver: Hive JDBC (version 3.1.2.1.0.3.0-223)<br />
Transaction isolation: TRANSACTION_REPEATABLE_READ<br />

* typing `beeline` 
> trace : <br />`21/09/30 10:49:11 [main]: INFO jdbc.HiveConnection: Connected to hadoop-master02.efrei.online:10001< /br>
    Connected to: Apache Hive (version 3.1.2.1.0.3.0-223)<br />
    Driver: Hive JDBC (version 3.1.2.1.0.3.0-223)<br />
    Transaction isolation: TRANSACTION_REPEATABLE_READ<br />
    Beeline version 3.1.2.1.0.3.0-223 by Apache Hive`<br />
* `help`
> trace <br /> !addlocaldriverjar  Add driver jar file in the beeline client side.<br />
!addlocaldrivername Add driver name that needs to be supported in the beeline<br />
                    client side.<br />
!all                Execute the specified SQL against all the current connections<br />
!autocommit         Set autocommit mode on or off<br />
!batch              Start or execute a batch of statements<br />
!brief              Set verbose mode off<br />
!call               Execute a callable statement<br />
!close              Close the current connection to the database<br />
!closeall           Close all current open connections<br />
!columns            List all the columns for the specified table<br />
!commit             Commit the current transaction (if autocommit is off)<br />
!connect            Open a new connection to the database.<br />
!dbinfo             Give metadata information about the database<br />
!delimiter          Sets the query delimiter, defaults to ;<br />
!describe           Describe a table<b /r>
!dropall            Drop all tables in the current database<br />
!exportedkeys       List all the exported keys for the specified table<br />
!go                 Select the current connection<br />
!help               Print a summary of command usage<br />
!history            Display the command history<br />
!importedkeys       List all the imported keys for the specified table<br />
!indexes            List all the indexes for the specified table<br />
!isolation          Set the transaction isolation for this connection<br />
!list               List the current connections<br />
!manual             Display the BeeLine manual<br />
!metadata           Obtain metadata information<br />
!nativesql          Show the native SQL for the specified statement<br />
!nullemptystring    Set to true to get historic behavior of printing null as
                    empty string. Default is false.<br />
!outputformat       Set the output format for displaying results
                    (table,vertical,csv2,dsv,tsv2,xmlattrs,xmlelements, and
                    deprecated formats(csv, tsv))<br />
!primarykeys        List all the primary keys for the specified table<br />
!procedures         List all the procedures<br />
!properties         Connect to the database specified in the properties file(s)<br />
!quit               Exits the program<br />
!reconnect          Reconnect to the database<br />
!record             Record all output to the specified file<br />
!rehash             Fetch table and column names for command completion<br />
!rollback           Roll back the current transaction (if autocommit is off)<br />
!run                Run a script from the specified file<br />
!save               Save the current variabes and aliases<br />
!scan               Scan for installed JDBC drivers<br />
!script             Start saving a script to a file<br />
!set                Set a beeline variable<br />
!sh                 Execute a shell command<br />
!sql                Execute a SQL command<br />
!tables             List all the tables in the database<br />
!typeinfo           Display the type map for the current connection<br />
!verbose            Set verbose mode on<br />

* Command to allow user to view the jdbc connection to connect to HiveServer2 : `!list`
> trace :<\br> 2 active connections:<br />
 #0  open     jdbc:hive2://hadoop-master01.efrei.online:2181,hadoop-master02.efrei.online:2181,hadoop-master03.efrei.online:2181/default;httpPath=cliservice;principal=hive/_HOST@EFREI.ONLINE;serviceDiscoveryMode=zooKeeper;ssl=true;transportMode=http;zooKeeperNamespace=hiveserver2<br />
 #1  open     jdbc:hive2://hadoop-master01.efrei.online:2181,hadoop-master02.efrei.online:2181,hadoop-master03.efrei.online:2181/;serviceDiscoveryMode=zooKeeper;zooKeeperNamespace=hiveserver2<br />
 
* Showing the databases : `show databases ;`
> trace :<\br>INFO  : Compiling command(queryId=hive_20210930174113_c47a0388-4bf5-4adf-a7e7-6d53c53c7979): show databases<br />
INFO  : Concurrency mode is disabled, not creating a lock manager<br />
INFO  : Semantic Analysis Completed (retrial = false)<br />
INFO  : Returning Hive schema: Schema(fieldSchemas:[FieldSchema(name:database_name, type:string, comment:from deserializer)], properties:null)<br />
INFO  : Completed compiling command(queryId=hive_20210930174113_c47a0388-4bf5-4adf-a7e7-6d53c53c7979); Time taken: 0.082 seconds<br />
INFO  : Concurrency mode is disabled, not creating a lock manager<br />
INFO  : Executing command(queryId=hive_20210930174113_c47a0388-4bf5-4adf-a7e7-6d53c53c7979): show databases<br />
INFO  : Starting task [Stage-0:DDL] in serial mode<br />
INFO  : Completed executing command(queryId=hive_20210930174113_c47a0388-4bf5-4adf-a7e7-6d53c53c7979); Time taken: 0.011 seconds<br />
INFO  : OK<br />
INFO  : Concurrency mode is disabled, not creating a lock manager<br />
+---------------------+<br />
|    database_name    |<br />
+---------------------+<br />
| balthazar_r         |<br />
| baudouindlv         |<br />
| berenice            |<br />
| cgrandclaude        |<br />
| cjdidi              |<br />
| default             |<br />
| eya_gheyouche       |<br />
| gudronlauret        |<br />
| gugulpb             |<br />
| ilyass_bourkaik     |<br />
| information_schema  |<br />
| jbenayad            |<br />
| jcrecel             |<br />
| llecomte            |<br />
| m_abatti            |<br />
| ma_baseismail       |<br />
| marieblein          |<br />
| mhatoum             |<br />
| ninon               |<br />
| rbocchini           |<br />
| rbouderghouma       |<br />
| revillon            |<br />
| sghlouci            |<br />
| spiquet             |<br />
| svassent            |<br />
| sys                 |<br />
| temp                |<br />
| vaihau_williamu     |<br />
| wangye              |<br />
| yang_chen           |<br />
| ymaassouli          |<br />
+---------------------+<b /r>
31 rows selected (0.215 seconds)<br />

* Creating a database : `create database if not exists cmauvezin;`
> trace : (when using `show databases;`)<br />
+---------------------+<br />
|    database_name    |<br />
+---------------------+<br />
| balthazar_r         |<br />
| baudouindlv         |<br />
| berenice            |<br />
| cgrandclaude        |<br />
| cjdidi              |<br />
| cmauvezin           | <-<br />
| default             |<br />
| eya_gheyouche       |<br />
| gudronlauret        |<br />
| gugulpb             |<br />
| ilyass_bourkaik     |<br />
| information_schema  |<br />
| jbenayad            |<br />
| jcrecel             |<br />
| llecomte            |<br />
| m_abatti            |<br />
| ma_baseismail       |<br />
| marieblein          |<br />
| mhatoum             |<br />
| ninon               |<br />
| rbocchini           |<br />
| rbouderghouma       |<br />
| revillon            |<br />
| sghlouci            |<br /> 
| spiquet             |<br />
| svassent            |<br />
| sys                 |<br />
| temp                |<br />
| vaihau_williamu     |<br />
| wangye              |<br />
| yang_chen           |<br />
| ymaassouli          |<br />
+---------------------+<br />

* Using my database : `use cmauvezin;`
> trace : <\br>INFO  : Compiling command(queryId=hive_20210930175831_13ebb060-1933-4bf6-83ba-6b4c7ec00356): use cmauvezin<b /r>
INFO  : Concurrency mode is disabled, not creating a lock manager<br />
INFO  : Semantic Analysis Completed (retrial = false)<br />
INFO  : Returning Hive schema: Schema(fieldSchemas:null, properties:null)<br />
INFO  : Completed compiling command(queryId=hive_20210930175831_13ebb060-1933-4bf6-83ba-6b4c7ec00356); Time taken: 0.021 seconds<br />
INFO  : Concurrency mode is disabled, not creating a lock manager<br />
INFO  : Executing command(queryId=hive_20210930175831_13ebb060-1933-4bf6-83ba-6b4c7ec00356): use cmauvezin<br />
INFO  : Starting task [Stage-0:DDL] in serial mode<br />
INFO  : Completed executing command(queryId=hive_20210930175831_13ebb060-1933-4bf6-83ba-6b4c7ec00356); Time taken: 0.015 seconds<br />
INFO  : OK<br />
INFO  : Concurrency mode is disabled, not creating a lock manager<br />
No rows affected (0.051 seconds)<br />

* list tables `show tables;`
> traces : <\br> INFO  : Compiling command(queryId=hive_20210930175932_ef674a9f-13cd-45e6-89fd-83699abb5b67): show tables<br />
INFO  : Concurrency mode is disabled, not creating a lock manager<br />
INFO  : Semantic Analysis Completed (retrial = false)<br />
INFO  : Returning Hive schema: Schema(fieldSchemas:[FieldSchema(name:tab_name, type:string, comment:from deserializer)], properties:null)<br />
INFO  : Completed compiling command(queryId=hive_20210930175932_ef674a9f-13cd-45e6-89fd-83699abb5b67); Time taken: 0.034 seconds<br />
INFO  : Concurrency mode is disabled, not creating a lock manager<br />
INFO  : Executing command(queryId=hive_20210930175932_ef674a9f-13cd-45e6-89fd-83699abb5b67): show tables<br />
INFO  : Starting task [Stage-0:DDL] in serial mode<br />
INFO  : Completed executing command(queryId=hive_20210930175932_ef674a9f-13cd-45e6-89fd-83699abb5b67); Time taken: 0.027 seconds<br />
INFO  : OK<br />
INFO  : Concurrency mode is disabled, not creating a lock manager<br />
+-----------+<br />
| tab_name  |<br />
+-----------+<br />
+-----------+<br />
No rows selected (0.079 seconds)<br />

* Create temp`create table if not exists temp col (string);`
> trace : <\br>INFO  : Compiling command(queryId=hive_20210930182249_b6cb27f3-7220-45d8-a8e0-a3480ebf7c5d): create table if not exists temp (col string);<br />
INFO  : Concurrency mode is disabled, not creating a lock manager<br />
INFO  : Semantic Analysis Completed (retrial = false)<br />
INFO  : Returning Hive schema: Schema(fieldSchemas:null, properties:null)<br />
INFO  : Completed compiling command(queryId=hive_20210930182249_b6cb27f3-7220-45d8-a8e0-a3480ebf7c5d); Time taken: 0.04 seconds<br />
INFO  : Concurrency mode is disabled, not creating a lock manager<br />
INFO  : Executing command(queryId=hive_20210930182249_b6cb27f3-7220-45d8-a8e0-a3480ebf7c5d): create table if not exists temp (col string);<br />
INFO  : Starting task [Stage-0:DDL] in serial mode<br />
INFO  : Completed executing command(queryId=hive_20210930182249_b6cb27f3-7220-45d8-a8e0-a3480ebf7c5d); Time taken: 0.063 seconds<br />
INFO  : OK<br />
INFO  : Concurrency mode is disabled, not creating a lock manager<br />
No rows affected (0.125 seconds)<br />

* Confirm the table creation `show tables;`
> trace : <\br>INFO  : Executing command(queryId=hive_20210930182310_2f122ea0-3d79-4188-8f07-1a60a4806b84): show tables<br />
INFO  : Starting task [Stage-0:DDL] in serial mode<br />
INFO  : Completed executing command(queryId=hive_20210930182310_2f122ea0-3d79-4188-8f07-1a60a4806b84); Time taken: 0.025 seconds<br />
INFO  : OK<br />
INFO  : Concurrency mode is disabled, not creating a lock manager<br />
+-----------+<br />
| tab_name  |<br />
+-----------+<br />
| temp      |<br />
+-----------+<br />
1 row selected (0.106 seconds)<br />

* List the columns : `describe temp;`
> trace : <\br>INFO  : Compiling command(queryId=hive_20210930183004_495b9794-cca4-4583-a11b-b614169e6684): describe temp<br />
INFO  : Concurrency mode is disabled, not creating a lock manager<br />
INFO  : Semantic Analysis Completed (retrial = false)<br />
INFO  : Returning Hive schema: Schema(fieldSchemas:[FieldSchema(name:col_name, type:string, comment:from deserializer), FieldSchema(name:data_type, type:string, comment:from deserializer), FieldSchema(name:comment, type:string, comment:from deserializer)], properties:null)<br />
INFO  : Completed compiling command(queryId=hive_20210930183004_495b9794-cca4-4583-a11b-b614169e6684); Time taken: 0.029 seconds<br />
INFO  : Concurrency mode is disabled, not creating a lock manager<br />
INFO  : Executing command(queryId=hive_20210930183004_495b9794-cca4-4583-a11b-b614169e6684): describe temp<br />
INFO  : Starting task [Stage-0:DDL] in serial mode<br />
INFO  : Completed executing command(queryId=hive_20210930183004_495b9794-cca4-4583-a11b-b614169e6684); Time taken: 0.018 seconds<br />
INFO  : OK<br />
INFO  : Concurrency mode is disabled, not creating a lock manager<br />
+-----------+------------+----------+<br />
| col_name  | data_type  | comment  |<br />
+-----------+------------+----------+<br />
| col       | string     |          |<br />
+-----------+------------+----------+<br />
1 row selected (0.07 seconds)<br />
* Removing the table `drop table temp`
> trace : INFO  : Compiling command(queryId=hive_20210930183126_9e3a6e6d-09fc-4f35-ab22-fd223fbcddd4): drop table temp<br />
INFO  : Concurrency mode is disabled, not creating a lock manager<br />
INFO  : Semantic Analysis Completed (retrial = false)<br />
INFO  : Returning Hive schema: Schema(fieldSchemas:null, properties:null)<br />
INFO  : Completed compiling command(queryId=hive_20210930183126_9e3a6e6d-09fc-4f35-ab22-fd223fbcddd4); Time taken: 0.077 seconds<br />
INFO  : Concurrency mode is disabled, not creating a lock manager<br />
INFO  : Executing command(queryId=hive_20210930183126_9e3a6e6d-09fc-4f35-ab22-fd223fbcddd4): drop table temp<br />
INFO  : Starting task [Stage-0:DDL] in serial mode<br /> 
INFO  : Completed executing command(queryId=hive_20210930183126_9e3a6e6d-09fc-4f35-ab22-fd223fbcddd4); Time taken: 0.196 seconds<br />
INFO  : OK<br />
INFO  : Concurrency mode is disabled, not creating a lock manager<br />
No rows affected (0.294 seconds)<br />

* Quitting : `!quit`
> trace : <\br> Closing: 1: jdbc:hive2://hadoop-master01.efrei.online:2181,hadoop-master02.efrei.online:2181,hadoop-master03.efrei.online:2181/;serviceDiscoveryMode=zooKeeper;zooKeeperNamespace=hiveserver2<br />
Closing: 0: jdbc:hive2://hadoop-master01.efrei.online:2181,hadoop-master02.efrei.online:2181,hadoop-master03.efrei.online:2181/default;httpPath=cliservice;principal=hive/_HOST@EFREI.ONLINE;serviceDiscoveryMode=zooKeeper;ssl=true;transportMode=http;zooKeeperNamespace=hiveserver2<br />
21/09/30 18:32:49 [shutdown-hook-0]: INFO jdbc.HiveConnection: Could not connect to the server. Retrying one more time.<br />

### 1.2 Create tables

* Create an external table called trees_external
> Querie : `create external table trees_external(geopts struct<lon:FLOAT,lat:FLOAT> ,arr int,gnr STRING,esp STRING,fam STRING,ann INT,hau FLOAT,cir FLOAT,adr STRING,nomcomm STRING,var STRING,objID int,nomEV STRING) ;`<br />
> INFO  : Starting task [Stage-0:DDL] in serial mode<br />
INFO  : Completed executing command(queryId=hive_20211004154344_a1fd3164-798b-4c54-8d92-511680c476e6); Time taken: 0.096 seconds<br />
INFO  : OK<br />
INFO  : Concurrency mode is disabled, not creating a lock manager<br />
No rows affected (0.145 seconds)<br />
0: jdbc:hive2://hadoop-master01.efrei.online:> show tables ;<br />
INFO  : Compiling command(queryId=hive_20211004154453_12dbca55-42a9-45ab-bc94-5a17e698ca2d): show tablesINFO  : Concurrency mode is disabled, not creating a lock manager<br />
INFO  : Semantic Analysis Completed (retrial = false)<br />
INFO  : Returning Hive schema: Schema(fieldSchemas:[FieldSchema(name:tab_name, type:string, comment:from deserializer)], properties:null)<br />
INFO  : Completed compiling command(queryId=hive_20211004154453_12dbca55-42a9-45ab-bc94-5a17e698ca2d); Time taken: 0.033 seconds<br />
INFO  : Concurrency mode is disabled, not creating a lock manager<br />
INFO  : Executing command(queryId=hive_20211004154453_12dbca55-42a9-45ab-bc94-5a17e698ca2d): show tablesINFO  : Starting task [Stage-0:DDL] in serial mode<br />
INFO  : Completed executing command(queryId=hive_20211004154453_12dbca55-42a9-45ab-bc94-5a17e698ca2d); Time taken: 0.022 seconds<br />
INFO  : OK<br />
INFO  : Concurrency mode is disabled, not creating a lock manager<br />
+-----------------+<br />
|    tab_name     |<br />
+-----------------+<br />
| trees_external  |<br />
+-----------------+<br />
1 row selected (0.102 seconds)<br />

* Create an internal table called trees_internal


* Import to the internal table using the external table


* Verify that each table got 


### 1.3 Create queries 

* displays the list of distinct containing trees
> Querie :
> Trace :

* displays the list of different species trees
> Querie :
> Trace :

* the number of trees of each kind
> Querie :
> Trace :

* calculates the height of the tallest tree of each kind
> Querie :
> Trace :

* sort the trees height from smallest to largest
> Querie :
> Trace :

* displays the district where the oldest tree is
> Querie :
> Trace :

* display the district tat contains the most trees
> Querie :
> Trace :

