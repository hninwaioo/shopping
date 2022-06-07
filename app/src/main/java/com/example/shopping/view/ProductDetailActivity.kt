package com.example.shopping.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.shopping.R
import com.example.shopping.model.AddCartItemModel
import com.example.shopping.model.ProductModel
import com.example.shopping.viewmodel.AddCartItemViewModel
import com.example.shopping.viewmodel.AddCartItemViewModelFactory
import org.jetbrains.anko.doAsync
import java.util.*


class ProductDetailActivity : AppCompatActivity() {

    private lateinit var Show_product_image : ImageView
    private lateinit var Show_product_title : TextView
    private lateinit var Show_product_category : TextView
    private lateinit var Show_product_description: TextView
    private lateinit var Show_product_price : TextView

    private lateinit var Minus_count : TextView
    private lateinit var Plus_count : TextView
    private lateinit var Count_number : TextView

    private lateinit var productorder: ProductModel
    private var count_item : Int = 0
    private var count = 1
    private var item_price : Float = 0.0f
    private var item_count_price : Float = 0.0f

    lateinit var Add_cart_btn: ImageView;
    private lateinit var addCartItemViewModel: AddCartItemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val intent = intent
        productorder = intent.getSerializableExtra("order") as ProductModel

        Show_product_title = findViewById<TextView>(R.id.show_product_title)
        Show_product_category = findViewById<TextView>(R.id.show_product_category)
        Show_product_description = findViewById<TextView>(R.id.show_product_description)
        Show_product_price = findViewById<TextView>(R.id.show_product_price)
        Show_product_image = findViewById<ImageView>(R.id.show_product_image)
        Glide.with(this).load(productorder.image).into(Show_product_image)

        Minus_count = findViewById<TextView>(R.id.minus_count)
        Plus_count = findViewById<TextView>(R.id.plus_count)
        Count_number = findViewById<TextView>(R.id.count_number)
        Add_cart_btn = findViewById<ImageView>(R.id.add_cart_btn)

        Show_product_title.text = productorder.title
        Show_product_category.text = productorder.category
        Show_product_price.text = "$ ${productorder.price.toString()}"
        Show_product_description.text = productorder.description

        item_price = productorder.price
        count_item = productorder.rating.count
        Log.e("Count--",count_item.toString())


        Minus_count.setOnClickListener {

                if (count > 1){
                    count --
                    item_count_price = item_price * count
                    Show_product_price.text = "$ ${item_count_price}"
                    Log.e("CountM==>",count.toString())
                    Count_number.text = count.toString()
                }
            }

        if (count==1){
            Count_number.text = count.toString()

            Plus_count.setOnClickListener {
                if (count>=count_item){
                    Toast.makeText(this,"No Item Avaliable",Toast.LENGTH_SHORT).show()

                }else{
                    count ++
                    item_count_price= item_price * count;
                    Show_product_price.text = "$ ${item_count_price}"
                    Log.e("CountP==>",count.toString())
                    Count_number.text = count.toString()
                }
            }
        }

        val modelfactory=AddCartItemViewModelFactory(application);

        addCartItemViewModel = ViewModelProvider(this,modelfactory).get(AddCartItemViewModel::class.java)

        Add_cart_btn.setOnClickListener {
            doAsync {
                addCartItemViewModel.insert(AddCartItemModel(null,
                    productorder.image!!, productorder.title!!,item_count_price,count))
                Log.e("SuccessData==>","SuccessData")
            }

            Toast.makeText(this,"SuccessFull Add To Cart !",Toast.LENGTH_SHORT).show()
        }
    }
}