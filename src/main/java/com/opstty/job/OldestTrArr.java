package com.opstty.job;

import com.opstty.mapper.HeightMapper;
import com.opstty.mapper.OldestMapper;
import com.opstty.reducer.OldestReducer;
import com.opstty.reducer.SimpleReducer;
import com.opstty.writtable.ArrYearWritable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class OldestTrArr {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
        if (otherArgs.length < 2) {
            System.err.println("Usage: oldtrarr <in> [<in>...] <out>");
            System.exit(2);
        }
        Job job = Job.getInstance(conf, "oldtrarr");
        job.setJarByClass(OldestTrArr.class);
        job.setMapperClass(OldestMapper.class);
        job.setCombinerClass(OldestReducer.class);
        job.setReducerClass(OldestReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(ArrYearWritable.class);
        for (int i = 0; i < otherArgs.length - 1; ++i) {
            FileInputFormat.addInputPath(job, new Path(otherArgs[i]));
        }
        FileOutputFormat.setOutputPath(job,
                new Path(otherArgs[otherArgs.length - 1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
