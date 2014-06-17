package org.wingsource.closeloop.require;

import org.wingsource.closeloop.NashornEngine;

import javax.script.ScriptException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by sa on 15-06-2014.
 */
public class Require {

    public static void load(String module) throws CloseLoopException {
        if (module == null || (module.equals(""))) {
            throw new CloseLoopException("Module cannot be null or empty string.");
        }
        if (module.indexOf(".js") < 0) {
            module = module + ".js";
        }
        File moduleFile = new File(module);

        try {
            NashornEngine.getInstance().getEngine().eval(new FileReader(moduleFile));
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
