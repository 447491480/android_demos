package com.example.imageview_02;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MyActivity extends Activity implements View.OnClickListener{
    private Button selectBtn;
    private Button cutBtn;
    private ImageView imageView;

    private static final int IMAGE_SELECT = 1;
    private static final int IMAGE_CUT = 2;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        selectBtn = (Button)findViewById(R.id.selectImageBtn);
        cutBtn = (Button)findViewById(R.id.cutImageBtn);
        imageView = (ImageView)findViewById(R.id.imageview);

        selectBtn.setOnClickListener(this);
        cutBtn.setOnClickListener(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK ) {
            if(requestCode == IMAGE_SELECT) {
                Uri uri = data.getData();

                int dw = getWindowManager().getDefaultDisplay().getWidth();
                int dh = getWindowManager().getDefaultDisplay().getHeight()/2;

                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri),null,options);

                    int hRatio = (int)Math.ceil(options.outHeight/(float)dh);
                    int wRatio = (int)Math.ceil(options.outWidth/(float)dw);
                    if(hRatio > 1 || wRatio > 1) {
                        if(hRatio > wRatio) {
                            options.inSampleSize = hRatio;
                        } else {
                            options.inSampleSize = wRatio;
                        }

                        options.inJustDecodeBounds = false;

                        bitmap = bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri),null,options);
                    }

                    imageView.setImageBitmap(bitmap);

                } catch (Exception e) {

                }

            } else if(requestCode == IMAGE_CUT) {
                Bitmap bitmap = data.getParcelableExtra("data");
                imageView.setImageBitmap(bitmap);
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.selectImageBtn:
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(intent, IMAGE_SELECT);

                break;
            case R.id.cutImageBtn:
                Intent intent1 = getImageClipIntent();
                startActivityForResult(intent1,IMAGE_CUT);

                break;
            default:
                break;
        }

    }

    private Intent getImageClipIntent() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT,null);
        intent.setType("image/*");
        intent.putExtra("crop","true");
        intent.putExtra("aspectx",1);
        intent.putExtra("aspecty",1);
        intent.putExtra("outputx",80);
        intent.putExtra("outputy",80);
        intent.putExtra("return-data","true");
        return intent;
    }
}
