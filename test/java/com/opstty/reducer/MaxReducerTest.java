package com.opstty.reducer;

import org.apache.commons.math3.analysis.function.Max;
import org.apache.hadoop.io.FloatWritable;
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
public class MaxReducerTest {
    @Mock
    private Reducer.Context context;
    private MaxReducer reducer;

    @Before
    public void setup() {
        this.reducer = new MaxReducer();
    }

    @Test
    public void testReduce() throws IOException, InterruptedException {
        String key = "key";
        Iterable<FloatWritable> values = Arrays.asList( new FloatWritable((float)1.0),  new FloatWritable((float)2.0),  new FloatWritable((float)3.0));
        this.reducer.reduce(new Text(key), values, this.context);
        verify(this.context).write(new Text(key), new FloatWritable((float)3.0));
    }
}
