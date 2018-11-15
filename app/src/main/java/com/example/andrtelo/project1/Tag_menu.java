package com.example.andrtelo.project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Tag_menu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share_menu);
        setContentView(R.layout.share_location_menu);
        Button btnCetacean = (Button)findViewById(R.id.btnCetacean);
        Button btnPollution = (Button)findViewById(R.id.btnPollution);
        Button btnMainMenu3 = (Button)findViewById(R.id.btn_mainMenu3);
        btnCetacean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.share_sucessfull);

            }
        });
        btnPollution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.share_sucessfull);

            }
        });
        btnMainMenu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tag_menu.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}




