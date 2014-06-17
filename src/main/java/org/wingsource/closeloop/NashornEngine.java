package org.wingsource.closeloop;

import org.wingsource.closeloop.util.Constants;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by sa on 15-06-2014.
 */
public class NashornEngine {
    private static final NashornEngine instance = new NashornEngine();
    private final ScriptEngine engine;

    private NashornEngine() {
        engine = new ScriptEngineManager().getEngineByName(Constants.NASHORN);
        try {
            System.out.println(System.getProperty("user.dir"));
            engine.eval(new FileReader("lib-js/closeloop.js"));
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static NashornEngine getInstance() {
        return instance;
    }

    public ScriptEngine getEngine() {
        return engine;
    }
}
