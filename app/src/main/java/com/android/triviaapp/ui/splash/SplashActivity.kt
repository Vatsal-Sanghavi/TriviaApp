package com.android.triviaapp.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.android.triviaapp.R
import com.android.triviaapp.ui.game.views.GameActivity
import com.android.triviaapp.ui.history.views.HistoryActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        initViews()
    }

    private fun initViews() {
        // Show splash screen for desire time, in millis
        Handler(Looper.getMainLooper()).postDelayed({
            // After specified delay navigate to App flow
            GameActivity.start(this)
            finish()
        }, 2500)
    }
}