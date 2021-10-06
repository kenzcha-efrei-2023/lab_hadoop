package com.opstty.mapper;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class HeightMapper extends Mapper<Object, Text, FloatWritable, Text> {
    public void map(Object key, Text value, Mapper.Context context)
            throws IOException, InterruptedException {
        float h = value.toString().split(";")[6].length() > 0 ?
                Float.parseFloat(value.toString().split(";")[6]) :
                (float)0.0;
        context.write(new FloatWritable(h), new Text("placeholder"));
    }
}