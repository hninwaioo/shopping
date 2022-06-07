package com.example.shopping.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart_item")

data class AddCartItemModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int?,

    @ColumnInfo(name = "image")
    var image: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "totalprice")
    var totalprice: Float,

    @ColumnInfo(name = "itemcount")
    var itemcount: Int,

//    @ColumnInfo(name = "priority")
//    var priority: Int

)

//class AddCartItemModel {
//
//    @PrimaryKey(autoGenerate = true)
//    private var id = 0
//
//    private var image: String? = null
//
//    private var title: String? = null
//
//    private var totalprice : Float = 0.0f
//
//    private var itemcount : Int = 0
//
//    private var priority = 0
//
//    fun AddCartItemModel(image: String?, title: String, totalprice: Float,itemcount : Int, priority: Int) {
//        this.image = image
//        this.title = title
//        this.totalprice = totalprice
//        this.itemcount = itemcount
//        this.priority = priority
//    }
//
//    fun setId(id: Int) {
//        this.id = id
//    }
//
//    fun getId(): Int {
//        return id
//    }
//
//    fun getImage(): String?{
//        return image
//    }
//
//    fun getTitle(): String? {
//        return title
//    }
//
//    fun getTotalPrice(): Float {
//        return totalprice
//    }
//
//    fun getItemCount(): Int {
//        return itemcount
//    }
//
//    fun getPriority(): Int {
//        return priority
//    }
//
//}