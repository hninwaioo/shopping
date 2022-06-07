package com.example.shopping.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.shopping.R
import com.example.shopping.adapter.ProductListAdapter
import com.example.shopping.api.RetrofitService
import com.example.shopping.databinding.ActivityMainBinding
import com.example.shopping.model.ProductModel
import com.example.shopping.repository.ProductListRepository
import com.example.shopping.repository.ProductListViewModelFactory
import com.example.shopping.viewmodel.ProductListViewModel


class MainActivity() : AppCompatActivity() {

    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    private var position_id : Int = 0

    lateinit var productlistviewModel: ProductListViewModel

    private val retrofitService = RetrofitService.getInstance()
    val productListAdapter = ProductListAdapter()

    private lateinit var View_cart_btn : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        View_cart_btn = findViewById(R.id.view_cart_btn)
        View_cart_btn.setOnClickListener {
            var intent = Intent(this,ProductCartActivity::class.java)
            startActivity(intent)
        }
        //get viewmodel instance using ViewModelProvider.Factory
        productlistviewModel =
            ViewModelProvider(this, ProductListViewModelFactory(ProductListRepository(retrofitService))).get(
                ProductListViewModel::class.java
            )

        //set adapter in recyclerview
        binding.recyclerview.adapter = productListAdapter

        //the observer will only receive events if the owner(activity) is in active state
        //invoked when movieList data changes
        productlistviewModel.productsList.observe(this,Observer{
            Log.e(TAG, "productlist==> $it")

            productListAdapter.setProductsList(it)
            productListAdapter.setOnClickListener(object : ProductListAdapter.onItemClickListener{
                override fun onItemClick(position: Int) {
//                    Toast.makeText(this@MainActivity,position,Toast.LENGTH_SHORT).show()

                    position_id = position+1
                    Log.e("PositionId ==>",position_id.toString())
                    goToDetail(it)
                }

            })

        })

        Log.e("sdfsaf===>","Success")

        //invoked when a network exception occurred
        productlistviewModel.errorMessage.observe(this, Observer {
            Log.e(TAG, "errorMessage: $it")
        })

        productlistviewModel.getAllProductList()

    }

    private fun goToDetail(productList: List<ProductModel>) {

        for (order in productList) {
            if (order.id == position_id) {
                val intent = Intent(applicationContext, ProductDetailActivity::class.java)
//                intent.putExtra("order_title", order.title)
//                intent.putExtra("order_category", order.category)
//                intent.putExtra("order_description",order.description)
//                intent.putExtra("order_price",order.price)
//                intent.putExtra("order_image",order.image)
//                intent.putExtra("order_id",order.id)
                intent.putExtra("order",order)

                startActivity(intent)
    Log.e("SuccessId","Success_Id")
                return
            }
        }

    }

}