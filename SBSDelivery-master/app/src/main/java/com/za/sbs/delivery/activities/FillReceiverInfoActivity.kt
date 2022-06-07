package com.za.sbs.delivery.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.za.sbs.delivery.R
import kotlinx.android.synthetic.main.activity_fill_receiver_info.*

class FillReceiverInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fill_receiver_info)

        deliver_product_btn.setOnClickListener {

            var intent = Intent(this,DeliverProductsInfoActivity::class.java)
            startActivity(intent)
        }
    }
}
