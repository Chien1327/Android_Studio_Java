package com.example.application;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    public static class YourClassName {
        private static final String SHARE_PREF_NAME = "shared_prefs";
        private static final String USER_NAME = "USER_NAME";
        private static final String USER_PASSWORD = "USER_PASSWORD";
    }

    protected String username_text = null;
    protected String password_text = null;

    TextView    username;
    TextView    password;
    Button      button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        button = findViewById(R.id.botton_signin);
        SharedPreferences sharedPreferences = getSharedPreferences(YourClassName.SHARE_PREF_NAME, MODE_PRIVATE);

        username_text = sharedPreferences.getString("USER_NAME", null);
        password_text = sharedPreferences.getString("USER_PASSWORD", null);

        button.setOnClickListener(view -> {
            if (TextUtils.isEmpty(username.getText().toString()) && TextUtils.isEmpty(password.getText().toString())) {
                Toast.makeText(MainActivity.this, "Login Fail", Toast.LENGTH_SHORT).show();
                return;
            }
            else {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                if ("admin".equals(username.getText().toString()) && "1234".equals(password.getText().toString())) {
                    editor.putString(YourClassName.USER_NAME, username.getText().toString());
                    editor.putString(YourClassName.USER_PASSWORD, password.getText().toString());
                    editor.apply();
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(MainActivity.this, "Login Fail", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (username_text != null && password_text != null) {
            Intent i = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(i);
        }
    }
}

//SharedPreferences.Editor editor = sharedPreferences.edit();
//            editor.putString(USER_NAME, username.getText().toString());
//        editor.putString(USER_PASSWORD, password.getText().toString());
//        editor.apply();
//
//Intent intent = new Intent(MainActivity.this, HomeActivity.class);
//startActivity(intent);