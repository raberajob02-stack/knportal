package com.example.knportal;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

/**
 * SPLASH / WELCOME SCREEN.
 *
 * This is the app's launcher Activity (see AndroidManifest.xml - it is
 * the one with the LAUNCHER intent-filter). It only introduces the app;
 * tapping CONTINUE takes the user to LoginActivity.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the CONTINUE button declared in activity_main.xml
        MaterialButton btnContinue = findViewById(R.id.btnContinue);

        // When CONTINUE is tapped, open the Login screen.
        btnContinue.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);

            // finish() removes the splash screen from the back stack so the
            // user can't press Back and return to it after moving on.
            finish();
        });
    }
}
