package com.Burgess.puppygram;

import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;

import androidx.loader.content.CursorLoader;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    DatabaseHelper db;
    // TODO: get current user
    private ArrayList<String> mThumbIds;

    // Constructor
    public ImageAdapter(Context c) {
        db = new DatabaseHelper();
        mThumbIds = new ArrayList<String>(db.getUserImages("clt94"));
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(300, 300));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        }
        else
        {
            imageView = (ImageView) convertView;
        }

        Bitmap bm = null;
        try {
            bm = BitmapFactory.decodeFile(mThumbIds.get(position));
            imageView.setImageBitmap(bm);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return imageView;
    }
}