package com.example.shopping.view

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shopping.R
import com.example.shopping.adapter.AddCartItemListAdapter
import com.example.shopping.viewmodel.AddCartItemViewModel
import com.example.shopping.viewmodel.AddCartItemViewModelFactory
import org.json.JSONObject

class ProductCartActivity : AppCompatActivity() {

    lateinit var cart_item_recyclerview: RecyclerView;
    private lateinit var addCartItemViewModel: AddCartItemViewModel

    private lateinit var Subtotal_dollar : TextView
    private lateinit var Tax_percent : TextView
    private lateinit var Include_tax : TextView

    private lateinit var view_cart_btn : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_cart)

        Subtotal_dollar = findViewById<TextView>(R.id.subtotal_dollar)
        Tax_percent = findViewById<TextView>(R.id.tax_amount)
        Include_tax = findViewById<TextView>(R.id.total_include_tax)
        cart_item_recyclerview=findViewById<RecyclerView>(R.id.add_cart_item_recyclerview)

        val modelfactory=AddCartItemViewModelFactory(application);

        addCartItemViewModel = ViewModelProvider(this,modelfactory).get(AddCartItemViewModel::class.java)

        // Specify layout for recycler view
        val linearLayoutManager = LinearLayoutManager(
            this, RecyclerView.VERTICAL,false)
        cart_item_recyclerview.layoutManager = linearLayoutManager

        // Observe the model
        addCartItemViewModel.allCartItem.observe(this, Observer{ cartItem->
            // Data bind the recycler view
            cart_item_recyclerview.adapter = AddCartItemListAdapter(cartItem)

            val costs  = cartItem.sumByDouble { it.totalprice.toDouble() }
            var costs2digits:Double = String.format("%.2f", costs).toDouble()

            Subtotal_dollar.text = "$ ${costs2digits.toString()}"
            Log.e("SubTotal==>",costs2digits.toString())

            var calculatetax = costs * 0.03
            var calculatetax2digits:Double = String.format("%.2f", calculatetax).toDouble()

            Tax_percent.text="$ ${calculatetax2digits.toString()}"
            var includetax = costs+calculatetax
            var includetax2digits:Double = String.format("%.2f", includetax).toDouble()

            Include_tax.text = "$ ${includetax2digits.toString()}"
            Log.e("Include_tax==>",includetax2digits.toString())

        })

        view_cart_btn = findViewById<ImageView>(R.id.view_cart_btn)
        view_cart_btn.setOnClickListener {
            finish()
        }

    }
}