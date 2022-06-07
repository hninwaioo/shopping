package com.za.sbs.delivery.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.za.sbs.delivery.R
import com.za.sbs.delivery.utils.Storage
import com.za.sbs.delivery.auth.LoginActivity
import kotlinx.android.synthetic.main.content_font_dector.*
import org.jetbrains.anko.startActivity

class FontDetectorActivity : AppCompatActivity() {

    var uni = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_font_detector)

        cv_uni.setOnClickListener {
            checkbox_uni.visibility = View.VISIBLE
            checkbox_zawgyi.visibility = View.GONE
            uni = false
        }

        cv_zawgyi.setOnClickListener {
            checkbox_uni.visibility = View.GONE
            checkbox_zawgyi.visibility = View.VISIBLE
            uni = true
        }

        btn_choose_font.setOnClickListener {

            Storage.make(this).saveIsZawgyi(uni)
            Storage.make(this).saveIsFirstTime(false)

//            val token = Storage.make(applicationContext).authToken
//
//            if (token == null) {
//                startActivity(Intent(this@FontDetectorActivity, LoginActivity::class.java))
//                Log.d("App", "App_Login")
//                finish()
//            } else {
//                startActivity(Intent(this@FontDetectorActivity, MainActivity::class.java))
//                Log.d("Main", "MainActivity")
//                finish()
//            }

            startActivity<LoginActivity>()
            finish()
        }

    }
}
