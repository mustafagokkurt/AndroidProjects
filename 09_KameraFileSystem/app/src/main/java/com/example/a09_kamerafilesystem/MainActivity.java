package com.example.a09_kamerafilesystem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String currentPhotoPath;
    Uri photoUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openCamera(View view) {
        KameraKontrol();
    }

    void KameraKontrol() {

        ArrayList<String> reqList = new ArrayList<>();

        boolean hasPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;

        if (!hasPermission)
            reqList.add(Manifest.permission.CAMERA);

        hasPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;

        if (!hasPermission)
            reqList.add(Manifest.permission.READ_EXTERNAL_STORAGE);

        hasPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;

        if (!hasPermission)
            reqList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (reqList.size() == 0) {
            KameraAc();
        } else {
            ActivityCompat.requestPermissions(this, reqList.toArray(new String[reqList.size()]), 1);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for (int i = 0; i < grantResults.length; i++) {
            if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                return;
            }

        }
    }

    void KameraAc() {

        if (getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)) {

            Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (i.resolveActivity(getPackageManager()) != null) {
                String imageFileName = "Resim";

                File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
                try {
                    File photoFile = File.createTempFile(imageFileName, ".jpg", storageDir);

                    if (photoFile != null) {
                        currentPhotoPath = photoFile.getAbsolutePath();
                        photoUri = FileProvider.getUriForFile(this, getPackageName(), photoFile);

                        i.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                        startActivityForResult(i, 2);
                    }

                } catch (IOException ex) {

                }
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 2 && resultCode == RESULT_OK) {
            Bitmap resim = BitmapFactory.decodeFile(currentPhotoPath);
            ImageView v = findViewById(R.id.imageView);

            //v.setImageBitmap(resim);
            v.setImageURI(photoUri);
        }
    }
}