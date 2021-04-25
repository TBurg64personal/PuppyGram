package com.Burgess.puppygram;

import android.widget.Toast;

import java.io.File;

public class pictureClass {
    boolean upload(String name)
    {

        File temp = new File (name);
        boolean exists = temp.exists();
        return exists;

    }


}
