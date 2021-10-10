package com.opstty.writtable;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class ArrNbWritable implements Writable {
    public int getNb() {
        return nb;
    }

    public String getArr() {
        return arr;
    }

    private int nb;
    private String arr;

    public ArrNbWritable(int nb, String arr){
        this.arr = arr;
        this.nb = nb;
    }
    public ArrNbWritable(){
        this.arr = "";
        this.nb = 0;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(arr);
        dataOutput.writeInt(nb);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        arr = dataInput.readUTF();
        nb = dataInput.readInt();
    }

    @Override
    public String toString() {
        return  Integer.toString(nb) + arr;
    }
}
