package com.example.demoproject.model

import java.text.DecimalFormat

data class ShoesCartModel(
    val shoesName: String,
    val shoesRating: String,
    val shoesSpecificationTitle: String,
    val shoesSpecificationDetail: String,
    var shoesPrice: String,
    val shoesShippingPrice: String,
    val shoesTaxPrice: String,
    var shoesQtyCount: String,
    var shoesItemPrice: String = shoesPrice,
    var shoesSubTotal: String = DecimalFormat("#.##").format (shoesPrice.toFloat() + shoesShippingPrice.toFloat() + shoesTaxPrice.toFloat()).toString()
)