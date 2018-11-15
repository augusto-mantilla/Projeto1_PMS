package com.example.andrtelo.project1;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnWelcome = (Button)findViewById(R.id.btnWelcome);
        Button btnShareOnApp = (Button)findViewById(R.id.btnShareOnApp);
        Button btnSeeMap = (Button)findViewById(R.id.btnSeeMap);
            btnSeeMap.setOnClickListener(new View.OnClickListener() {//faz abrir o google maps ao carregar no botão
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                    startActivity(intent);
                }
            });
            btnShareOnApp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, sharelocation_menu.class);
                    startActivity(intent);

                        }
                    });
            }
}
