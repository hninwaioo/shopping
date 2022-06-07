package com.za.sbs.delivery.noti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.za.sbs.delivery.R
import com.za.sbs.delivery.utils.MarshMallowPermissionUtils
import kotlinx.android.synthetic.main.activity_camera_permission.*

class CameraPermissionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera_permission)

        btnPermissionOn.setOnClickListener {

            val permissionUtils = MarshMallowPermissionUtils(this)
            permissionUtils.requestPermissionForCamera()
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        finish()

    }
}