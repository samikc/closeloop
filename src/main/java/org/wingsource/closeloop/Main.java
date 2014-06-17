package org.wingsource.closeloop;

import org.wingsource.closeloop.util.Constants;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by sa on 15-06-2014.
 */
public class Main {


    /*
        The entry point in closeloop.
     */
    public static void main(String[] args) {

        try {
            NashornEngine.getInstance().getEngine().eval(new FileReader(args[0]));
            //engine.eval(new FileReader(args[1]));
            //engine.eval(new FileReader(args[2]));
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        EventLoopThread.getInstance().shutdown();
    }

    private static void test() {

    }
}
