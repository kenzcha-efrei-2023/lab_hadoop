package com.opstty.mapper;

import com.opstty.writtable.ArrYearWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class OldestMapper  extends Mapper<Object, Text, Text, ArrYearWritable> {

    public void map(Object key, Text value, Mapper.Context context)
            throws IOException, InterruptedException {
        int ar = Integer.parseInt(value.toString().split(";")[1]);
        int year = value.toString().split(";")[5].length() > 0 ?
                Integer.parseInt(value.toString().split(";")[5]) :
                Integer.MAX_VALUE;


        context.write(new Text("placeholder"), new ArrYearWritable(year, ar));
    }
}