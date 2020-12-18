package me.bndev.memorizeapps

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import me.bndev.memorizeapps.app.config.Tags

class SplashActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Thread {
            try {
                Thread.sleep(1000)
                sessionValidate()
            } catch (e: InterruptedException) {
                Log.e(Tags.ERROR, "onCreate: ", e)
            }
        }.start()
    }

    private fun sessionValidate() {

    }

}