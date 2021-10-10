package com.opstty;

import com.opstty.job.*;
import org.apache.hadoop.util.ProgramDriver;

public class AppDriver {
    public static void main(String argv[]) {
        int exitCode = -1;
        ProgramDriver programDriver = new ProgramDriver();
        try {
            programDriver.addClass("mostarr", MostArr.class,
                    "A map/reduce program that gives the arrondissement that has the most trees");
            programDriver.addClass("oldarr", OldestTrArr.class,
                    "A map/reduce program that gives the arrondissement that has the oldest tree");
            programDriver.addClass("srtheight", SortHeigth.class,
                    "A map/reduce program that gives the height sorted");
            programDriver.addClass("arheight", ArrHeigth.class,
                    "A map/reduce program that gives the height of the tallest representant of existing tree species");
            programDriver.addClass("nbtrees", NbTrees.class,
                    "A map/reduce program that gives the number of representant of the existing tree species");
            programDriver.addClass("extrees", ExTrees.class,
                    "A map/reduce program that gives the name of the existing tree species");
            programDriver.addClass("arrTrees", ArrTrees.class,
                    "A map/reduce program that gives the arrondissements that contains trees");
            programDriver.addClass("wordcount", WordCount.class,
                    "A map/reduce program that gives the number of words in a file");
            exitCode = programDriver.run(argv);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.exit(exitCode);
    }
}
