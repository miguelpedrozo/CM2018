package com.cm.misc.javeriana.game.app.task;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

/**
 *
 */
public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    /**
     *
     */
    private ImageView imageView;

    /**
     *
     * @param imageView
     */
    public DownloadImageTask(ImageView imageView) {
        this.imageView = imageView;
    }

    /**
     *
     * @param urls
     * @return
     */
    @Override
    protected Bitmap doInBackground(String... urls) {
        String urlOfImage = urls[0];
        Bitmap image = null;
        try {
            InputStream is = new URL(urlOfImage).openStream();
            image = BitmapFactory.decodeStream(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }

    /**
     *
     * @param bitmap
     */
    @Override
    protected void onPostExecute(Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
    }
}
