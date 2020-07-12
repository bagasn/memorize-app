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

                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    String userId = SessionManager.init(getApplicationContext())
                            .getString(SessionManager.keyUserId);

                    if (userId.isEmpty())
                        moveTo(LoginActivity.class);
                    else
                        moveTo(HomeActivity.class);
                }
            }
        }).start();
    }

    @Override
    public void onBackPressed() {

    }

    private void moveTo(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
        finish();
    }


}
