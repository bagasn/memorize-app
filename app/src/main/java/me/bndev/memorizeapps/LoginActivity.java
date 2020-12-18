package me.bndev.memorizeapps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

import me.bndev.memorizeapps.app.utils.SessionManager;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    private TextInputEditText textUsername;
    private TextInputEditText textPassword;
    private ProgressBar progressLoading;
    private Button buttonLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textUsername = findViewById(R.id.textUsername);
        textPassword = findViewById(R.id.textPassword);
        progressLoading = findViewById(R.id.progressCircular);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = Objects.requireNonNull(
                        textUsername.getText()).toString();
                String password = Objects.requireNonNull(
                        textPassword.getText()).toString();

                doLogin(username.trim(), password);
            }
        });
    }

    private void doLogin(String username, String password) {
        if (username.isEmpty()) {
            textUsername.setError("Username can't be empty");
            return;
        }
        if (password.isEmpty()) {
            textPassword.setError("Password must filled");
            return;
        }

        setLoadingState(true);

        if (username.equals("bagasn") && password.equals("123")) {
//            SessionManager session = SessionManager.init(getApplicationContext());
//            session.putString(SessionManager.keyUserId, "1")
//                    .putString(SessionManager.keyUserName, "bagasn")
//                    .putString(SessionManager.keyFullName, "Bagas Nasution")
//                    .apply();
//
//            session.printSession();

            startActivity(new Intent(this, HomeActivity.class));
            finish();
        } else {
            Toast.makeText(this, "Username and password not match for any user",
                    Toast.LENGTH_SHORT).show();
            setLoadingState(false);
        }
    }

    private void setLoadingState(boolean isLoading) {
        if (isDestroyed()) return;

        if (isLoading) {
            buttonLogin.setVisibility(View.GONE);
            progressLoading.setVisibility(View.VISIBLE);

            textUsername.setEnabled(false);
            textPassword.setEnabled(false);
        } else {
            progressLoading.setVisibility(View.GONE);
            buttonLogin.setVisibility(View.VISIBLE);

            textUsername.setEnabled(true);
            textPassword.setEnabled(true);
        }
    }
}
