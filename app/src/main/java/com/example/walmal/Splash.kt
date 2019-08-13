package com.example.walmal

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity;
import kotlinx.android.synthetic.main.activity_splash.*

class Splash : AppCompatActivity() {
    private var mDelayHandler: Handler? = null
    private val SPLASH_DELAY: Long = 2000 //test_one seconds
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        imageSlash.animate().apply {
            duration = 1000
            x(300f)
            y(900f)
            alpha(1.7f)
            start()
        }

        //sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        val mRunnable = Runnable {
            if (!isFinishing) {
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            }
           overridePendingTransition(
             R.anim.fade_in,
             R.anim.fade_out
             )
            finish()
        }
        //Initialize the Handler
        mDelayHandler = Handler()
        Handler().postDelayed({
            //imgSlash.animate().alpha(1f).setDuration(500).start()
        }, 500)
        //Navigate with delay
        mDelayHandler!!.postDelayed(mRunnable, SPLASH_DELAY)

    }


}


