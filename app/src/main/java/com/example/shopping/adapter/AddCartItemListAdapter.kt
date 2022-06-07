package com.example.shopping.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shopping.R
import com.example.shopping.model.AddCartItemModel

class AddCartItemListAdapter(val cartitem: List<AddCartItemModel>)
    : RecyclerView.Adapter<AddCartItemListAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : AddCartItemListAdapter.ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.add_cart_item_layout,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: AddCartItemListAdapter.ViewHolder, position: Int) {
        holder.cart_totalprice.text = "Total Price : ${cartitem[position].totalprice.toString()}"
        holder.cart_totalItem.text = "SelectedItem : $ ${cartitem[position].itemcount.toString()}"
        holder.cart_title.text = cartitem[position].title
        Glide.with(holder.itemView.context).load(cartitem[position].image).into(holder.cart_image)

    }

    override fun getItemCount(): Int {
        return cartitem.size
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var cart_image=itemView.findViewById<ImageView>(R.id.cart_item_image)
        var cart_title = itemView.findViewById<TextView>(R.id.cart_item_title)
        var cart_totalprice = itemView.findViewById<TextView>(R.id.cart_total_price)
        var cart_totalItem=itemView.findViewById<TextView>(R.id.cart_total_count);

    }
}