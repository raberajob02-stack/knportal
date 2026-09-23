package com.example.knportal;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

/**
 * LOGIN SCREEN.
 *
 * This is a STUDENT PRACTICAL DEMO. There is no real backend/database or
 * online authentication here - see validateAndLogin() below for exactly
 * where a real network/API call would replace this demo check. For this
 * assessment, any non-empty Admission Number and Password is accepted.
 */
public class LoginActivity extends AppCompatActivity {

    /** Key used to pass the admission number to DashboardActivity. */
    public static final String EXTRA_ADMISSION_NUMBER = "extra_admission_number";

    private TextInputEditText etAdmissionNumber;
    private TextInputEditText etPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Find the views declared in activity_login.xml
        etAdmissionNumber = findViewById(R.id.etAdmissionNumber);
        etPassword = findViewById(R.id.etPassword);
        MaterialButton btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> validateAndLogin());
    }

    private void validateAndLogin() {
        String admissionNumber = etAdmissionNumber.getText() != null
                ? etAdmissionNumber.getText().toString().trim() : "";
        String password = etPassword.getText() != null
                ? etPassword.getText().toString().trim() : "";

        // Check the Admission Number field first
        if (TextUtils.isEmpty(admissionNumber)) {
            Toast.makeText(this, R.string.error_admission_empty, Toast.LENGTH_SHORT).show();
            return; // stop here - do not continue checking or navigate away
        }

        // Then check the Password field
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, R.string.error_password_empty, Toast.LENGTH_SHORT).show();
            return;
        }

        // Both fields have a value, so this demo treats it as a successful login.
        Toast.makeText(this, R.string.login_success, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
        intent.putExtra(EXTRA_ADMISSION_NUMBER, admissionNumber);
        startActivity(intent);

        // Remove the login screen from the back stack so pressing Back from
        // the Dashboard does not return the user to the login form.
        finish();
    }
}
