package com.example.demoproject.binding

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demoproject.model.ShoesDetailsModel

class DetailsShoesViewModel: ViewModel() {

    private val _shoes = MutableLiveData<ShoesDetailsModel>()
    var shoes: LiveData<ShoesDetailsModel> = _shoes

    val shoesDetails = ShoesDetailsModel("Converse chuck taylor",
        "$292.99",
        "4.9",
        "We've updated the look with open tongue foam for added comfort and style, with deco stitching details that started on the basketball court.",
        arrayOf(29,30,33),
        arrayOf("#55528c", "#1373eb", "#ffc0ca", "#b094ff")
    )

    init {
        _shoes.value = shoesDetails
    }

}