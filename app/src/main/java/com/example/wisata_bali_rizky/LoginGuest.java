package com.example.wisata_bali_rizky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginGuest extends AppCompatActivity {
    TextView txtToRegis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_guest);
        Button pengguna = findViewById(R.id.pengguna);
        txtToRegis = findViewById(R.id.txtToRegister);
        pengguna.setOnClickListener(view -> {

        });
        txtToRegis.setOnClickListener(v->{
            startActivity(new Intent(this, RegisterActivity.class));
        });
    }
}