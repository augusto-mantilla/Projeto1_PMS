package com.example.andrtelo.project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Tag_menu extends AppCompatActivity {
    private boolean Cetacean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share_menu);
        setContentView(R.layout.share_location_menu);
        Button btnCetacean = (Button)findViewById(R.id.btnCetacean);
        Button btnPollution = (Button)findViewById(R.id.btnPollution);
        Button btnMainMenu3 = (Button)findViewById(R.id.btn_mainMenu3);
        Button btnSeeMap4 = (Button)findViewById(R.id.btn_seeMap4);
        Button btnShareOnApp = (Button)findViewById(R.id.btnShareOnApp4);
        btnSeeMap4.setOnClickListener(new View.OnClickListener() {//faz abrir o google maps ao carregar no botão
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tag_menu.this, MapsActivity.class);
                startActivity(intent);
            }
        });
        btnCetacean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.share_sucessfull);
                Cetacean = true;
                Toast.makeText(Tag_menu.this,"Cetacean", Toast.LENGTH_LONG).show();

            }
        });
        btnPollution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.share_sucessfull);
                Cetacean = false;
                Toast.makeText(Tag_menu.this,"Pollution", Toast.LENGTH_LONG).show();

            }
        });
        btnMainMenu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tag_menu.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnShareOnApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tag_menu.this, sharelocation_menu.class);
                startActivity(intent);
            }
        });
    }
}




