package me.bndev.memorizeapps;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import me.bndev.memorizeapps.utils.DatabaseManager;
import me.bndev.memorizeapps.utils.SessionManager;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Thread(new Runnable() {
            @Override
            public void run() {
                DatabaseManager.init(getApplicationContext());

                SessionManager session = SessionManager.init(getApplicationContext());
                session.putString(SessionManager.keyUserId, "1")
                        .putString(SessionManager.keyUserName, "bagasn")
                        .putString(SessionManager.keyFullName, "Bagas Nasution")
                        .apply();

                session.printSession();

                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                toHome();
            }
        }).start();
    }

    @Override
    public void onBackPressed() {

    }

    private void toHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }


}
