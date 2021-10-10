package com.opstty.mapper;

import com.opstty.job.NbTrees;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class NbTreesMapperTest {
    @Mock
    private Mapper.Context context;
    private NbTreesMapper mapper;

    @Before
    public void setup() {
        this.mapper = new NbTreesMapper();
    }

    @Test
    public void testMap() throws IOException, InterruptedException {
        String value = "(48.8399672948, 2.43375148978);12;Fagus;sylvatica;Fagaceae;1865;20.0;530.0;avenue Daumesnil, Esplanade du Château de Vincennes;Hêtre pleureur;Pendula;20;Bois de Vincennes (square Carnot)";
        this.mapper.map(null, new Text(value), this.context);
        verify(this.context, times(1))
                .write(new Text("sylvatica"), new IntWritable(1));
    }
}
