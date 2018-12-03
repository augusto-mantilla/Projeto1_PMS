package com.example.andrtelo.project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TagMenu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share_menu);
        setContentView(R.layout.share_location_menu);
        Button btnCetacean = findViewById(R.id.btnCetacean);
        Button btnPollution = findViewById(R.id.btnPollution);
        Button btnMainMenu3 = findViewById(R.id.btn_mainMenu3);
        Button btnSeeMap4 = findViewById(R.id.btn_seeMap4);
        Button btnShareOnApp = findViewById(R.id.btnShareOnApp4);
        btnSeeMap4.setOnClickListener(new View.OnClickListener() {//faz abrir o google maps ao carregar no botão
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TagMenu.this, MapsActivity.class);
                startActivity(intent);
            }
        });
        btnCetacean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.share_sucessfull);
                Toast.makeText(TagMenu.this,"Cetacean", Toast.LENGTH_LONG).show();

                //Intent intent = new Intent(TagMenu.this, UploadFile.class);
                //Intent intent = new Intent(TagMenu.this, UploadFile_2.class);
                //startActivity(intent);
            }
        });
        btnPollution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.share_sucessfull);
                Toast.makeText(TagMenu.this,"Pollution", Toast.LENGTH_LONG).show();

            }
        });
        btnMainMenu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TagMenu.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnShareOnApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TagMenu.this, ShareLocationMenu.class);
                startActivity(intent);
            }
        });
    }
}




