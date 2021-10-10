package com.opstty.mapper;

import com.opstty.writtable.ArrNbWritable;
import com.opstty.writtable.ArrYearWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class ArrMaxMapper extends Mapper<Object, Text, Text, ArrNbWritable> {

    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {
        String arrondissement = value.toString().split(" ")[0];

        String a = value.toString().split(" ")[value.toString().split(" ").length-1];
        while (a.length()!= 0 && !Character.isDigit(a.charAt(0)))
            a = a.substring(1);
        int nb = Integer.parseInt(a);
        context.write(new Text("placeholder"), new ArrNbWritable( nb, arrondissement));
    }
}
