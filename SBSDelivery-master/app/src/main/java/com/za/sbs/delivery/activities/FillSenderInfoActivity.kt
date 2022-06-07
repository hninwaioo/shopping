package com.za.sbs.delivery.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.za.sbs.delivery.R
import kotlinx.android.synthetic.main.activity_fill_sender_info.*

class FillSenderInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fill_sender_info)

        fill_receive_btn.setOnClickListener {
            var intent = Intent(this,FillReceiverInfoActivity::class.java)
            startActivity(intent)
        }
    }
}
