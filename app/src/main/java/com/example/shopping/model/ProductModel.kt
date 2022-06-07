package com.example.shopping.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ProductModel : Serializable{

    @SerializedName("id")
    var id: Int = 0;

    fun getProductId(): Int {
        return id
    }

    fun setProductId(id: Int) {
        this.id = id
    }

    @SerializedName("title")
    var title: String? = null

    fun getProductTitle(): String{
        return title!!
    }
    fun setProductTitle(title: String){
        this.title = title
    }

    @SerializedName("price")
    var price: Float = 0.0f

    fun getProductPrice(): Float{
        return price
    }
    fun setProductPrice(price: Float){
        this.price = price
    }

    @SerializedName("description")
    var description: String? = null

    fun getProductDescription(): String{
        return description!!
    }
    fun setProductDescription(description: String){
        this.description = description
    }

    @SerializedName("category")
    var category : String? = null

    fun getProductCategory(): String{
        return category!!
    }
    fun setProductCategory(category: String){
        this.category = category
    }

    @SerializedName("image")
    var image : String? = null

    fun getProductImage(): String{
        return image!!
    }
    fun setProductImage(image: String){
        this.image = image
    }

    @SerializedName("rating")
    lateinit var rating : ProductRating

    fun getProductRateing(): ProductRating{
        return rating
    }
    fun setProductRating(rating: ProductRating){
        this.rating = rating
    }
}



