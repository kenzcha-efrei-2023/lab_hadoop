# TP yarn mapreduce 2
#### Charlotte Mauvezin
#### Kenza Tazi

Installation of jdk, cloning original project

```
brew tap AdoptOpenJDK/openjdk
brew install adoptopenjdk8 
cd IdeaProjects
git clone https://github.com/makayel/hadoop-examples-mapreduce
```
Exporting .jar

```
cd target 
mv hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar myjar.jar
scp myjar.jar k.tazi@hadoop-edge01.efrei.online:/home/k.tazi
```

Arrondissements that contains trees :

Mapper :

```
public class ArrMapper extends Mapper<Object, Text, Text, Text> {

    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {
        String arrondissement = value.toString().split(";")[1];
        context.write(new Text(arrondissement), new Text("placeholder"));
    }
}

```

Reducer :

```
public class ArrReducer extends Reducer<Text, Text, Text, Text> {

    public void reduce(Text key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {
        context.write(key, new Text("placeholder"));
    }
}
```

Job :

```
public class ArrTrees {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
        if (otherArgs.length < 2) {
            System.err.println("Usage: arrtrees <in> [<in>...] <out>");
            System.exit(2);
        }
        Job job = Job.getInstance(conf, "arrtrees");
        job.setJarByClass(ArrTrees.class);
        job.setMapperClass(ArrMapper.class);
        job.setCombinerClass(ArrReducer.class);
        job.setReducerClass(ArrReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        for (int i = 0; i < otherArgs.length - 1; ++i) {
            FileInputFormat.addInputPath(job, new Path(otherArgs[i]));
        }
        FileOutputFormat.setOutputPath(job,
                new Path(otherArgs[otherArgs.length - 1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}

```

Output :
>yarn jar myjar2.jar arrTrees /user/k.tazi/trees_headless.csv /user/k.tazi/arrtrees5<br />
>[...]<br />
>hdfs dfs -cat arrtrees5/part-r-00000 <br />
 11	placeholder <br />
 12	placeholder <br />
 13	placeholder <br />
 14	placeholder <br />
 15	placeholder <br />
 16	placeholder <br />
 17	placeholder <br />
 18	placeholder <br />
 19	placeholder <br />
 20	placeholder <br />
 3	placeholder <br />
 4	placeholder <br />
 5	placeholder <br />
 6	placeholder <br />
 7	placeholder <br />
 8	placeholder <br />
 9	placeholder <br />


Existing trees :

Mapper :
```
public class ExTreesMapper extends Mapper<Object, Text, Text, Text> {
    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {
        String tree = value.toString().split(";")[3];
        context.write(new Text(tree), new Text("placeholder"));
    }
}
```
Reducer :

Same as the previous job ! See above !

Job :

```
public class ExTrees
{
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
        if (otherArgs.length < 2) {
            System.err.println("Usage: extrees <in> [<in>...] <out>");
            System.exit(2);
        }
        Job job = Job.getInstance(conf, "extrees");
        job.setJarByClass(ExTrees.class);
        job.setMapperClass(ExTreesMapper.class);
        job.setCombinerClass(ArrReducer.class);
        job.setReducerClass(ArrReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        for (int i = 0; i < otherArgs.length - 1; ++i) {
            FileInputFormat.addInputPath(job, new Path(otherArgs[i]));
        }
        FileOutputFormat.setOutputPath(job,
                new Path(otherArgs[otherArgs.length - 1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
```

Output :

> yarn jar myjar3.jar extrees /user/k.tazi/trees_headless.csv /user/k.tazi/extrees2

> hdfs dfs -cat extrees2/part-r-00000
 araucana	placeholder<br />
 atlantica	placeholder<br />
 australis	placeholder<br />
 baccata	placeholder<br />
 bignonioides	placeholder<br />
 biloba	placeholder<br />
 bungeana	placeholder<br />
 cappadocicum	placeholder<br />
 carpinifolia	placeholder<br />
 colurna	placeholder<br />
 coulteri	placeholder<br />
 decurrens	placeholder<br />
 dioicus	placeholder<br />
 distichum	placeholder<br />
 excelsior	placeholder<br />
 fraxinifolia	placeholder<br />
 giganteum	placeholder<br />
 giraldii	placeholder<br />
 glutinosa	placeholder<br />
 grandiflora	placeholder<br />
 hippocastanum	placeholder<br />
 ilex	placeholder<br />
 involucrata	placeholder<br />
 japonicum	placeholder<br />
 kaki	placeholder<br />
 libanii	placeholder<br />
 monspessulanum	placeholder<br />
 nigra	placeholder<br />
 nigra laricio	placeholder<br />
 opalus	placeholder<br />
 orientalis	placeholder<br />
 papyrifera	placeholder<br />
 petraea	placeholder<br />
 pomifera	placeholder<br />
 pseudoacacia	placeholder<br />
 sempervirens	placeholder<br />
 serrata	placeholder<br />
 stenoptera	placeholder<br />
 suber	placeholder<br />
 sylvatica	placeholder<br />
 tomentosa	placeholder<br />
 tulipifera	placeholder<br />
 ulmoides	placeholder<br />
 virginiana	placeholder<br />
 x acerifolia	placeholder<br />

Number of trees of each species :

Mapper :

```
public class NbTreesMapper extends Mapper<Object, Text, Text, IntWritable> {
    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {
        String tree = value.toString().split(";")[3];
        context.write(new Text(tree), new IntWritable(1));

    }
}
```

Reducer :

Used the IntSumReducer, used for wordcount !

Job :

```
public class NbTrees {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
        if (otherArgs.length < 2) {
            System.err.println("Usage: nbtrees <in> [<in>...] <out>");
            System.exit(2);
        }
        Job job = Job.getInstance(conf, "nbtrees");
        job.setJarByClass(NbTrees.class);
        job.setMapperClass(NbTreesMapper.class);
        job.setCombinerClass(IntSumReducer.class);
        job.setReducerClass(IntSumReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        for (int i = 0; i < otherArgs.length - 1; ++i) {
            FileInputFormat.addInputPath(job, new Path(otherArgs[i]));
        }
        FileOutputFormat.setOutputPath(job,
                new Path(otherArgs[otherArgs.length - 1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
```


>[k.tazi@hadoop-edge01 ~]$ hdfs dfs -cat nbtrees/part-r-00000<br />
 araucana	1<br />
 atlantica	2<br />
 australis	1<br />
 baccata	2<br />
 bignonioides	1<br />
 biloba	5<br />
 bungeana	1<br />
 cappadocicum	1<br />
 carpinifolia	4<br />
 colurna	3<br />
 coulteri	1<br />
 decurrens	1<br />
 dioicus	1<br />
 distichum	3<br />
 excelsior	1<br />
 fraxinifolia	2<br />
 giganteum	5<br />
 giraldii	1<br />
 glutinosa	1<br />
 grandiflora	1<br />
 hippocastanum	3<br />
 ilex	1<br />
 involucrata	1<br />
 japonicum	1<br />
 kaki	2<br />
 libanii	2<br />
 monspessulanum	1<br />
 nigra	3<br />
 nigra laricio	1<br />
 opalus	1<br />
 orientalis	8<br />
 papyrifera	1<br />
 petraea	2<br />
 pomifera	1<br />
 pseudoacacia	1<br />
 sempervirens	1<br />
 serrata	1<br />
 stenoptera	1<br />
 suber	1<br />
 sylvatica	8<br />
 tomentosa	2<br />
 tulipifera	2<br />
 ulmoides	1<br />
 virginiana	2<br />
 x acerifolia	11<br />

Max height tree per species :

Mapper :
```
public class ArrHeightMapper extends Mapper<Object, Text, Text, FloatWritable>{

    public void map(Object key, Text value, Mapper.Context context)
            throws IOException, InterruptedException {
        String tree = value.toString().split(";")[3];
        float h = value.toString().split(";")[6].length() > 0 ?
                Float.parseFloat(value.toString().split(";")[6]) :
                (float)0.0;
        context.write(new Text(tree), new FloatWritable(h));
    }
}
```
Reducer :
```
public class MaxReducer extends Reducer<Text, FloatWritable, Text, FloatWritable> {

    public void reduce(Text key, Iterable<FloatWritable> values, Context context)
            throws IOException, InterruptedException {
        float max = -1;
        for (FloatWritable val : values) {
            max = Math.max(val.get(), max);
        }
        context.write(key, new FloatWritable(max));
    }
}

```
Job :
```
public class ArrHeigth {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
        if (otherArgs.length < 2) {
            System.err.println("Usage: arheight <in> [<in>...] <out>");
            System.exit(2);
        }
        Job job = Job.getInstance(conf, "arheight");
        job.setJarByClass(ArrHeigth.class);
        job.setMapperClass(ArrHeightMapper.class);
        job.setCombinerClass(MaxReducer.class);
        job.setReducerClass(MaxReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FloatWritable.class);
        for (int i = 0; i < otherArgs.length - 1; ++i) {
            FileInputFormat.addInputPath(job, new Path(otherArgs[i]));
        }
        FileOutputFormat.setOutputPath(job,
                new Path(otherArgs[otherArgs.length - 1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
```
Output :

>[k.tazi@hadoop-edge01 ~]$ hdfs dfs -cat arheight2/part-r-00000<br />
 araucana	9.0<br />
 atlantica	25.0<br />
 australis	16.0<br />
 baccata	13.0<br />
 bignonioides	15.0<br />
 biloba	33.0<br />
 bungeana	10.0<br />
 cappadocicum	16.0<br />
 carpinifolia	30.0<br />
 colurna	20.0<br />
 coulteri	14.0<br />
 decurrens	20.0<br />
 dioicus	10.0<br />
 distichum	35.0<br />
 excelsior	30.0<br />
 fraxinifolia	27.0<br />
 giganteum	35.0<br />
 giraldii	35.0<br />
 glutinosa	16.0<br />
 grandiflora	12.0<br />
 hippocastanum	30.0<br />
 ilex	15.0<br />
 involucrata	12.0<br />
 japonicum	10.0<br />
 kaki	14.0<br />
 libanii	30.0<br />
 monspessulanum	12.0<br />
 nigra	30.0<br />
 nigra laricio	30.0<br />
 opalus	15.0<br />
 orientalis	34.0<br />
 papyrifera	12.0<br />
 petraea	31.0<br />
 pomifera	13.0<br />
 pseudoacacia	11.0<br />
 sempervirens	30.0<br />
 serrata	18.0<br />
 stenoptera	30.0<br />
 suber	10.0<br />
 sylvatica	30.0<br />
 tomentosa	20.0<br />
 tulipifera	35.0<br />
 ulmoides	12.0<br />
 virginiana	14.0<br />
 x acerifolia	45.0<br />
