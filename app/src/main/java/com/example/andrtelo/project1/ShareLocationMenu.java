package com.example.andrtelo.project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ShareLocationMenu extends AppCompatActivity {
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
                //Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                //Intent intent = new Intent(ShareLocationMenu.this, Camera.class);
                Intent intent = new Intent(ShareLocationMenu.this, CameraAPI.class);
               startActivity(intent);

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
}
