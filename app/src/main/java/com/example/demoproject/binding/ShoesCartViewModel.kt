package com.example.demoproject.binding

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demoproject.model.ShoesCartModel
import kotlin.math.log

class ShoesCartViewModel: ViewModel() {
    private val _shoesCart = MutableLiveData<ShoesCartModel>()
    var shoesCart: LiveData<ShoesCartModel> = _shoesCart

    val shoesCartDetails = ShoesCartModel(
        "Converse chuck taylor",
        "4.9",
        "All Star hi unisex  Sneaker Shoes- Purple",
        "This is a PG basketball shoe, made over 100 years ago. Or that most of the design is still the same. These shoes become your favorite sneaker, and make each one their own.",
        "294.99",
        "10.55",
        "2.99",
        "1",
    )

    init {
        _shoesCart.value = shoesCartDetails
    }

    fun plusMinusIconClicked() {
        Log.e("InViewModel", shoesCartDetails.toString())
        _shoesCart.value = shoesCartDetails
        Log.e("ShoesCart",_shoesCart.value.toString())
    }
}