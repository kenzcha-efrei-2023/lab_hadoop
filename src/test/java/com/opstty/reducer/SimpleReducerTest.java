package com.opstty.reducer;

import com.opstty.reducer.MaxReducer;
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
public class SimpleReducerTest {
    @Mock
    private Reducer.Context context;
    private SimpleReducer reducer;

    @Before
    public void setup() {
        this.reducer = new SimpleReducer();
    }

    @Test
    public void testReduce() throws IOException, InterruptedException {
        Iterable<Text> values = Arrays.asList( new Text("placeholder"),  new Text("placeholder"),  new Text("placeholder"));
        this.reducer.reduce(new FloatWritable((float)1.0), values, this.context);
        verify(this.context).write(new FloatWritable((float)1.0), new Text("placeholder"));
    }
}
