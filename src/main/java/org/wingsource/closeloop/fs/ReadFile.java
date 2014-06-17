package org.wingsource.closeloop.fs;

import jdk.nashorn.api.scripting.ScriptObjectMirror;
import jdk.nashorn.internal.objects.ScriptFunctionImpl;
import org.apache.commons.io.FileUtils;
import org.wingsource.closeloop.NashornEngine;

import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.Invocable;
import javax.script.ScriptException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

/**
 * Created by sa on 15-06-2014.
 */
public class ReadFile implements Runnable {

    private final String fileName;
    private final ScriptObjectMirror funcObj;


    public ReadFile(String fileName, ScriptObjectMirror funcObj) {
        this.fileName = fileName;
        this.funcObj = funcObj;
    }

    public void run(){
        byte[] bytes = new byte[0];
        Buffer buffer = null;
        Throwable t = null;
        try {
            bytes = FileUtils.readFileToByteArray(new File(fileName));
            buffer = new Buffer(bytes);
        } catch (Exception e) {
            t = e;
            //e.printStackTrace();
        }

        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("File Read - COMPLETE");

            if (buffer == null) {
                try {
                    funcObj.callMember("call",t.getMessage(),null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    funcObj.callMember("call",t,buffer);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }



    }

}

