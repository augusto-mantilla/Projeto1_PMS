package com.example.andrtelo.project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class sharelocation_menu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share_menu);
        Button btnMainMenu2 = (Button) findViewById(R.id.btn_Home2);
        Button btn_UseCamera = (Button) findViewById(R.id.btn_UseCamera);
        Button btnShareLocation = (Button) findViewById(R.id.btnShareLocation);
        Button btnSeeMap3 = (Button) findViewById(R.id.btn_seeMap3);
        Button btnShareOnApp3 = (Button)findViewById(R.id.btn_shareOnApp3);
        btnSeeMap3.setOnClickListener(new View.OnClickListener() {//faz abrir o google maps ao carregar no botão
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sharelocation_menu.this, MapsActivity.class);
                startActivity(intent);
            }
        });
        btnMainMenu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sharelocation_menu.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btn_UseCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                Intent intent = new Intent(sharelocation_menu.this, Camera.class);
                startActivity(intent);

            }
        });
        btnShareLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sharelocation_menu.this, Tag_menu.class);
                startActivity(intent);
            }
    });
        btnShareOnApp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sharelocation_menu.this, sharelocation_menu.class);
                startActivity(intent);
            }
        });
    }
}
