package com.opstty.reducer;

import com.opstty.writtable.ArrYearWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class OldestReducer extends Reducer<Text, ArrYearWritable, Text, ArrYearWritable> {
    public void reduce(Text key, Iterable<ArrYearWritable> values, Context context)
            throws IOException, InterruptedException {
        int min_year = Integer.MAX_VALUE;
        int arr = 0;
        for (ArrYearWritable val : values) {
            if (val.getYear() < min_year){
                min_year = val.getYear();
                arr = val.getArr();
            }
        }
        context.write(key, new ArrYearWritable(min_year, arr));
    }
}