package com.example.shopping.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shopping.databinding.ProductItemLayoutBinding
import com.example.shopping.model.ProductModel


class ProductListAdapter : RecyclerView.Adapter<ProductListViewHolder>() {

    private lateinit var mListener : onItemClickListener
    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnClickListener(listener : onItemClickListener){
        mListener = listener
    }

    var productslist = mutableListOf<ProductModel>()

    fun setProductsList(products: List<ProductModel>) {
        this.productslist = products.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = ProductItemLayoutBinding.inflate(inflater, parent, false)
        return ProductListViewHolder(binding,mListener)
    }

    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int) {
        val product = productslist[position]

        holder.binding.productName.text = product.title
        holder.binding.productPrice.text = "$ ${product.price.toString()}"
        holder.binding.productRate.text = product.rating.rate.toString()
//        Glide.with(holder.itemView.context).load(product.image).placeholder(R.drawable.ic_launcher_background)
//            .into(holder.binding.productImage)
        Glide.with(holder.itemView.context).load(product.image).into(holder.binding.productImage)

        holder.binding.ratingStar.rating = product.rating.rate
//        val d = (number * 5 / 100)

        holder.itemView.setOnClickListener {

            mListener.onItemClick(position)
        }


        //if true, your checkbox will be selected, else unselected

        //if true, your checkbox will be selected, else unselected


    }

    override fun getItemCount(): Int {
        return productslist.size
    }
}

class ProductListViewHolder(val binding: ProductItemLayoutBinding,listener : ProductListAdapter.onItemClickListener) : RecyclerView.ViewHolder(binding.root) {

}