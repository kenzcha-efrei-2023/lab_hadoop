# Apache Hive TP

## 1 Hive Beeline Client
### 1.1 Create a connection to Beeline Client 

* connexion to Hadoop : `ssh c.mauvezin@163.172.102.44`
  trace : `Last login: Wed Sep 29 17:35:07 2021 from nat-in-drelab.groupe-efrei.fr`
  
* Initialize Kerberos ticket : `kinit`

* Connecting to server : `!connect jdbc:hive2://hadoop-master01.efrei.online:2181,hadoop-master02.efrei.online:2181,hadoop-master03.efrei.online:2181/;serviceDiscoveryMode=zooKeeper;zooKeeperNamespace=hiveserver2`
> 21/09/30 16:57:47 [main]: INFO jdbc.HiveConnection: Connected to hadoop-master01.efrei.online:10001
Connected to: Apache Hive (version 3.1.2.1.0.3.0-223)
Driver: Hive JDBC (version 3.1.2.1.0.3.0-223)
Transaction isolation: TRANSACTION_REPEATABLE_READ

* typing `beeline` 
> trace : <\br>`21/09/30 10:49:11 [main]: INFO jdbc.HiveConnection: Connected to hadoop-master02.efrei.online:10001
    Connected to: Apache Hive (version 3.1.2.1.0.3.0-223)
    Driver: Hive JDBC (version 3.1.2.1.0.3.0-223)
    Transaction isolation: TRANSACTION_REPEATABLE_READ
    Beeline version 3.1.2.1.0.3.0-223 by Apache Hive`
* `help`
> trace <\br> !addlocaldriverjar  Add driver jar file in the beeline client side.
!addlocaldrivername Add driver name that needs to be supported in the beeline
                    client side.
!all                Execute the specified SQL against all the current connections
!autocommit         Set autocommit mode on or off
!batch              Start or execute a batch of statements
!brief              Set verbose mode off
!call               Execute a callable statement
!close              Close the current connection to the database
!closeall           Close all current open connections
!columns            List all the columns for the specified table
!commit             Commit the current transaction (if autocommit is off)
!connect            Open a new connection to the database.
!dbinfo             Give metadata information about the database
!delimiter          Sets the query delimiter, defaults to ;
!describe           Describe a table
!dropall            Drop all tables in the current database
!exportedkeys       List all the exported keys for the specified table
!go                 Select the current connection
!help               Print a summary of command usage
!history            Display the command history
!importedkeys       List all the imported keys for the specified table
!indexes            List all the indexes for the specified table
!isolation          Set the transaction isolation for this connection
!list               List the current connections
!manual             Display the BeeLine manual
!metadata           Obtain metadata information
!nativesql          Show the native SQL for the specified statement
!nullemptystring    Set to true to get historic behavior of printing null as
                    empty string. Default is false.
!outputformat       Set the output format for displaying results
                    (table,vertical,csv2,dsv,tsv2,xmlattrs,xmlelements, and
                    deprecated formats(csv, tsv))
!primarykeys        List all the primary keys for the specified table
!procedures         List all the procedures
!properties         Connect to the database specified in the properties file(s)
!quit               Exits the program
!reconnect          Reconnect to the database
!record             Record all output to the specified file
!rehash             Fetch table and column names for command completion
!rollback           Roll back the current transaction (if autocommit is off)
!run                Run a script from the specified file
!save               Save the current variabes and aliases
!scan               Scan for installed JDBC drivers
!script             Start saving a script to a file
!set                Set a beeline variable
!sh                 Execute a shell command
!sql                Execute a SQL command
!tables             List all the tables in the database
!typeinfo           Display the type map for the current connection
!verbose            Set verbose mode on

* Command to allow user to view the jdbc connection to connect to HiveServer2 : `!list`
> trace :<\br> 2 active connections:
 #0  open     jdbc:hive2://hadoop-master01.efrei.online:2181,hadoop-master02.efrei.online:2181,hadoop-master03.efrei.online:2181/default;httpPath=cliservice;principal=hive/_HOST@EFREI.ONLINE;serviceDiscoveryMode=zooKeeper;ssl=true;transportMode=http;zooKeeperNamespace=hiveserver2
 #1  open     jdbc:hive2://hadoop-master01.efrei.online:2181,hadoop-master02.efrei.online:2181,hadoop-master03.efrei.online:2181/;serviceDiscoveryMode=zooKeeper;zooKeeperNamespace=hiveserver2
 
* Showing the databases : `show databases ;`
> trace :<\br>INFO  : Compiling command(queryId=hive_20210930174113_c47a0388-4bf5-4adf-a7e7-6d53c53c7979): show databases
INFO  : Concurrency mode is disabled, not creating a lock manager
INFO  : Semantic Analysis Completed (retrial = false)
INFO  : Returning Hive schema: Schema(fieldSchemas:[FieldSchema(name:database_name, type:string, comment:from deserializer)], properties:null)
INFO  : Completed compiling command(queryId=hive_20210930174113_c47a0388-4bf5-4adf-a7e7-6d53c53c7979); Time taken: 0.082 seconds
INFO  : Concurrency mode is disabled, not creating a lock manager
INFO  : Executing command(queryId=hive_20210930174113_c47a0388-4bf5-4adf-a7e7-6d53c53c7979): show databases
INFO  : Starting task [Stage-0:DDL] in serial mode
INFO  : Completed executing command(queryId=hive_20210930174113_c47a0388-4bf5-4adf-a7e7-6d53c53c7979); Time taken: 0.011 seconds
INFO  : OK
INFO  : Concurrency mode is disabled, not creating a lock manager
+---------------------+
|    database_name    |
+---------------------+
| balthazar_r         |
| baudouindlv         |
| berenice            |
| cgrandclaude        |
| cjdidi              |
| default             |
| eya_gheyouche       |
| gudronlauret        |
| gugulpb             |
| ilyass_bourkaik     |
| information_schema  |
| jbenayad            |
| jcrecel             |
| llecomte            |
| m_abatti            |
| ma_baseismail       |
| marieblein          |
| mhatoum             |
| ninon               |
| rbocchini           |
| rbouderghouma       |
| revillon            |
| sghlouci            |
| spiquet             |
| svassent            |
| sys                 |
| temp                |
| vaihau_williamu     |
| wangye              |
| yang_chen           |
| ymaassouli          |
+---------------------+
31 rows selected (0.215 seconds)

* Creating a database : `create database if not exists cmauvezin;`
> trace : (when using `show databases;`)<\br>
+---------------------+
|    database_name    |
+---------------------+
| balthazar_r         |
| baudouindlv         |
| berenice            |
| cgrandclaude        |
| cjdidi              |
| cmauvezin           | <-
| default             |
| eya_gheyouche       |
| gudronlauret        |
| gugulpb             |
| ilyass_bourkaik     |
| information_schema  |
| jbenayad            |
| jcrecel             |
| llecomte            |
| m_abatti            |
| ma_baseismail       |
| marieblein          |
| mhatoum             |
| ninon               |
| rbocchini           |
| rbouderghouma       |
| revillon            |
| sghlouci            |
| spiquet             |
| svassent            |
| sys                 |
| temp                |
| vaihau_williamu     |
| wangye              |
| yang_chen           |
| ymaassouli          |
+---------------------+

* Using my database : `use cmauvezin;`
> trace : <\br>INFO  : Compiling command(queryId=hive_20210930175831_13ebb060-1933-4bf6-83ba-6b4c7ec00356): use cmauvezin
INFO  : Concurrency mode is disabled, not creating a lock manager
INFO  : Semantic Analysis Completed (retrial = false)
INFO  : Returning Hive schema: Schema(fieldSchemas:null, properties:null)
INFO  : Completed compiling command(queryId=hive_20210930175831_13ebb060-1933-4bf6-83ba-6b4c7ec00356); Time taken: 0.021 seconds
INFO  : Concurrency mode is disabled, not creating a lock manager
INFO  : Executing command(queryId=hive_20210930175831_13ebb060-1933-4bf6-83ba-6b4c7ec00356): use cmauvezin
INFO  : Starting task [Stage-0:DDL] in serial mode
INFO  : Completed executing command(queryId=hive_20210930175831_13ebb060-1933-4bf6-83ba-6b4c7ec00356); Time taken: 0.015 seconds
INFO  : OK
INFO  : Concurrency mode is disabled, not creating a lock manager
No rows affected (0.051 seconds)

* list tables `show tables;`
> traces : <\br> INFO  : Compiling command(queryId=hive_20210930175932_ef674a9f-13cd-45e6-89fd-83699abb5b67): show tables
INFO  : Concurrency mode is disabled, not creating a lock manager
INFO  : Semantic Analysis Completed (retrial = false)
INFO  : Returning Hive schema: Schema(fieldSchemas:[FieldSchema(name:tab_name, type:string, comment:from deserializer)], properties:null)
INFO  : Completed compiling command(queryId=hive_20210930175932_ef674a9f-13cd-45e6-89fd-83699abb5b67); Time taken: 0.034 seconds
INFO  : Concurrency mode is disabled, not creating a lock manager
INFO  : Executing command(queryId=hive_20210930175932_ef674a9f-13cd-45e6-89fd-83699abb5b67): show tables
INFO  : Starting task [Stage-0:DDL] in serial mode
INFO  : Completed executing command(queryId=hive_20210930175932_ef674a9f-13cd-45e6-89fd-83699abb5b67); Time taken: 0.027 seconds
INFO  : OK
INFO  : Concurrency mode is disabled, not creating a lock manager
+-----------+
| tab_name  |
+-----------+
+-----------+
No rows selected (0.079 seconds)

* Create temp`create table if not exists temp col (string);`
> trace : <\br>INFO  : Compiling command(queryId=hive_20210930182249_b6cb27f3-7220-45d8-a8e0-a3480ebf7c5d): create table if not exists temp (col string
)
INFO  : Concurrency mode is disabled, not creating a lock manager
INFO  : Semantic Analysis Completed (retrial = false)
INFO  : Returning Hive schema: Schema(fieldSchemas:null, properties:null)
INFO  : Completed compiling command(queryId=hive_20210930182249_b6cb27f3-7220-45d8-a8e0-a3480ebf7c5d); Time taken: 0.04 seconds
INFO  : Concurrency mode is disabled, not creating a lock manager
INFO  : Executing command(queryId=hive_20210930182249_b6cb27f3-7220-45d8-a8e0-a3480ebf7c5d): create table if not exists temp (col string
)
INFO  : Starting task [Stage-0:DDL] in serial mode
INFO  : Completed executing command(queryId=hive_20210930182249_b6cb27f3-7220-45d8-a8e0-a3480ebf7c5d); Time taken: 0.063 seconds
INFO  : OK
INFO  : Concurrency mode is disabled, not creating a lock manager
No rows affected (0.125 seconds)

* Confirm the table creation `show tables;`
> trace : <\br>INFO  : Executing command(queryId=hive_20210930182310_2f122ea0-3d79-4188-8f07-1a60a4806b84): show tables
INFO  : Starting task [Stage-0:DDL] in serial mode
INFO  : Completed executing command(queryId=hive_20210930182310_2f122ea0-3d79-4188-8f07-1a60a4806b84); Time taken: 0.025 seconds
INFO  : OK
INFO  : Concurrency mode is disabled, not creating a lock manager
+-----------+
| tab_name  |
+-----------+
| temp      |
+-----------+
1 row selected (0.106 seconds)

* List the columns : `describe temp;`
> trace : <\br>INFO  : Compiling command(queryId=hive_20210930183004_495b9794-cca4-4583-a11b-b614169e6684): describe temp
INFO  : Concurrency mode is disabled, not creating a lock manager
INFO  : Semantic Analysis Completed (retrial = false)
INFO  : Returning Hive schema: Schema(fieldSchemas:[FieldSchema(name:col_name, type:string, comment:from deserializer), FieldSchema(name:data_type, type:string, comment:from deserializer), FieldSchema(name:comment, type:string, comment:from deserializer)], properties:null)
INFO  : Completed compiling command(queryId=hive_20210930183004_495b9794-cca4-4583-a11b-b614169e6684); Time taken: 0.029 seconds
INFO  : Concurrency mode is disabled, not creating a lock manager
INFO  : Executing command(queryId=hive_20210930183004_495b9794-cca4-4583-a11b-b614169e6684): describe temp
INFO  : Starting task [Stage-0:DDL] in serial mode
INFO  : Completed executing command(queryId=hive_20210930183004_495b9794-cca4-4583-a11b-b614169e6684); Time taken: 0.018 seconds
INFO  : OK
INFO  : Concurrency mode is disabled, not creating a lock manager
+-----------+------------+----------+
| col_name  | data_type  | comment  |
+-----------+------------+----------+
| col       | string     |          |
+-----------+------------+----------+
1 row selected (0.07 seconds)

* Removing the table `drop table temp`
> trace : INFO  : Compiling command(queryId=hive_20210930183126_9e3a6e6d-09fc-4f35-ab22-fd223fbcddd4): drop table temp
INFO  : Concurrency mode is disabled, not creating a lock manager
INFO  : Semantic Analysis Completed (retrial = false)
INFO  : Returning Hive schema: Schema(fieldSchemas:null, properties:null)
INFO  : Completed compiling command(queryId=hive_20210930183126_9e3a6e6d-09fc-4f35-ab22-fd223fbcddd4); Time taken: 0.077 seconds
INFO  : Concurrency mode is disabled, not creating a lock manager
INFO  : Executing command(queryId=hive_20210930183126_9e3a6e6d-09fc-4f35-ab22-fd223fbcddd4): drop table temp
INFO  : Starting task [Stage-0:DDL] in serial mode
INFO  : Completed executing command(queryId=hive_20210930183126_9e3a6e6d-09fc-4f35-ab22-fd223fbcddd4); Time taken: 0.196 seconds
INFO  : OK
INFO  : Concurrency mode is disabled, not creating a lock manager
No rows affected (0.294 seconds)

* Quitting : `!quit`
> trace : <\br> Closing: 1: jdbc:hive2://hadoop-master01.efrei.online:2181,hadoop-master02.efrei.online:2181,hadoop-master03.efrei.online:2181/;serviceDiscoveryMode=zooKeeper;zooKeeperNamespace=hiveserver2
Closing: 0: jdbc:hive2://hadoop-master01.efrei.online:2181,hadoop-master02.efrei.online:2181,hadoop-master03.efrei.online:2181/default;httpPath=cliservice;principal=hive/_HOST@EFREI.ONLINE;serviceDiscoveryMode=zooKeeper;ssl=true;transportMode=http;zooKeeperNamespace=hiveserver2
21/09/30 18:32:49 [shutdown-hook-0]: INFO jdbc.HiveConnection: Could not connect to the server. Retrying one more time.

### Create tables
