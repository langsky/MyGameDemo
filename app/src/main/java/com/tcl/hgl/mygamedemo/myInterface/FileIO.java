package com.tcl.hgl.mygamedemo.myInterface;

import android.content.SharedPreferences;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by swd1 on 16-4-20.
 */
public interface FileIO {
    InputStream readAssert(String fileName) throws IOException;

    InputStream readFile(String fileName) throws IOException;

    OutputStream writerFile(String fileName) throws IOException;

    SharedPreferences getSharedPreferences();

}
