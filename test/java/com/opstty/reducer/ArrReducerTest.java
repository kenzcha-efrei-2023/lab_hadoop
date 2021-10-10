package com.opstty.reducer;

import com.opstty.reducer.IntSumReducer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.util.Arrays;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ArrReducerTest {
    @Mock
    private Reducer.Context context;
    private ArrReducer reducer;

    @Before
    public void setup() {
        this.reducer = new ArrReducer();
    }

    @Test
    public void testReduce() throws IOException, InterruptedException {
        String key = "12";
        Text value = null;
        Iterable<Text> values = Arrays.asList(value, value, value);
        this.reducer.reduce(new Text(key), values, this.context);
        verify(this.context).write(new Text(key),  new Text("placeholder"));
    }
}