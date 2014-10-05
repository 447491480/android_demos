package com.example.gallery_01;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class MyActivity extends Activity {

    private Gallery gallery;
    private int[] resids = {
      R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5,
    };

    private ImageAdapter imageAdapter;



    /**
     *
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        gallery = (Gallery)findViewById(R.id.gallery);

        imageAdapter = new ImageAdapter(this);
        gallery.setAdapter(imageAdapter);
    }

    public class ImageAdapter extends BaseAdapter {
        private Context context;
        int mGalleryItemBackground;
        public ImageAdapter(Context context) {
            this.context = context;
            TypedArray typedArray = obtainStyledAttributes(R.styleable.gallery);
            mGalleryItemBackground = typedArray.getResourceId(R.styleable.gallery_android_galleryItemBackground,0);
        }

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public Object getItem(int i) {
            return resids[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(resids[i%resids.length]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setLayoutParams(new Gallery.LayoutParams(136,88));
            imageView.setBackgroundResource(mGalleryItemBackground);

            return imageView;
        }
    }
}
