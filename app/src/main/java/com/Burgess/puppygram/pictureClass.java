package com.Burgess.puppygram;

import android.widget.Toast;

import java.io.File;

public class pictureClass {
    boolean upload()
    {
        String img = "sdcard/Download/dog.jpg";
        File temp = new File (img);
        boolean exists = temp.exists();
        return exists;

    }


}
