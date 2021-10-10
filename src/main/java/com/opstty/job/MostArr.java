package com.opstty.job;

import com.opstty.mapper.ArrMaxMapper;
import com.opstty.mapper.ArrTreeMapper;
import com.opstty.mapper.ExTreesMapper;
import com.opstty.reducer.ArrMaxReducer;
import com.opstty.reducer.ArrReducer;
import com.opstty.reducer.IntSumReducer;
import com.opstty.writtable.ArrNbWritable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class MostArr {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
        if (otherArgs.length != 3) {
            System.err.println("Usage: mostarr <in> <out1> <out2>");
            System.exit(2);
        }
        Job job = Job.getInstance(conf, "mostarr");
        job.setJarByClass(MostArr.class);
        job.setMapperClass(ArrTreeMapper.class);
        job.setCombinerClass(IntSumReducer.class);
        job.setReducerClass(IntSumReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
        FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
        job.waitForCompletion(true);
        Configuration conf2 = new Configuration();
        Job job2 = Job.getInstance(conf2, "mostarr2");
        job2.setJarByClass(MostArr.class);
        job2.setMapperClass(ArrMaxMapper.class);
        job2.setCombinerClass(ArrMaxReducer.class);
        job2.setReducerClass(ArrMaxReducer.class);
        job2.setOutputKeyClass(Text.class);
        job2.setOutputValueClass(ArrNbWritable.class);
        FileInputFormat.addInputPath(job2, new Path(otherArgs[1]));
        FileOutputFormat.setOutputPath(job2, new Path(otherArgs[2]));
        System.exit(job2.waitForCompletion(true) ? 0 : 1);
    }
}