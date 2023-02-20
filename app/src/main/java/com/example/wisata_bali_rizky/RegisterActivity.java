package com.example.wisata_bali_rizky;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;

public class RegisterActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    Button btnRegister;
    EditText editTextUsername, editTextPassword;
    RadioGroup roleRadioGroup;
    RadioButton roleRadioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        databaseHelper = new DatabaseHelper(this);
        roleRadioGroup = findViewById(R.id.radioGroupRole);
        editTextUsername = findViewById(R.id.username);
        editTextPassword = findViewById(R.id.password);
        initViews();

        btnRegister.setOnClickListener((view -> {
            SQLiteDatabase db = databaseHelper.getWritableDatabase();
            if (validate()) {
                String usernames = editTextUsername.getText().toString();
                String passwords = editTextPassword.getText().toString();

                // get selected radio button from radio group
                int selectedRoleId = roleRadioGroup.getCheckedRadioButtonId();

                // find the radio button by returned id
                roleRadioButton = findViewById(selectedRoleId);

                // save selected radio button into variable
                String roleFix = roleRadioButton.getText().toString();

                db.execSQL("INSERT INTO user(name, password, role) VALUES ('" +
                        usernames + "', '" +
                        passwords + "', '" +
                        roleFix + "')");
                Toast.makeText(getApplicationContext(), "Register Berhasil!", Toast.LENGTH_SHORT).show();
                finish();
            }
        }));
    }

    private void initViews() {
        editTextUsername = findViewById(R.id.username);
        editTextPassword = findViewById(R.id.password);
        btnRegister = findViewById(R.id.btnRegister);
    }

    // This method is used to validate input given by user
    public boolean validate() {
        boolean valid = false;

        // Get values from EditText fields
        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();

        // Handling validation for username field
        if (username.isEmpty()) {
            valid = false;
            Toast.makeText(getApplicationContext(), "Username field harus diisi!", Toast.LENGTH_SHORT).show();
        } else {
            if (username.length() > 2) {
                valid = true;
            } else {
                valid = false;
                Toast.makeText(getApplicationContext(), "Username minimal harus 4 digit!", Toast.LENGTH_SHORT).show();
            }
        }

        // Handling validation for password field
        if (password.isEmpty()) {
            valid = false;
            Toast.makeText(getApplicationContext(), "Password field harus diisi!", Toast.LENGTH_SHORT).show();
        } else {
            if (password.length() > 3) {
                valid = true;
                Toast.makeText(getApplicationContext(), "Password minimal harus 8 digit!", Toast.LENGTH_SHORT).show();
            }
        }

        return valid;
    }
}