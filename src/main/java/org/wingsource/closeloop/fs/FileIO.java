package org.wingsource.closeloop.fs;

import jdk.nashorn.api.scripting.ScriptObjectMirror;
import jdk.nashorn.internal.objects.NativeFunction;
import jdk.nashorn.internal.objects.ScriptFunctionImpl;
import org.wingsource.closeloop.EventLoopThread;
import org.wingsource.closeloop.NashornEngine;

import javax.script.Invocable;
import javax.script.ScriptException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by sa on 15-06-2014.
 */
public class FileIO {

    public static void read(String fileName,ScriptObjectMirror callback) {
        EventLoopThread.getInstance().execute(new ReadFile(fileName, callback));
    }
}
