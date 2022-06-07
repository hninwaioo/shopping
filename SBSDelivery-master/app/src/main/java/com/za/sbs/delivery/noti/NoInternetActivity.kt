package com.za.sbs.delivery.noti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import com.za.sbs.delivery.R
import com.za.sbs.delivery.utils.isInternetAvailable
import kotlinx.android.synthetic.main.activity_no_internet.*

class NoInternetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_no_internet)
        btnRetry.setOnClickListener {
            startActivity(Intent(Settings.ACTION_DATA_ROAMING_SETTINGS))
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(this.isInternetAvailable())
        finish()

    }


}
