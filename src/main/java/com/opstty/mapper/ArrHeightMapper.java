package com.opstty.mapper;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

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
