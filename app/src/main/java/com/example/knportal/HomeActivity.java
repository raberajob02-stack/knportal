package com.example.knportal;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

/**
 * Simple dashboard/home screen shown after a "successful" demo login.
 */
public class HomeActivity extends AppCompatActivity {

    public static final String EXTRA_USERNAME = "extra_username";

    private TextView tvHomeMessage;
    private MaterialButton btnLogout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvHomeMessage = findViewById(R.id.tvHomeMessage);
        btnLogout = findViewById(R.id.btnLogout);

        // Optionally personalize the welcome message with the username
        // that was passed in from MainActivity.
        String username = getIntent().getStringExtra(EXTRA_USERNAME);
        if (!TextUtils.isEmpty(username)) {
            tvHomeMessage.setText(getString(R.string.home_subtitle) + "\n(" + username + ")");
        }

        // Logout button: send the user back to the login screen and
        // clear the back stack so they cannot press "Back" into the dashboard.
        btnLogout.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });
    }
}
