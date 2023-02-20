package com.example.wisata_bali_rizky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginGuest extends AppCompatActivity {
    TextView txtToRegis;

    // Declaration EditTexts
    EditText editTextUsername, editTextPassword;

    // Declaration Button
    Button btnLogin;

    // Declaration SQLiteHelper
    DatabaseHelper databaseHelper;

    protected Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_guest);

        databaseHelper = new DatabaseHelper(this);
        editTextUsername = findViewById(R.id.username);
        editTextPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnLogin);
        txtToRegis = findViewById(R.id.txtToRegister);

        btnLogin.setOnClickListener((view -> {
            // check user input is correct or not
//            if (validate())
            SQLiteDatabase db = databaseHelper.getReadableDatabase();
            cursor = db.rawQuery("SELECT * FROM user WHERE name = '" + editTextUsername.getText().toString() + "' and password = '" + editTextPassword.getText().toString() + "'", null);
            if (cursor.getCount() == 1) {
                cursor.moveToPosition(0);
                Toast.makeText(getApplicationContext(), "Berhasil Login!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginGuest.this, HomepageGuest.class);
            }
        }));

        txtToRegis.setOnClickListener((view -> {
            Intent intent = new Intent(LoginGuest.this, RegisterActivity.class);
            startActivity(intent);
        }));
    }
}