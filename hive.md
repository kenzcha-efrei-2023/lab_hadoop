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
> Querie : `create external table trees_internal(
geopts STRING ,
arr int,
gnr STRING,
esp STRING,
fam STRING,
ann INT,
hau FLOAT,
cir FLOAT,
adr STRING,
nomcomm STRING,
var STRING,
objID int,
nomEV STRING
) ROW FORMAT DELIMITED FIELDS TERMINATED BY ';' ;`
> 2nd Querie : `load data inpath 'hdfs://efrei/user/c.mauvezin/dt' overwrite into table trees_external ;`
> Trace : <br />
INFO  : Starting task [Stage-0:DDL] in serial mode<br />
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
> Querie : `create table trees_internal(
geopts struct<lon:FLOAT,lat:FLOAT> ,
arr int,
gnr STRING,
esp STRING,
fam STRING,
ann INT,
hau FLOAT,
cir FLOAT,
adr STRING,
nomcomm STRING,
var STRING,
objID int,
nomEV STRING
) ;`<br />
> trace :<br />
INFO  : Concurrency mode is disabled, not creating a lock manager<br />
INFO  : Semantic Analysis Completed (retrial = false)<br />
INFO  : Returning Hive schema: Schema(fieldSchemas:null, properties:null)<br />
INFO  : Completed compiling command(queryId=hive_20211004205222_311838bc-728e-4dc3-955a-35152d2a64a0); Time taken: 0.103 seconds<br />
INFO  : Concurrency mode is disabled, not creating a lock manager<br />
INFO  : Executing command(queryId=hive_20211004205222_311838bc-728e-4dc3-955a-35152d2a64a0): create table trees_internal(<br />
geopts struct<lon:FLOAT,lat:FLOAT> ,<br />
arr int,<br />
gnr STRING,<br />
esp STRING,<br />
fam STRING,<br />
ann INT,<br />
hau FLOAT,<br />
cir FLOAT,<br />
adr STRING,<br />
nomcomm STRING,<br />
var STRING,<br />
objID int,<br />
nomEV STRING<br />
)<br />
INFO  : Starting task [Stage-0:DDL] in serial mode<br />
INFO  : Completed executing command(queryId=hive_20211004205222_311838bc-728e-4dc3-955a-35152d2a64a0); Time taken: 0.106 seconds<br />
INFO  : OK<br />
INFO  : Concurrency mode is disabled, not creating a lock manager<br />
No rows affected (0.271 seconds)<br />

* Import to the internal table using the external table
> Querie : `insert overwrite table trees_internal select * from trees_external ;`
> Trace : <br />
INFO  : Compiling command(queryId=hive_20211005150733_192fcdcb-ec06-4fde-b5ec-ea2ddad9391f): insert overwrite table trees_internal select * from trees_external
INFO  : Concurrency mode is disabled, not creating a lock manager
INFO  : Semantic Analysis Completed (retrial = false)
INFO  : Returning Hive schema: Schema(fieldSchemas:[FieldSchema(name:_col0, type:varchar(50), comment:null), FieldSchema(name:_col1, type:int, comment:null), FieldSchema(name:_col2, type:varchar(50), comment:null), FieldSchema(name:_col3, type:varchar(50), comment:null), FieldSchema(name:_col4, type:varchar(50), comment:null), FieldSchema(name:_col5, type:int, comment:null), FieldSchema(name:_col6, type:float, comment:null), FieldSchema(name:_col7, type:float, comment:null), FieldSchema(name:_col8, type:varchar(50), comment:null), FieldSchema(name:_col9, type:varchar(50), comment:null), FieldSchema(name:_col10, type:varchar(50), comment:null), FieldSchema(name:_col11, type:int, comment:null), FieldSchema(name:_col12, type:varchar(50), comment:null)], properties:null)
INFO  : Completed compiling command(queryId=hive_20211005150733_192fcdcb-ec06-4fde-b5ec-ea2ddad9391f); Time taken: 0.324 seconds
INFO  : Concurrency mode is disabled, not creating a lock manager
INFO  : Executing command(queryId=hive_20211005150733_192fcdcb-ec06-4fde-b5ec-ea2ddad9391f): insert overwrite table trees_internal select * from trees_external
INFO  : Query ID = hive_20211005150733_192fcdcb-ec06-4fde-b5ec-ea2ddad9391f
INFO  : Total jobs = 1
INFO  : Launching Job 1 out of 1
INFO  : Starting task [Stage-1:MAPRED] in serial mode
INFO  : Subscribed to counters: [] for queryId: hive_20211005150733_192fcdcb-ec06-4fde-b5ec-ea2ddad9391f
INFO  : Tez session hasn't been created yet. Opening session
ERROR : Failed to execute tez graph.
org.apache.tez.dag.api.SessionNotRunning: TezSession has already shutdown. Application application_1630864376208_2265 failed 2 times due to AM Container for appattempt_1630864376208_2265_000002 exited with  exitCode: 1

* Verify that each table got 
> `select * from trees_internal ;`
> Trance : <br />
> +---------------------------------+--------------------------------+-----------------------+------------------------+-------------------------+----------------------------------+-------------------------+-------------------------------+----------------------------------------------------+----------------------------+-------------------------+--------------------------+----------------------------------------------------+<br />
|     trees_internal.geopoint     | trees_internal.arrondissement  | trees_internal.genre  | trees_internal.espece  | trees_internal.famille  | trees_internal.annee_plantation  | trees_internal.hauteur  | trees_internal.circonference  |               trees_internal.adresse               | trees_internal.nom_commun  | trees_internal.variete  | trees_internal.objectid  |               trees_internal.nom_ev                |<br />
+---------------------------------+--------------------------------+-----------------------+------------------------+-------------------------+----------------------------------+-------------------------+-------------------------------+----------------------------------------------------+----------------------------+-------------------------+--------------------------+----------------------------------------------------+<br />
| (48.857140829, 2.29533455314)   | 7                              | Maclura               | pomifera               | Moraceae                | 1935                             | 13.0                    | NULL                          | Quai Branly, avenue de La Motte-Piquet, avenue de  | Oranger des Osages         |                         | 6                        | Parc du Champs de Mars                             |<br />
| (48.8685686134, 2.31331809304)  | 8                              | Calocedrus            | decurrens              | Cupressaceae            | 1854                             | 20.0                    | 195.0                         | Cours-la-Reine, avenue Franklin-D.-Roosevelt, aven | C?dre ? encens             |                         | 11                       | Jardin des Champs Elys?es                          |<br />
| (48.8768191638, 2.33210374339)  | 9                              | Pterocarya            | fraxinifolia           | Juglandaceae            | 1862                             | 22.0                    | 330.0                         | Place d'Estienne-d'Orves                           | P?rocarya du Caucase       |                         | 14                       | Square Etienne d'Orves                             |<br />
| (48.8373323894, 2.40776275516)  | 12                             | Celtis                | australis              | Cannabaceae             | 1906                             | 16.0                    | 295.0                         | 27, boulevard Soult                                | Micocoulier de Provence    |                         | 16                       | Avenue 27 boulevard Soult                          |<br />
| (48.8341842636, 2.46130493573)  | 12                             | Quercus               | petraea                | Fagaceae                | 1784                             | 30.0                    | 430.0                         | route ronde des Minimes                            | Ch?ne rouvre               |                         | 19                       | Bois de Vincennes (lac des minimes)                |<br />
| (48.8325900983, 2.41116455985)  | 12                             | Platanus              | x acerifolia           | Platanaceae             | 1860                             | 45.0                    | 405.0                         | Ile de Bercy                                       | Platane commun             |                         | 21                       | Bois de Vincennes (Ile de Bercy)                   |<br />
| (48.8226749117, 2.33869560229)  | 14                             | Platanus              | x acerifolia           | Platanaceae             | 1840                             | 40.0                    | 580.0                         | Bd Jourdan, avenue Reille, rue Gazan, rue de la Ci | Platane commun             |                         | 26                       | Parc Montsouris                                    |<br />
| (48.8428118006, 2.2972574926)   | 15                             | Alnus                 | glutinosa              | Betulaceae              | 1933                             | 16.0                    | 220.0                         | Rue Th?ophraste-Renaudot, rue L?on-Lhermitte, rue  | Aulne glutineux            |                         | 28                       | Square Saint Lambert                               |<br />
| (48.8717782491, 2.27973325759)  | 16                             | Aesculus              | hippocastanum          | Sapindaceae             | NULL                             | 30.0                    | 505.0                         | Avenue Foch                                        | Marronnier d'Inde          |                         | 30                       | Avenue Foch                                        |<br />
| (48.8802898189, 2.38157469859)  | 19                             | Ginkgo                | biloba                 | Ginkgoaceae             | 1913                             | 33.0                    | 230.0                         | Rue Manin, rue Botzaris                            | Arbre aux quarante ?cus    |                         | 46                       | Parc des Buttes Chaumont                           |<br />
| (48.8820015094, 2.39836942721)  | 19                             | Fraxinus              | excelsior              | Oleaceae                | NULL                             | 30.0                    | 365.0                         | Boulevard d'Alg?rie                                | Fr?ne commun               |                         | 52                       | Square de la Butte du Chapeau Rouge                |<br />
| (48.846044762, 2.2529555706)    | 16                             | Ailanthus             | giraldii               | Simaroubaceae           | NULL                             | 35.0                    | 460.0                         | 3 avenue de la Porte d'Auteuil, 1 avenue Gordon Be | Ailanthe                   |                         | 53                       | Jardin des Serres d'Auteuil                        |<br />
| (48.8606198209, 2.2599223737)   | 16                             | Taxodium              | distichum              | Taxodiaceae             | 1862                             | 35.0                    | 350.0                         | Berge du lac Inf?rieur                             | Cypr?s chauve              |                         | 56                       | Bois de Boulogne (Berge du lac inf?rieur)          |<br />
| (48.8232165418, 2.46016871078)  | 12                             | Diospyros             | kaki                   | Ebenaceae               | NULL                             | 12.0                    | 160.0                         | Route de la Ferme, route de la Pyramide            | Kaki                       |                         | 58                       | Jardin de l' Ecole Du Breuil                       |<br />
| (48.8764503804, 2.25765244347)  | 16                             | Sequoiadendron        | giganteum              | Taxodiaceae             | 1850                             | 30.0                    | NULL                          |                                                    | S?quoia g?ant              |                         | 59                       | Bois de Boulogne (Portes Saint james)              |<br />
| (48.8691485018, 2.27224125103)  | 16                             | Gymnocladus           | dioicus                | Fabaceae                | NULL                             | 10.0                    | 162.0                         |                                                    | Chicot du Canada           |                         | 61                       | Square Schumann                                    |<br />
| (48.8615768444, 2.25902702441)  | 16                             | Fagus                 | sylvatica              | Fagaceae                | 1857                             | 10.0                    | 200.0                         |                                                    | H?tre pleureur             | Pendula                 | 63                       | Bois de Boulogne (petite ?le du Lac Inf?rieur)     |<br />
| (48.8633555664, 2.26174532022)  | 16                             | Pterocarya            | fraxinifolia           | Juglandaceae            | 1882                             | 27.0                    | 400.0                         |                                                    | P?rocarya du Caucase       |                         | 65                       | Bois de Boulogne (Berge du lac inf?rieur)          |<br />
| (48.8646024472, 2.25171449183)  | 16                             | Sequoiadendron        | giganteum              | Taxodiaceae             | 1872                             | NULL                    | 655.0                         | Route de la Grande Cascade, carrefour de la Croix  | S?quoia g?ant              |                         | 67                       | Bois de Boulogne (Pr? Catelan)                     |<br />
| (48.865022534, 2.2538285063)    | 16                             | Pinus                 | nigra                  | Pinaceae                | NULL                             | 30.0                    | 250.0                         | Route de la Grande Cascade, carrefour de la Croix  | Pin noir                   |                         | 69                       | Bois de Boulogne (Pr? Catelan)                     |<br />
| (48.8704017043, 2.24852577475)  | 16                             | Platanus              | orientalis             | Platanaceae             | 1843                             | 26.0                    | 340.0                         | All?e de Longchamp, route de S?vres ? Neuilly      | Platane d'Orient           |                         | 73                       | Bois de Boulogne (Bagatelle)                       |<br />
| (48.8347628794, 2.42029690936)  | 12                             | Zelkova               | serrata                | Ulmaceae                | 1872                             | 18.0                    | 240.0                         |                                                    | Zelkova du Japon           |                         | 83                       | Bois de Vincennes (Ecole chiens guide d'aveugle)   |<br />
| (48.8333849101, 2.41261756721)  | 12                             | Juglans               | nigra                  | Juglandaceae            | 1845                             | 28.0                    | 570.0                         | route de la ceinture du Lac Daumesnil              | Noyer noir                 |                         | 85                       | Bois de Vincennes (Lac Daumesnil/porte Dor?e)      |<br />
| (48.8324049718, 2.41169855654)  | 12                             | Taxodium              | distichum              | Taxodiaceae             | 1930                             | 20.0                    | 270.0                         | Ile de Bercy                                       | Cypr?s chauve              |                         | 87                       | Bois de Vincennes (Ile de Bercy)                   |<br />
| (48.8213214388, 2.45537251962)  | 12                             | Pinus                 | bungeana               | Pinaceae                | NULL                             | 10.0                    | 50.0                          | Route de la Ferme, route de la Pyramide            | Pin Napol?on               |                         | 95                       | Arboretum Ecole du Breuil                          |<br />
| (48.8204495642, 2.44579219199)  | 12                             | Pinus                 | nigra                  | Pinaceae                | 1870                             | 25.0                    | 248.0                         | route de la Tourelle, route du Point de Vue        | Pin noir                   | Austriaca               | 97                       | Bois de Vincennes (lac de gravelle)                |<br />
| (48.8520958913, 2.34740754195)  | 5                              | Robinia               | pseudoacacia           | Fabaceae                | 1601                             | 11.0                    | 385.0                         | Quai de Montebello, rue Lagrange, rue Saint-Julien | Robinier faux-acacia       |                         | 4                        | Square Viviani                                     |<br />
| (48.8578717375, 2.29706549763)  | 7                              | Eucommia              | ulmoides               | Eucomiaceae             | NULL                             | 12.0                    | 190.0                         | Quai Branly, avenue de La Motte-Piquet, avenue de  | Arbre ? gutta-percha       |                         | 7                        | Parc du Champs de Mars                             |<br />
| (48.8792159582, 2.30640768208)  | 8                              | Ginkgo                | biloba                 | Ginkgoaceae             | 1879                             | 22.0                    | 283.0                         | Boulevard de Courcelles, avenue V?lasquez, avenue  | Arbre aux quarante ?cus    |                         | 10                       | Parc Monceau                                       |<br />
| (48.8669690843, 2.31951408752)  | 8                              | Sequoiadendron        | giganteum              | Taxodiaceae             | 1850                             | 20.0                    | 320.0                         | Cours-la-Reine, avenue Franklin-D.-Roosevelt, aven | S?quoia g?ant              |                         | 12                       | Jardin des Champs Elys?es                          |<br />
| (48.8353848188, 2.38157245444)  | 12                             | Platanus              | x acerifolia           | Platanaceae             | NULL                             | 35.0                    | 510.0                         | Rue Paul-Belmondo, rue Joseph-Kessel, rue de l'Amb | Platane commun             |                         | 17                       | Parc de Bercy                                      |<br />
| (48.8330496955, 2.35078878768)  | 13                             | Aesculus              | hippocastanum          | Sapindaceae             | 1894                             | 18.0                    | 355.0                         | Rue Croulebarbe, rue Corvisart, rue Emile-Deslandr | Marronnier d'Inde          |                         | 23                       | Square Ren? Le Gall                                |<br />
| (48.8224956954, 2.3366608746)   | 14                             | Fagus                 | sylvatica              | Fagaceae                | NULL                             | 30.0                    | 370.0                         | Bd Jourdan, avenue Reille, rue Gazan, rue de la Ci | H?tre pourpre              | Purpurea                | 25                       | Parc Montsouris                                    |<br />
| (48.8220238534, 2.33628540112)  | 14                             | Sequoia               | sempervirens           | Taxodiaceae             | 1935                             | 30.0                    | 335.0                         | Bd Jourdan, avenue Reille, rue Gazan, rue de la Ci | S?quoia sempervirent       |                         | 27                       | Parc Montsouris                                    |<br />
| (48.8814628758, 2.38367383179)  | 19                             | Styphnolobium         | japonicum              | Fabaceae                | 1873                             | 10.0                    | 335.0                         | Rue Manin, rue Botzaris                            | Sophora du Japon           |                         | 44                       | Parc des Buttes Chaumont                           |<br />
| (48.8803986732, 2.38129958306)  | 19                             | Platanus              | orientalis             | Platanaceae             | 1862                             | 34.0                    | 670.0                         | Rue Manin, rue Botzaris                            | Platane d'Orient           |                         | 45                       | Parc des Buttes Chaumont                           |<br />
| (48.8619346483, 2.39870061217)  | 20                             | Acer                  | monspessulanum         | Sapindacaees            | 1833                             | 12.0                    | 225.0                         | Rue du repos, rue des Rondeaux                     | Erable de Montpellier      |                         | 48                       | Cimeti?re du P?re Lachaise                         |<br />
| (48.879759998, 2.38064802989)   | 19                             | Sequoiadendron        | giganteum              | Taxodiaceae             | NULL                             | 35.0                    | 470.0                         | Rue Manin, rue Botzaris                            | S?quoia g?ant              |                         | 57                       | Parc des Buttes Chaumont                           |<br />
| (48.8640166469, 2.26774597209)  | 16                             | Fagus                 | sylvatica              | Fagaceae                | NULL                             | 18.0                    | 300.0                         |                                                    | H?tre pourpre              | Purpurea                | 60                       | Stade Muette                                       |<br />
| (48.8647824278, 2.25120424857)  | 16                             | Diospyros             | kaki                   | Ebenaceae               | 1897                             | 14.0                    | 145.0                         | Route de la Grande Cascade, carrefour de la Croix  | Kaki                       |                         | 68                       | Bois de Boulogne (Pr? Catelan)                     |<br />
| (48.8693939056, 2.24776773334)  | 16                             | Sequoiadendron        | giganteum              | Taxodiaceae             | 1850                             | 30.0                    | 490.0                         | All?e de Longchamp, route de S?vres ? Neuilly      | S?quoia g?ant              |                         | 72                       | Bois de Boulogne (Bagatelle)                       |<br />
| (48.867043584, 2.25320074406)   | 16                             | Platanus              | x acerifolia           | Platanaceae             | 1872                             | 40.0                    | 520.0                         | Route du Lac ? Bagatelle                           | Platane commun             |                         | 74                       | Bois de Boulogne (Route du Lac ? Bagatelle)        |<br />
| (48.8630909172, 2.24159242682)  | 16                             | Pinus                 | nigra laricio          | Pinaceae                | 1882                             | 30.0                    | 240.0                         | All?e de Longchamp, carrefour des cascades         | Pin de Corse               |                         | 76                       | Bois de Boulogne (r?servoir de la cascade)         |<br />
| (48.8632834941, 2.24066981564)  | 16                             | Taxodium              | distichum              | Taxodiaceae             | 1859                             | 30.0                    | 290.0                         | All?e de Longchamp, carrefour des cascades         | Cypr?s chauve              |                         | 77                       | Bois de Boulogne (Grande Cascade)                  |<br />
| (48.8400020891, 2.46422657197)  | 12                             | Acer                  | cappadocicum           | Sapindaceae             | 1900                             | 16.0                    | 280.0                         | avenue de la Belle Gabrielle                       | Erable de Cappadoce        |                         | 78                       | Bois de Vincennes (pelouse de Fontenay)            |<br />
| (48.8394165343, 2.43360205128)  | 12                             | Liriodendron          | tulipifera             | Magnoliaceae            | 1862                             | 35.0                    | 305.0                         | avenue Daumesnil, Esplanade du Ch?teau de Vincenne | Tulipier de Virginie       |                         | 81                       | Bois de Vincennes (square Carnot)                  |<br />
| (48.8319232533, 2.41202933239)  | 12                             | Liriodendron          | tulipifera             | Magnoliaceae            | 1930                             | 22.0                    | 205.0                         | Ile de Bercy                                       | Tulipier de Virginie       |                         | 88                       | Bois de Vincennes (Ile de Bercy)                   |<br />
| (48.8320684332, 2.41182825531)  | 12                             | Taxus                 | baccata                | Taxaceae                | 1870                             | 5.0                     | 140.0                         | Ile de Bercy                                       | If commun                  |                         | 89                       | Bois de Vincennes (Ile de Bercy)                   |<br />
| (48.8292071873, 2.41301158121)  | 12                             | Platanus              | x acerifolia           | Platanaceae             | 1871                             | 25.0                    | 490.0                         | route de la ceinture du Lac Daumesnil              | Platane commun             |                         | 92                       | Bois de Vincennes (lac daumesnil)                  |<br />
| (48.8400754064, 2.43381509843)  | 12                             | Diospyros             | virginiana             | Ebenaceae               | 1875                             | 14.0                    | 180.0                         | avenue Daumesnil, Esplanade du Ch?teau de Vincenne | Plaqueminier de Virginie   |                         | 94                       | Bois de Vincennes (square Carnot)                  |<br />
| (48.8183933679, 2.43791766754)  | 12                             | Quercus               | ilex                   | Fagaceae                | 1860                             | 15.0                    | NULL                          | route de Gravelle, route du Mar?chal Leclerc (Sain | Ch?ne vert                 |                         | 98                       | Bois de Vincennes (pente de Gravelle)              |<br />
| (48.8557581795, 2.35399582218)  | 4                              | Ulmus                 | carpinifolia           | Ulmaceae                | 1935                             | 15.0                    | 180.0                         | Place St Gervais                                   | Orme champ?tre             |                         | 2                        | Place Saint Gervais                                |<br />
| (48.8453050031, 2.35307565328)  | 5                              | Fagus                 | sylvatica              | Fagaceae                | 1905                             | 2.0                     | 72.0                          | Rue des Ar?nes, rue de Navarre, rue Monge          | Faux de Verzy              | Tortuosa                | 3                        | Square des Ar?nes de Lut?ce                        |<br />
| (48.8618464812, 2.37910176561)  | 11                             | Corylus               | colurna                | Betulaceae              | 1879                             | 20.0                    | 245.0                         | Rue Lacharri?re, rue Rochebrune, rue du G?n?ral-Gu | Noisetier de Byzance       |                         | 15                       | Square Maurice Gardette                            |<br />
| (48.8420426954, 2.43848438671)  | 12                             | Fagus                 | sylvatica              | Fagaceae                | 1895                             | 23.0                    | 370.0                         | Cours Marigny                                      | H?tre pourpre              | Purpurea                | 18                       | Bois de Vincennes (Cours Marigny)                  |<br />
| (48.8201249835, 2.44524393613)  | 12                             | Cedrus                | libanii                | Pinaceae                | 1829                             | 30.0                    | 440.0                         | route de la Tourelle, route du Point de Vue        | C?dre du Liban             |                         | 22                       | Bois de Vincennes (lac de Gravelle)                |<br />
| (48.8471789821, 2.25293802515)  | 16                             | Quercus               | suber                  | Fagaceae                | 1895                             | 10.0                    | 180.0                         | 3 avenue de la Porte d'Auteuil, 1 avenue Gordon Be | Ch?ne li?ge                |                         | 32                       | Jardin des Serres d'Auteuil                        |<br />
| (48.8450859307, 2.26948936839)  | 16                             | Broussonetia          | papyrifera             | Moraceae                | NULL                             | 12.0                    | 190.0                         | Rue Mirabeau, avenue de Versailles                 | Murier ? papier            |                         | 33                       | Parc Sainte Perinne                                |<br />
| (48.8634848878, 2.2403752961)   | 16                             | Cedrus                | libanii                | Pinaceae                | 1862                             | 30.0                    | 460.0                         | All?e de Longchamp, carrefour des cascades         | C?dre du Liban             |                         | 37                       | Bois de Boulogne (r?servoir de la grande cascade)  |<br />
| (48.8845880534, 2.34391859224)  | 18                             | Platanus              | orientalis             | Platanaceae             | 1857                             | 27.0                    | 470.0                         | Place Saint-Pierre, rue Ronsard, rue Paul-Albert,  | Platane d'Orient           |                         | 42                       | Square Louise Michel                               |<br />
| (48.8830346813, 2.37007425143)  | 19                             | Tilia                 | tomentosa              | Malvaceae               | 1945                             | 20.0                    | 205.0                         | Place Stalingrad                                   | Tilleul argent?            |                         | 43                       | Place de la bataille de Stalingrad                 |<br />
| (48.85646631, 2.39469777758)    | 20                             | Platanus              | x acerifolia           | Platanaceae             | 1880                             | 20.0                    | 395.0                         | 148 boulevard de Charonne                          | Platane commun             |                         | 51                       | Alignement 148 boulevard de Charonne               |<br />
| (48.8471653404, 2.25199572129)  | 16                             | Pterocarya            | stenoptera             | Juglandaceae            | 1905                             | 30.0                    | 530.0                         | 3 avenue de la Porte d'Auteuil, 1 avenue Gordon Be | Pt?rocarya de Chine        |                         | 54                       | Jardin des Serres d'Auteuil                        |<br />
| (48.867221687, 2.27027693483)   | 16                             | Cedrus                | atlantica              | Pinaceae                | NULL                             | 6.0                     | 195.0                         |                                                    | C?dre bleu de l'Atlas ple  | Glauca pendula          | 62                       | Square Debussy                                     |<br />
| (48.8731203887, 2.24884917245)  | 16                             | Fagus                 | sylvatica              | Fagaceae                | 1868                             | 15.0                    | 230.0                         | All?e de Longchamp, route de S?vres ? Neuilly      | H?tre pleureur             | Pendula                 | 70                       | Bois de Boulogne (Bagatelle)                       |<br />
| (48.8732545226, 2.24886543775)  | 16                             | Davidia               | involucrata            | Cornaceae               | 1906                             | 12.0                    | 120.0                         | All?e de Longchamp, route de S?vres ? Neuilly      | Arbre aux pochettes        |                         | 71                       | Bois de Boulogne (Bagatelle)                       |<br />
| (48.8433252639, 2.4497117757)   | 12                             | Quercus               | petraea                | Fagaceae                | 1815                             | 31.0                    | 450.0                         |                                                    | Ch?ne rouve                |                         | 80                       | Bois de Vincennes (fort neuf)                      |<br />
| (48.8323806372, 2.41052012477)  | 12                             | Platanus              | x acerifolia           | Platanaceae             | 1860                             | 42.0                    | 405.0                         | Ile de Bercy                                       | Platane commun             |                         | 90                       | Bois de Vincennes (Ile de Bercy)                   |<br />
| (48.8314334738, 2.4115101993)   | 12                             | Diospyros             | virginiana             | Ebenaceae               | 1935                             | 12.0                    | NULL                          | Ile de Bercy                                       | Plaqueminier de Virginie   |                         | 93                       | Bois de Vincennes (Ile de Bercy)                   |<br />
| (48.8210086122, 2.45551492936)  | 12                             | Pinus                 | coulteri               | Pinaceae                | NULL                             | 14.0                    | 225.0                         | Route de la Ferme, route de la Pyramide            | Pin aux grands c?nes       |                         | 96                       | Arboretum Ecole du Breuil                          |<br />
| (48.8785456147, 2.30757576047)  | 8                              | Platanus              | orientalis             | Platanaceae             | 1814                             | 31.0                    | 700.0                         | Boulevard de Courcelles, avenue V?lasquez, avenue  | Platane d'Orient           |                         | 9                        | Parc Monceau                                       |<br />
| (48.8652536076, 2.31333976248)  | 8                              | Platanus              | orientalis             | Platanaceae             | 1900                             | 20.0                    | 480.0                         | Cours-la-Reine, avenue Franklin-D.-Roosevelt, aven | Platane d'Orient           |                         | 13                       | Jardin des Champs Elys?es                          |<br />
| (48.8476260928, 2.25278179131)  | 16                             | Ginkgo                | biloba                 | Ginkgoaceae             | 1895                             | 25.0                    | 395.0                         | 3 avenue de la Porte d'Auteuil, 1 avenue Gordon Be | Arbre aux quarante ?cus    |                         | 31                       | Jardin des Serres d'Auteuil                        |<br />
| (48.861574817, 2.2910717819)    | 16                             | Corylus               | colurna                | Betulaceae              | NULL                             | 20.0                    | 260.0                         | Place du Trocad?ro et du 11 Novembre, rue Benjamin | Noisetier de Byzance       |                         | 34                       | Jardin du Trocad?ro                                |<br />
| (48.8708601366, 2.24769299518)  | 16                             | Taxus                 | baccata                | Taxaceae                | 1772                             | 13.0                    | 235.0                         | All?e de Longchamp, route de S?vres ? Neuilly      | If commun                  |                         | 36                       | Bois de Boulogne (Bagatelle)                       |<br />
| (48.8646850734, 2.25360607406)  | 16                             | Fagus                 | sylvatica              | Fagaceae                | 1782                             | 30.0                    | 558.0                         | Route de la Grande Cascade, carrefour de la Croix  | H?tre pourpre              | Purpurea                | 38                       | Bois de Boulogne (Pr? Catelan)                     |<br />
| (48.8880577555, 2.31595908796)  | 17                             | Platanus              | x acerifolia           | Platanaceae             | 1840                             | 30.0                    | 595.0                         | Place Charles Filion, rue Cardinet                 | Platane commun             |                         | 41                       | Square des Batignolles                             |<br />
| (48.8597396934, 2.39997847741)  | 20                             | Aesculus              | hippocastanum          | Sapindaceae             | NULL                             | 22.0                    | 345.0                         | Rue du repos, rue des Rondeaux                     | Marronnier d'Inde          |                         | 47                       | Cimeti?re du P?re Lachaise                         |<br />
| (48.8622517606, 2.26098883991)  | 16                             | Ginkgo                | biloba                 | Ginkgoaceae             | 1893                             | 18.0                    | 215.0                         |                                                    | Arbre aux quarante ?cus    |                         | 64                       | Bois de Boulogne (Berge du lac inf?rieur)          |<br />
| (48.8336849895, 2.42111102704)  | 12                             | Ginkgo                | biloba                 | Ginkgoaceae             | 1865                             | 25.0                    | 255.0                         |                                                    | Arbre aux quarante ?cus    |                         | 84                       | Bois de Vincennes (Ecole chiens guide d'aveugle)   |<br />
| (48.8648376291, 2.36062929978)  | 3                              | Corylus               | colurna                | Betulaceae              | 1882                             | 20.0                    | 210.0                         | Rue du Temple, rue de Bretagne, Rue Perr?e, rue Eu | Noisetier de Byzance       |                         | 1                        | Square du Temple                                   |<br />
| (48.856902513, 2.33666989768)   | 6                              | Catalpa               | bignonioides           | Bignoniaceae            | NULL                             | 15.0                    | 260.0                         | Rue de Seine, rue Mazarine                         | Catalpa commun             |                         | 5                        | Square Gabriel Piern?                              |<br />
| (48.8577766649, 2.29329076205)  | 7                              | Platanus              | orientalis             | Platanaceae             | 1814                             | 20.0                    | 700.0                         | Quai Branly, avenue de La Motte-Piquet, avenue de  | Platane d'Orient           |                         | 8                        | Parc du Champs de Mars                             |<br />
| (48.8399672948, 2.43375148978)  | 12                             | Fagus                 | sylvatica              | Fagaceae                | 1865                             | 20.0                    | 530.0                         | avenue Daumesnil, Esplanade du Ch?teau de Vincenne | H?tre pleureur             | Pendula                 | 20                       | Bois de Vincennes (square Carnot)                  |<br />
| (48.827737189, 2.3592096955)    | 13                             | Cedrus                | atlantica              | Pinaceae                | 1939                             | 25.0                    | 350.0                         | 128-160 avenue de Choisy, rue Georges-Eastman, rue | C?dre bleu de l'Atlas      | Glauca                  | 24                       | Parc de Choisy                                     |<br />
| (48.8723867386, 2.27912885453)  | 16                             | Zelkova               | carpinifolia           | Ulmaceae                | 1852                             | 30.0                    | 395.0                         | Avenue Foch                                        | Faux orme de Sib?rie       |                         | 29                       | Avenue Foch                                        |<br />
| (48.8619170093, 2.2924448277)   | 16                             | Paulownia             | tomentosa              | Paulowniaceae           | NULL                             | 20.0                    | 420.0                         | Place du Trocad?ro et du 11 Novembre, rue Benjamin | Paulownia                  |                         | 35                       | Jardin du Trocad?ro                                |<br />
| (48.8716117578, 2.24933653506)  | 16                             | Araucaria             | araucana               | Araucariaceae           | 1907                             | 9.0                     | 140.0                         | All?e de Longchamp, route de S?vres ? Neuilly      | D?sespoir du singe         |                         | 39                       | Bois de Boulogne (Bagatelle)                       |<br />
| (48.8691433358, 2.24587597613)  | 16                             | Platanus              | x acerifolia           | Platanaceae             | 1847                             | 40.0                    | 480.0                         | All?e de Longchamp, route de S?vres ? Neuilly      | Platane commun             |                         | 40                       | Bois de Boulogne (Bagatelle)                       |<br />
| (48.8661956075, 2.26238964912)  | 16                             | Platanus              | orientalis             | Platanaceae             | 1859                             | 25.0                    | 375.0                         | Ile du lac inf?rieur                               | Platane d'Orient           |                         | 49                       | Bois de Boulogne (?le du lac inf?rieur)            |<br />
| (48.8215800145, 2.45494779675)  | 12                             | Zelkova               | carpinifolia           | Ulmaceae                | NULL                             | 12.0                    | 245.0                         | Route de la Ferme, route de la Pyramide            | Faux orme de Sib?rie       |                         | 50                       | Arboretum de Ecole du Breuil                       |<br />
| (48.8727584235, 2.2873548507)   | 16                             | Platanus              | x acerifolia           | Platanaceae             | 1852                             | 30.0                    | 525.0                         | Avenue Foch                                        | Platane commun             |                         | 55                       | Avenue Foch                                        |<br />
| (48.8588189763, 2.25832952119)  | 16                             | Magnolia              | grandiflora            | Magnoliaceae            | 1863                             | 12.0                    | NULL                          | All?e de Longchamp, carrefour des cascades         | Magnolia ? grandes fleurs  |                         | 66                       | Bois de Boulogne (Berge du lac inf?rieur)          |<br />
| (48.86260617, 2.23782412563)    | 16                             | Zelkova               | carpinifolia           | Ulmaceae                | 1896                             | 16.0                    | 260.0                         |                                                    | Faux orme de Sib?rie       |                         | 75                       | Bois de Boulogne (Moulin de Longchamp)             |<br />
| (48.8395160905, 2.43350820893)  | 12                             | Platanus              | x acerifolia           | Platanaceae             | 1918                             | 32.0                    | 570.0                         | avenue Daumesnil, Esplanade du Ch?teau de Vincenne | Platane commun             |                         | 82                       | Bois de Vincennes (Square Carnot)                  |<br />
| (48.833545551, 2.41033694606)   | 12                             | Platanus              | orientalis             | Platanaceae             | 1860                             | 22.0                    | 475.0                         | route de la ceinture du Lac Daumesnil              | Platane d'Orient           |                         | 86                       | Bois de Vincennes (Lac Daumesnil/porte Dor?e)      |<br />
| (48.8302532096, 2.41400587444)  | 12                             | Acer                  | opalus                 | Sapindaceae             | 1870                             | 15.0                    | 160.0                         | Ile de Bercy                                       | Erable d'Italie            |                         | 91                       | Bois de Vincennes (Ile de Bercy)                   |<br />
+---------------------------------+--------------------------------+-----------------------+------------------------+-------------------------+----------------------------------+-------------------------+-------------------------------+----------------------------------------------------+----------------------------+-------------------------+--------------------------+----------------------------------------------------+<br />


### 1.3 Create queries 

* displays the list of district containing trees
> Querie : `select distinct arrondissement from trees_internal ;`
> Trace :
+-----------------+<br />
| arrondissement  |<br />
+-----------------+<br />
| 7               |<br />
| 8               |<br />
| 9               |<br />
| 12              |<br />
| 14              |<br />
| 15              |<br />
| 16              |<br />
| 19              |<br />
| 5               |<br />
| 13              |<br />
| 20              |<br />
| 4               |<br />
| 11              |<br />
| 18              |<br />
| 17              |<br />
| 3               |<br />
| 6               |<br />
+-----------------+<br />
17 rows selected (0.364 seconds)

* displays the list of different species trees
> Querie : `select distinct espece from trees_internal ;`
> Trace :
+-----------------+<br />
|     espece      |<br />
+-----------------+<br />
| pomifera        |<br />
| decurrens       |<br />
| fraxinifolia    |<br />
| australis       |<br />
| petraea         |<br />
| x acerifolia    |<br />
| glutinosa       |<br />
| hippocastanum   |<br />
| biloba          |<br />
| excelsior       |<br />
| giraldii        |<br />
| distichum       |<br />
| kaki            |<br />
| giganteum       |<br />
| dioicus         |<br />
| sylvatica       |<br />
| nigra           |<br />
| orientalis      |<br />
| serrata         |<br />
| bungeana        |<br />
| pseudoacacia    |<br />
| ulmoides        |<br />
| sempervirens    |<br />
| japonicum       |<br />
| monspessulanum  |<br />
| nigra laricio   |<br />
| cappadocicum    |<br />
| tulipifera      |<br />
| baccata         |<br />
| virginiana      |<br />
| ilex            |<br />
| carpinifolia    |<br />
| colurna         |<br />
| libanii         |<br />
| suber           |<br />
| papyrifera      |<br />
| tomentosa       |<br />
| stenoptera      |<br />
| atlantica       |<br />
| involucrata     |<br />
| coulteri        |<br />
| bignonioides    |<br />
| araucana        |<br />
| grandiflora     |<br />
| opalus          |<br />
+-----------------+<br />
45 rows selected (0.262 seconds)<br />

* the number of trees of each kind
> Querie : `select espece, count(espece) from trees_internal group by espece ;`
> Trace :
+-----------------+-----------------+<br />
|     espece      |  count(espece)  |<br />
+-----------------+-----------------+<br />
| pomifera        | 1               |<br />
| decurrens       | 1               |<br />
| fraxinifolia    | 2               |<br />
| australis       | 1               |<br />
| petraea         | 2               |<br />
| x acerifolia    | 11              |<br />
| glutinosa       | 1               |<br />
| hippocastanum   | 3               |<br />
| biloba          | 5               |<br />
| excelsior       | 1               |<br />
| giraldii        | 1               |<br />
| distichum       | 3               |<br />
| kaki            | 2               |<br />
| giganteum       | 5               |<br />
| dioicus         | 1               |<br />
| sylvatica       | 8               |<br />
| nigra           | 3               |<br />
| orientalis      | 8               |<br />
| serrata         | 1               |<br />
| bungeana        | 1               |<br />
| pseudoacacia    | 1               |<br />
| ulmoides        | 1               |<br />
| sempervirens    | 1               |<br />
| japonicum       | 1               |<br />
| monspessulanum  | 1               |<br />
| nigra laricio   | 1               |<br />
| cappadocicum    | 1               |<br />
| tulipifera      | 2               |<br />
| baccata         | 2               |<br />
| virginiana      | 2               |<br />
| ilex            | 1               |<br />
| carpinifolia    | 4               |<br />
| colurna         | 3               |<br />
| libanii         | 2               |<br />
| suber           | 1               |<br />
| papyrifera      | 1               |<br />
| tomentosa       | 2               |<br />
| stenoptera      | 1               |<br />
| atlantica       | 2               |<br />
| involucrata     | 1               |<br />
| coulteri        | 1               |<br />
| bignonioides    | 1               |<br />
| araucana        | 1               |<br />
| grandiflora     | 1               |<br />
| opalus          | 1               |<br />
+-----------------+-----------------+<br />

* calculates the height of the tallest tree of each kind
> Querie : `select max(hauteur), espece from trees_internal group by hauteur ;`
> Trace :
+----------+-----------------+<br />
| hauteur  |     espece      |<br />
+----------+-----------------+<br />
| 13.0     | pomifera        |<br />
| 20.0     | decurrens       |<br />
| 16.0     | australis       |<br />
| 45.0     | x acerifolia    |<br />
| 16.0     | glutinosa       |<br />
| 30.0     | hippocastanum   |<br />
| 33.0     | biloba          |<br />
| 30.0     | excelsior       |<br />
| 35.0     | giraldii        |<br />
| 35.0     | distichum       |<br />
| 10.0     | dioicus         |<br />
| 27.0     | fraxinifolia    |<br />
| 30.0     | nigra           |<br />
| 18.0     | serrata         |<br />
| 10.0     | bungeana        |<br />
| 11.0     | pseudoacacia    |<br />
| 12.0     | ulmoides        |<br />
| 30.0     | sylvatica       |<br />
| 30.0     | sempervirens    |<br />
| 10.0     | japonicum       |<br />
| 34.0     | orientalis      |<br />
| 12.0     | monspessulanum  |<br />
| 35.0     | giganteum       |<br />
| 14.0     | kaki            |<br />
| 30.0     | nigra laricio   |<br />
| 16.0     | cappadocicum    |<br />
| 35.0     | tulipifera      |<br />
| 14.0     | virginiana      |<br />
| 15.0     | ilex            |<br />
| 10.0     | suber           |<br />
| 12.0     | papyrifera      |<br />
| 30.0     | libanii         |<br />
| 20.0     | tomentosa       |<br />
| 30.0     | stenoptera      |<br />
| 12.0     | involucrata     |<br />
| 31.0     | petraea         |<br />
| 14.0     | coulteri        |<br />
| 13.0     | baccata         |<br />
| 20.0     | colurna         |<br />
| 15.0     | bignonioides    |<br />
| 25.0     | atlantica       |<br />
| 30.0     | carpinifolia    |<br />
| 9.0      | araucana        |<br />
| 12.0     | grandiflora     |<br />
| 15.0     | opalus          |<br />
+----------+-----------------+<br />

* sort the trees height from smallest to largest
> Querie : `select hauteur, espece from trees_internal order by hauteur ;`
> Trace :
+----------+-----------------+<br />
| hauteur  |     espece      |<br />
+----------+-----------------+<br />
| 2.0      | sylvatica       |<br />
| 5.0      | baccata         |<br />
| 6.0      | atlantica       |<br />
| 9.0      | araucana        |<br />
| 10.0     | dioicus         |<br />
| 10.0     | sylvatica       |<br />
| 10.0     | bungeana        |<br />
| 10.0     | japonicum       |<br />
| 10.0     | suber           |<br />
| 11.0     | pseudoacacia    |<br />
| 12.0     | kaki            |<br />
| 12.0     | ulmoides        |<br />
| 12.0     | monspessulanum  |<br />
| 12.0     | papyrifera      |<br />
| 12.0     | involucrata     |<br />
| 12.0     | virginiana      |<br />
| 12.0     | carpinifolia    |<br />
| 12.0     | grandiflora     |<br />
| 13.0     | pomifera        |<br />
| 13.0     | baccata         |<br />
| 14.0     | kaki            |<br />
| 14.0     | virginiana      |<br />
| 14.0     | coulteri        |<br />
| 15.0     | ilex            |<br />
| 15.0     | carpinifolia    |<br />
| 15.0     | sylvatica       |<br />
| 15.0     | bignonioides    |<br />
| 15.0     | opalus          |<br />
| 16.0     | australis       |<br />
| 16.0     | glutinosa       |<br />
| 16.0     | cappadocicum    |<br />
| 16.0     | carpinifolia    |<br />
| 18.0     | serrata         |<br />
| 18.0     | hippocastanum   |<br />
| 18.0     | sylvatica       |<br />
| 18.0     | biloba          |<br />
| 20.0     | decurrens       |<br />
| 20.0     | distichum       |<br />
| 20.0     | giganteum       |<br />
| 20.0     | colurna         |<br />
| 20.0     | tomentosa       |<br />
| 20.0     | x acerifolia    |<br />
| 20.0     | orientalis      |<br />
| 20.0     | colurna         |<br />
| 20.0     | colurna         |<br />
| 20.0     | orientalis      |<br />
| 20.0     | sylvatica       |<br />
| 20.0     | tomentosa       |<br />
| 22.0     | fraxinifolia    |<br />
| 22.0     | biloba          |<br />
| 22.0     | tulipifera      |<br />
| 22.0     | hippocastanum   |<br />
| 22.0     | orientalis      |<br />
| 23.0     | sylvatica       |<br />
| 25.0     | nigra           |<br />
| 25.0     | x acerifolia    |<br />
| 25.0     | biloba          |<br />
| 25.0     | biloba          |<br />
| 25.0     | atlantica       |<br />
| 25.0     | orientalis      |<br />
| 26.0     | orientalis      |<br />
| 27.0     | fraxinifolia    |<br />
| 27.0     | orientalis      |<br />
| 28.0     | nigra           |<br />
| 30.0     | petraea         |<br />
| 30.0     | hippocastanum   |<br />
| 30.0     | excelsior       |<br />
| 30.0     | giganteum       |<br />
| 30.0     | nigra           |<br />
| 30.0     | sylvatica       |<br />
| 30.0     | sempervirens    |<br />
| 30.0     | giganteum       |<br />
| 30.0     | nigra laricio   |<br />
| 30.0     | distichum       |<br />
| 30.0     | libanii         |<br />
| 30.0     | libanii         |<br />
| 30.0     | stenoptera      |<br />
| 30.0     | sylvatica       |<br />
| 30.0     | x acerifolia    |<br />
| 30.0     | carpinifolia    |<br />
| 30.0     | x acerifolia    |<br />
| 31.0     | petraea         |<br />
| 31.0     | orientalis      |<br />
| 32.0     | x acerifolia    |<br />
| 33.0     | biloba          |<br />
| 34.0     | orientalis      |<br />
| 35.0     | giraldii        |<br />
| 35.0     | distichum       |<br />
| 35.0     | x acerifolia    |<br />
| 35.0     | giganteum       |<br />
| 35.0     | tulipifera      |<br />
| 40.0     | x acerifolia    |<br />
| 40.0     | x acerifolia    |<br />
| 40.0     | x acerifolia    |<br />
| 42.0     | x acerifolia    |<br />
| 45.0     | x acerifolia    |<br />
| NULL     | giganteum       |<br />
+----------+-----------------+<br />


* displays the district where the oldest tree is
> Querie : `select arrondissement, annee_plantation from trees_internal where (annee_plantation = min(annee_plantation)) ; `
> Trace :
+-----------------+-------------------+<br />
| arrondissement  | annee_plantation  |<br />
+-----------------+-------------------+<br />
| 5               | 1601              |<br />
+-----------------+-------------------+<br />

* display the district that contains the most trees
> Querie : ` select arrondissement, espece from (select arrondissement, espece, count(arrondissement) as va from internal_trees group by arrondissement order by count(arrondissement) desc) as nb limit 1`
> Trace :
+-----------------+-----------------+<br />
| arrondissement  |     espece      |<br />
+-----------------+-----------------+<br />
| 12              | x acerifolia    |<br />
+-----------------+-----------------+<br />
