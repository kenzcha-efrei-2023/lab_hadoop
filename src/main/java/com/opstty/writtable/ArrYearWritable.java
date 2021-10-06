package com.opstty.writtable;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class ArrYearWritable implements Writable {

    public int getYear() {
        return year;
    }

    public int getArr() {
        return arr;
    }

    private int year;
    private int arr;

    public ArrYearWritable(int year, int arr){
        this.arr = arr;
        this.year = year;
    }
    public ArrYearWritable(){
        this.arr = 0;
        this.year = 0;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(arr);
        dataOutput.writeInt(year);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        arr = dataInput.readInt();
        year = dataInput.readInt();
    }

    @Override
    public String toString() {
        return "year=" + year +
                ", arr=" + arr;
    }
}
