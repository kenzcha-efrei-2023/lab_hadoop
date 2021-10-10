package com.opstty.reducer;

import com.opstty.writtable.ArrNbWritable;
import com.opstty.writtable.ArrYearWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class ArrMaxReducer  extends Reducer<Text, ArrNbWritable, Text, ArrNbWritable> {

    public void reduce(Text key, Iterable<ArrNbWritable> values, Context context)
            throws IOException, InterruptedException {
        int max_nb = -1;
        String arr = "";

        for (ArrNbWritable val : values) {
            if (val.getNb() > max_nb){
                max_nb = val.getNb();
                arr = val.getArr();
            }
        }
        context.write(new Text("The arrondissement with the most trees "+arr), new ArrNbWritable(max_nb, arr));
    }
}
