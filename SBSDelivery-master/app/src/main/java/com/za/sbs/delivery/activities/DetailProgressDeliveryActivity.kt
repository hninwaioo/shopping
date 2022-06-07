package com.za.sbs.delivery.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.za.sbs.delivery.R
import kotlinx.android.synthetic.main.activity_detail_progress.*

class DetailProgressDeliveryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_progress)

        back.setOnClickListener {
            finish()
        }

        no_deliver_btn.setOnClickListener {

            var intent = Intent(this,DeliverNotOKActivity::class.java)
            startActivity(intent)
        }

        delivered_btn.setOnClickListener {

            var intent = Intent(this,CompleteDeliveredActivity::class.java)
            startActivity(intent)
        }
    }
}
