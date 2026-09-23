package com.example.knportal;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * PROFILE SCREEN.
 * Shows static student details (see activity_profile.xml). No database
 * is used - the details live as plain strings in res/values/strings.xml,
 * which is deliberate so they are easy for a student to find and edit.
 */
public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }
}
