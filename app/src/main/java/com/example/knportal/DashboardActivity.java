package com.example.knportal;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

/**
 * DASHBOARD / HOME SCREEN.
 * Shown after a successful demo login. Lets the student open the
 * Courses, Notices, and Profile screens.
 */
public class DashboardActivity extends AppCompatActivity {

    private TextView tvDashboardWelcome;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        tvDashboardWelcome = findViewById(R.id.tvDashboardWelcome);
        MaterialButton btnViewCourses = findViewById(R.id.btnViewCourses);
        MaterialButton btnViewNotices = findViewById(R.id.btnViewNotices);
        MaterialButton btnViewProfile = findViewById(R.id.btnViewProfile);

        // Personalize the welcome text with the admission number passed
        // in from LoginActivity, if one was supplied.
        String admissionNumber = getIntent().getStringExtra(LoginActivity.EXTRA_ADMISSION_NUMBER);
        if (!TextUtils.isEmpty(admissionNumber)) {
            tvDashboardWelcome.setText(getString(R.string.dashboard_welcome) + " (" + admissionNumber + ")");
        }

        // Each button just opens the matching Activity with a plain Intent.
        // Because we do NOT call finish() here, the Android Back button
        // will correctly return to this Dashboard screen.
        btnViewCourses.setOnClickListener(v ->
                startActivity(new Intent(DashboardActivity.this, CoursesActivity.class)));

        btnViewNotices.setOnClickListener(v ->
                startActivity(new Intent(DashboardActivity.this, NoticesActivity.class)));

        btnViewProfile.setOnClickListener(v ->
                startActivity(new Intent(DashboardActivity.this, ProfileActivity.class)));
    }
}
