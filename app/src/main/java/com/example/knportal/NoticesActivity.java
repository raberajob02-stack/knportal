package com.example.knportal;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * NOTICES SCREEN.
 * Shows static notice text (see activity_notices.xml / notices_content
 * string). This is NOT a live/online notice system - just fixed text
 * for this practical assessment.
 */
public class NoticesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notices);
    }
}
