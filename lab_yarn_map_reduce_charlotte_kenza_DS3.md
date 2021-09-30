# Big data frameworks

## Efrei 2021-2022
### Kenza Tazi (github ktazi)
### Charlotte Mauvezin (github catsbee)

# Part 1 : YARN

*1.2*

- Executing the command :
`yarn jar /usr/odp/current/hadoop-mapreduce-client/hadoop-mapreduce-examples.jar` 
    will give the output :

    >   An example program must be given as the first argument.
<br />Valid program names are:
  <br />aggregatewordcount: An Aggregate based map/reduce program that counts the words in the input files.
  <br />aggregatewordhist: An Aggregate based map/reduce program that computes the histogram of the words in the input files.
  <br />bbp: A map/reduce program that uses Bailey-Borwein-Plouffe to compute exact digits of Pi.
  <br />dbcount: An example job that count the pageview counts from a database.
  <br />distbbp: A map/reduce program that uses a BBP-type formula to compute exact bits of Pi.
  <br />grep: A map/reduce program that counts the matches of a regex in the input.
  <br />join: A job that effects a join over sorted, equally partitioned datasets
  <br />multifilewc: A job that counts words from several files.
  <br />pentomino: A map/reduce tile laying program to find solutions to pentomino problems.
  <br />pi: A map/reduce program that estimates Pi using a quasi-Monte Carlo method.
  <br />randomtextwriter: A map/reduce program that writes 10GB of random textual data per node.
  <br />randomwriter: A map/reduce program that writes 10GB of random data per node.
  <br />secondarysort: An example defining a secondary sort to the reduce.
  <br />sort: A map/reduce program that sorts the data written by the random writer.
  <br />sudoku: A sudoku solver.
  <br />teragen: Generate data for the terasort
  <br />terasort: Run the terasort
  <br />teravalidate: Checking results of terasort
  <br />wordcount: A map/reduce program that counts the words in the input files.
  <br />wordmean: A map/reduce program that counts the average length of the words in the input files.
  <br />wordmedian: A map/reduce program that counts the median length of the words in the input files.
  <br />wordstandarddeviation: A map/reduce program that counts the standard deviation of the length of the words in the input files.
  
 - executing `yarn jar /usr/odp/current/hadoop-mapreduce-client/hadoop-mapreduce-examples.jar wordcount`
    
    will give the output  :
    
   > Usage: wordcount \<in\> \[\<in\>...] \<out\> 
                                                                                                     
- executing `yarn jar /usr/odp/current/hadoop-mapreduce-client/hadoop-mapreduce-examples.jar wordcount input.txt out`
  then `hdfs dfs -ls out` give the following result :
  
    >Found 2 items <br />                                                                                                                                                                         
    Found 2 items<br />
-rw-r--r--   3 c.mauvezin c.mauvezin          0 2021-09-30 14:49 out/_SUCCESS<br />
-rw-r--r--   3 c.mauvezin c.mauvezin     129593 2021-09-30 14:49 out/part-r-00000 <br />
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
- executing `hdfs dfs -cat ./out/part-r-00000 | tail -n 10`
    >“‘How   1<br />
    “‘I     1<br />
    “‘It    1<br />
    “‘May   1<br />
    “‘Near  1<br />
    “‘No,   1<br />
    “‘No;   1<br />
    “‘That  1<br />
    “‘They  1<br />
    “‘Where 1      <br />                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    

*1.3*

- `yarn jar /usr/odp/current/hadoop-mapreduce-client/hadoop-mapreduce-examples.jar sudoku sudoku.dta`

    > Solving sudoku.dta<br />
8 5 1 3 9 2 6 4 7<br />
4 3 2 6 7 8 1 9 5<br />
7 9 6 5 1 4 3 8 2<br />
6 1 4 8 2 3 7 5 9<br />
5 7 8 9 6 1 4 2 3<br />
3 2 9 4 5 7 8 1 6<br />
9 4 7 2 8 6 5 3 1<br />
1 8 5 7 3 9 2 6 4<br />
2 6 3 1 4 5 9 7 8<br />
Found 1 solutions<br />

-  `yarn  jar  /usr/odp/current/hadoop-mapreduce-client/hadoop-mapreduce-examples.jar pi 16 10000000`

    \[...\]

    >Job Finished in 28.269 seconds<br />
Estimated value of Pi is 3.14159239750000000000
  `hdfs dfs -ls data/10GB-sort-input`
    >Found 3 items<br />
-rw-r--r--   3 c.mauvezin c.mauvezin          0 2021-09-28 14:52 data/10GB-sort-input/_SUCCESS<br />
-rw-r--r--   3 c.mauvezin c.mauvezin 5000000000 2021-09-28 14:52 data/10GB-sort-input/part-m-00000<br />
-rw-r--r--   3 c.mauvezin c.mauvezin 5000000000 2021-09-28 14:52 data/10GB-sort-input/part-m-00001<br />

- `yarn  jar /usr/odp/current/hadoop-mapreduce-client/hadoop-mapreduce-examples.jar terasort -Dmapred.map.tasks=50 -Dmapred.reduce.tasks=25 /user/c.mauvezin/data/10GB-sort-input  /user/c.mauvezin/data/10GB-sort-output`

    `hdfs dfs -ls data/10GB-sort-output`
    > Found 3 items<br />
-rw-r--r--   1 c.mauvezin c.mauvezin           0 2021-09-28 15:07 data/10GB-sort-output/_SUCCESS<br />
-rw-r--r--  10 c.mauvezin c.mauvezin           0 2021-09-28 15:02 data/10GB-sort-output/_partition.lst<br />
-rw-r--r--   1 c.mauvezin c.mauvezin 10000000000 2021-09-28 15:07 data/10GB-sort-output/part-r-00000<br />

- `yarn jar /usr/odp/current/hadoop-mapreduce-client/hadoop-mapreduce-examples.jar teravalidate -Dmapred.map.tasks=50 -Dmapred.reduce.tasks=25 /user/c.mauvezin/data/10GB-sort-output /user/c.mauvezin/data/10GB-sort-validate`
   `hdfs dfs -cat data/10GB-sort-validate/part-r-00000`
    >checksum        2fafbaf537afd49<br />

## Part 2 : MapReduce
*2.3.1*

Here's the content of my mapper.py file :

```
# !/usr/bin/env python

import sys


out = sys.stdout
for  line in sys.stdin:
        # remove leading and trailing whitespace
        while len(line) > 1 and line[0] == ' ' :
                line = line[1:]
        while len(line) > 0 and line[-1] == ' ' :
                line = line[-1]
        # split the line into words
        words = line.split()
        dico = {}
        # increase counters
        for  word in  words:
                if not (word in dico.keys()) :
                        dico[word] = 1
                else :
                        dico[word] += 1
        for entry in dico.keys() :
                out.write(entry+" "+str(dico[entry])+'\n')

```

when testing it, it gives the following output :
>[k.tazi@hadoop-edge01 lab3]$ python mapper.py <br />
bonjour je m'appelle kenza je je je <br />
kenza 1 <br />
je 4 <br />
bonjour 1 <br />
m'appelle 1 <br />


*2.3.2*

Here's the content of my reducer.py file
```
# !/usr/bin/env python
""" reducer.py """

from operator import itemgetter
import sys

current_word = {}
current_count = 0
out = sys.stdout
# input comes from STDIN
for line in sys.stdin :
        # remove leading and trailing whitespace
        while len(line) > 1 and line[0] == ' ' :
                line = line[1:]
        while len(line) > 0 and line[-1] == ' ' :
                line = line[-1]
        # parse the input we got from mapper.py
        words = line.split()
        # add to the current count
        if words[0] in current_word.keys():
                current_word[words[0]] += int(words[1])
        else :
                current_word[words[0]] = int(words[1])
# output the result

for entry in current_word :
        out.write(entry+" "+str(current_word[entry])+'\n')
```

*2.3.3*

Testing the 2 scripts

I created a test file containing the input : 
>[k.tazi@hadoop-edge01 lab3]$ cat test<br />
bonjour je m'appelle kenza tazi<br />
yes yes<br />
bonjour bonjour<br />

The test works !

>[k.tazi@hadoop-edge01 lab3]$ cat test | python mapper.py | sort -k1,1 | python reducer.py<br />
m'appelle 1<br />
tazi 1<br />
kenza 1<br />
je 1<br />
bonjour 3<br />
yes 2<br />

*2.4.1*

>curl https://www.gutenberg.org/cache/epub/20417/pg20417.txt > outline_of_science
curl https://www.gutenberg.org/files/5000/5000-8.txt > notebooks_vinci
curl https://www.gutenberg.org/files/4300/4300-0.txt > ulysses



*2.4.2*

>[k.tazi@hadoop-edge01 lab3]$ hdfs dfs -put ulysses<br />
[k.tazi@hadoop-edge01 lab3]$ hdfs dfs -put notebooks_vinci<br />
[k.tazi@hadoop-edge01 lab3]$ hdfs dfs -put outline_of_science<br />
>[k.tazi@hadoop-edge01 lab3]$ hdfs dfs -mkdir gutenberg<br />
[k.tazi@hadoop-edge01 lab3]$ hdfs dfs -mv ulysses gutenberg<br />
[k.tazi@hadoop-edge01 lab3]$ hdfs dfs -mv notebooks_vinci gutenberg<br />
[k.tazi@hadoop-edge01 lab3]$ hdfs dfs -mv outline_of_science gutenberg<br />

*2.4.3*

>[k.tazi@hadoop-edge01 lab3]$ yarn jar /usr/odp/1.0.3.0-223/hadoop-mapreduce/hadoop-streaming.jar -mapper mapper.py -file /home/k.tazi/mapper.py  -reducer reducer.py -file /home/k.tazi/reducer.py -input /user/k.tazi/gutenberg/* -output /user/k.tazi/gutenberg-out

[...]
>[k.tazi@hadoop-edge01 ~]$ hdfs dfs -ls gutenberg-out<br />
Found 2 items<br />
-rw-r--r--   3 k.tazi k.tazi          0 2021-09-29 18:23 gutenberg-out/_SUCCESS<br />
-rw-r--r--   3 k.tazi k.tazi     969963 2021-09-29 18:23 gutenberg-out/part-00000


*2.4.4*

mapper2.py with iterators:

```
#!/usr/bin/env python

import sys

out = sys.stdout
for line in sys.stdin:
    # remove leading and trailing whitespace
    while len(line) > 1 and line[0] == ' ':
        line = line[1:]
    while len(line) > 0 and line[-1] == ' ':
        line = line[-1]
    # split the line into words
    words = iter(line.split())
    dico = {}
    # increase counters
    for word in words:
        if not (word in dico.keys()):
            dico[word] = 1
        else:
            dico[word] += 1
    for entry in dico.keys():
        out.write(entry + " " + str(dico[entry]) + '\t')

```

reducer2.py with iterators:

```
#!/usr/bin/env python
""" reducer.py """

from operator import itemgetter
import sys

current_word = {}
current_count = 0
out = sys.stdout
# input comes from STDIN
for line in sys.stdin:
    # remove leading and trailing whitespace
    while len(line) > 1 and line[0] == ' ':
        line = line[1:]
    while len(line) > 0 and line[-1] == ' ':
        line = line[-1]
    # parse the input we got from mapper.py
    lis = iter(line.split('\t'))
    # add to the current count
    for w in lis :
        words = w.split()
        if len(words) != 0 :
                if words[0] in current_word.keys():
                         current_word[words[0]] += int(words[1])
                else:
                        current_word[words[0]] = int(words[1])
# output the result
for entry in current_word:
    out.write(entry + " " + str(current_word[entry]) + '\n')
```

comparison between the 2 runtimes :

mapper/reducer 1.0

>21/09/30 11:14:47 INFO mapreduce.Job:  map 0% reduce 0%<br />
21/09/30 11:14:55 INFO mapreduce.Job:  map 100% reduce 0%<br />
21/09/30 11:15:08 INFO mapreduce.Job:  map 100% reduce 69%<br />
21/09/30 11:15:11 INFO mapreduce.Job:  map 100% reduce 70%<br />
21/09/30 11:15:15 INFO mapreduce.Job:  map 100% reduce 71%<br />
21/09/30 11:15:24 INFO mapreduce.Job:  map 100% reduce 72%<br />
21/09/30 11:15:39 INFO mapreduce.Job:  map 100% reduce 73%<br />
21/09/30 11:15:51 INFO mapreduce.Job:  map 100% reduce 74%<br />
21/09/30 11:16:03 INFO mapreduce.Job:  map 100% reduce 75%<br />
21/09/30 11:16:15 INFO mapreduce.Job:  map 100% reduce 76%<br />
21/09/30 11:16:27 INFO mapreduce.Job:  map 100% reduce 77%<br />
21/09/30 11:16:35 INFO mapreduce.Job:  map 100% reduce 78%<br />
21/09/30 11:17:00 INFO mapreduce.Job:  map 100% reduce 79%<br />
21/09/30 11:17:12 INFO mapreduce.Job:  map 100% reduce 80%<br />
21/09/30 11:17:27 INFO mapreduce.Job:  map 100% reduce 81%<br />
21/09/30 11:17:42 INFO mapreduce.Job:  map 100% reduce 82%<br />
21/09/30 11:18:21 INFO mapreduce.Job:  map 100% reduce 83%<br />
21/09/30 11:18:42 INFO mapreduce.Job:  map 100% reduce 84%<br />
21/09/30 11:19:07 INFO mapreduce.Job:  map 100% reduce 85%<br />
21/09/30 11:19:34 INFO mapreduce.Job:  map 100% reduce 86%<br />
21/09/30 11:19:55 INFO mapreduce.Job:  map 100% reduce 87%<br />
21/09/30 11:20:39 INFO mapreduce.Job:  map 100% reduce 88%<br />
21/09/30 11:21:12 INFO mapreduce.Job:  map 100% reduce 89%<br />
21/09/30 11:21:40 INFO mapreduce.Job:  map 100% reduce 90%<br />
21/09/30 11:22:04 INFO mapreduce.Job:  map 100% reduce 91%<br />
21/09/30 11:22:25 INFO mapreduce.Job:  map 100% reduce 92%<br />
21/09/30 11:22:46 INFO mapreduce.Job:  map 100% reduce 93%<br />
21/09/30 11:23:40 INFO mapreduce.Job:  map 100% reduce 94%<br />
21/09/30 11:24:04 INFO mapreduce.Job:  map 100% reduce 95%<br />
21/09/30 11:24:40 INFO mapreduce.Job:  map 100% reduce 96%<br />
21/09/30 11:25:55 INFO mapreduce.Job:  map 100% reduce 98%<br />
21/09/30 11:26:56 INFO mapreduce.Job:  map 100% reduce 99%<br />
21/09/30 11:27:29 INFO mapreduce.Job:  map 100% reduce 100%<br />
[...]
Total time spent by all maps in occupied slots (ms)=51084
Total time spent by all reduces in occupied slots (ms)=3169364
Total time spent by all map tasks (ms)=17028
Total time spent by all reduce tasks (ms)=792341
Total vcore-milliseconds taken by all map tasks=17028
Total vcore-milliseconds taken by all reduce tasks=792341
Total megabyte-milliseconds taken by all map tasks=26155008
Total megabyte-milliseconds taken by all reduce tasks=1622714368

mapper/reducer 2.0

>21/09/30 11:03:06 INFO mapreduce.Job:  map 0% reduce 0%<br />
21/09/30 11:03:13 INFO mapreduce.Job:  map 100% reduce 0%<br />
21/09/30 11:03:26 INFO mapreduce.Job:  map 100% reduce 100%<br />
21/09/30 11:06:09 INFO mapreduce.Job: Job job_1630864376208_1162 completed successfully<br />
21/09/30 11:06:09 INFO mapreduce.Job: Counters: 54<br />
[...]<br />
Total time spent by all maps in occupied slots (ms)=31089<br />
Total time spent by all reduces in occupied slots (ms)=693048<br />
Total time spent by all map tasks (ms)=10363<br />
Total time spent by all reduce tasks (ms)=173262<br />
Total vcore-milliseconds taken by all map tasks=10363<br />
Total vcore-milliseconds taken by all reduce tasks=173262<br />
Total megabyte-milliseconds taken by all map tasks=15917568<br />
Total megabyte-milliseconds taken by all reduce tasks=354840576<br />
