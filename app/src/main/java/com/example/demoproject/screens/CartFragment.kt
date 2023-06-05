package com.example.demoproject.screens

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.demoproject.R
import com.example.demoproject.binding.ShoesCartViewModel
import com.example.demoproject.databinding.FragmentCartBinding
import com.example.demoproject.databinding.FragmentDetailShoesBinding
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.roundToInt

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CartFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentCartBinding

    private val shoesCartViewModel: ShoesCartViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCartBinding.inflate(layoutInflater)
        binding.shoesCartDetailsViewModel = shoesCartViewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        quantityCountButtonClick()
        setUpRatingBar()
    }

    private fun setUpRatingBar() {
        binding.ratingBar.rating = shoesCartViewModel.shoesCartDetails.shoesRating.toFloat()
        binding.ratingBar.isClickable = false
    }
    private fun quantityCountButtonClick() {
        binding.btnPlus.setOnClickListener {
            var qtyCount = shoesCartViewModel.shoesCartDetails.shoesQtyCount
            qtyCount = (qtyCount.toInt() + 1).toString()
            shoesCartViewModel.shoesCartDetails.shoesQtyCount = qtyCount
            Log.e("Model", shoesCartViewModel.shoesCartDetails.toString())
            updateShoesPriceSubTotal(qtyCount)
        }

        binding.btnMinus.setOnClickListener {
            var qtyCount = shoesCartViewModel.shoesCartDetails.shoesQtyCount
            if (qtyCount.toInt() > 1) {
                qtyCount = (qtyCount.toInt() - 1).toString()
                shoesCartViewModel.shoesCartDetails.shoesQtyCount = qtyCount
                Log.e("Model", shoesCartViewModel.shoesCartDetails.toString())
                updateShoesPriceSubTotal(qtyCount)
            }
        }
    }

    private fun updateShoesPriceSubTotal(qtyCount: String) {
        var price = shoesCartViewModel.shoesCartDetails.shoesPrice
        price = (price.toFloat() * qtyCount.toFloat()).toString()
        shoesCartViewModel.shoesCartDetails.shoesItemPrice = price

        val subTotal = (shoesCartViewModel.shoesCartDetails.shoesItemPrice.toFloat() +
                shoesCartViewModel.shoesCartDetails.shoesTaxPrice.toFloat() +
                shoesCartViewModel.shoesCartDetails.shoesShippingPrice.toFloat())
        shoesCartViewModel.shoesCartDetails.shoesSubTotal = DecimalFormat("#.##").format(subTotal)

        shoesCartViewModel.plusMinusIconClicked()
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CartFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CartFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}