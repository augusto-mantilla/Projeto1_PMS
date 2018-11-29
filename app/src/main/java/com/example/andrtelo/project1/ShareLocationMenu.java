package com.example.andrtelo.project1;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.os.Environment.getExternalStoragePublicDirectory;

public class ShareLocationMenu extends AppCompatActivity {
    ImageView imageView;
    String pathToFile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share_menu);
        Button btnMainMenu2 = findViewById(R.id.btn_Home2);
        Button btn_UseCamera = findViewById(R.id.btn_UseCamera);
        Button btnShareLocation = findViewById(R.id.btnShareLocation);
        Button btnSeeMap3 = findViewById(R.id.btn_seeMap3);
        Button btnShareOnApp3 = findViewById(R.id.btn_shareOnApp3);
        btnSeeMap3.setOnClickListener(new View.OnClickListener() {//faz abrir o google maps ao carregar no botão
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShareLocationMenu.this, MapsActivity.class);
                startActivity(intent);
            }
        });
        btnMainMenu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShareLocationMenu.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btn_UseCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                create();
            }
        });
        btnShareLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShareLocationMenu.this, TagMenu.class);
                startActivity(intent);
            }
    });
        btnShareOnApp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShareLocationMenu.this, ShareLocationMenu.class);
                startActivity(intent);
            }
        });
    }

    protected void create() {

        if(Build.VERSION.SDK_INT >=23){
            requestPermissions(new String[]{android.Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE},2);
        }
        dispatchPictureTakerAction();

        }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (resultCode == RESULT_OK){
            if (requestCode == 1){
                Bitmap bitmap = BitmapFactory.decodeFile(pathToFile);
                //imageView.setImageBitmap(bitmap);
                Intent intent = new Intent(ShareLocationMenu.this,TagMenu.class);
                startActivity(intent);
            }
        }
    }

    private void dispatchPictureTakerAction(){
        Intent Takephoto= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(Takephoto.resolveActivity(getPackageManager())!= null){
            File photoFile = null;
            photoFile = createPhotoFile();
            if(photoFile!= null){
                String pathtofile = photoFile.getAbsolutePath();
                Uri photoUri = FileProvider.getUriForFile(ShareLocationMenu.this,"com.example.andrtelo.project1.fileprovider",photoFile);
                Takephoto.putExtra(MediaStore.EXTRA_OUTPUT,photoUri);
                startActivityForResult(Takephoto,1);


            }

        }
    }

    private File createPhotoFile(){
        String name = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File storageDir = getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File image = null;
        try {
            image = File.createTempFile(name,".jpg", storageDir);
        } catch (IOException e) {
            Log.d("mylog","Except : " + e.toString());
        }
        return image;


    }
}
