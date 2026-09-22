package com.example.knportal;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/**
 * Login screen.
 *
 * This is a STUDENT DEMO. There is no real backend/database here, so
 * "logging in" only checks that both fields were filled in. See the
 * validateAndLogin() method below for exactly where a real network/API
 * call would replace this demo check.
 */
public class MainActivity extends AppCompatActivity {

    // UI references
    private TextInputLayout tilUsername;
    private TextInputLayout tilPassword;
    private TextInputEditText etUsername;
    private TextInputEditText etPassword;
    private MaterialButton btnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Find all the views by the IDs declared in activity_main.xml
        tilUsername = findViewById(R.id.tilUsername);
        tilPassword = findViewById(R.id.tilPassword);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        // "Forgot password?" - not implemented, just informs the user
        findViewById(R.id.tvForgotPassword).setOnClickListener(v ->
                Toast.makeText(MainActivity.this,
                        R.string.forgot_password_message, Toast.LENGTH_SHORT).show());

        // "Create an Account" - not implemented, just informs the user
        findViewById(R.id.tvCreateAccount).setOnClickListener(v ->
                Toast.makeText(MainActivity.this,
                        R.string.create_account_message, Toast.LENGTH_SHORT).show());

        // "knportal" tag at the bottom of the screen.
        // In this basic demo it just shows a Toast. See the optional
        // WebView/Intent section of the write-up to make this open a
        // real website instead.
        findViewById(R.id.tvKnportal).setOnClickListener(v ->
                Toast.makeText(MainActivity.this,
                        R.string.knportal_click_message, Toast.LENGTH_SHORT).show());

        // 2. Handle the LOGIN button click
        btnLogin.setOnClickListener(v -> validateAndLogin());
    }

    /**
     * Validates the two input fields and, if both are filled in,
     * simulates a successful login and opens HomeActivity.
     *
     * NOTE FOR A REAL APP: this is where you would call your backend
     * (e.g. a Retrofit/Volley request to an authentication API) and only
     * navigate to HomeActivity after the server confirms the credentials
     * are correct. Right now there is no server, so we simply check that
     * the fields are not empty.
     */
    private void validateAndLogin() {
        String username = etUsername.getText() != null
                ? etUsername.getText().toString().trim() : "";
        String password = etPassword.getText() != null
                ? etPassword.getText().toString().trim() : "";

        // Clear any previous error messages first
        tilUsername.setError(null);
        tilPassword.setError(null);

        boolean isValid = true;

        if (TextUtils.isEmpty(username)) {
            tilUsername.setError(getString(R.string.error_username_empty));
            isValid = false;
        }

        if (TextUtils.isEmpty(password)) {
            tilPassword.setError(getString(R.string.error_password_empty));
            isValid = false;
        }

        if (!isValid) {
            // Stop here - do not navigate anywhere if a field is empty
            return;
        }

        // Both fields have text, so this demo treats it as a "successful" login.
        Toast.makeText(this, R.string.login_success, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        intent.putExtra(HomeActivity.EXTRA_USERNAME, username);
        startActivity(intent);
        finish(); // remove the login screen from the back stack
    }
}
