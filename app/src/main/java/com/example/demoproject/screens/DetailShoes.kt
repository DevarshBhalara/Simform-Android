package com.example.demoproject.screens

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.demoproject.R
import com.example.demoproject.binding.DetailsShoesViewModel
import com.example.demoproject.databinding.FragmentDetailShoesBinding
import com.google.android.material.chip.Chip
import kotlin.math.roundToInt

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailShoes.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailShoes : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentDetailShoesBinding
    private var isSelected = true

    private val detailsShoesViewModel: DetailsShoesViewModel by viewModels()

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
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDetailShoesBinding.inflate(layoutInflater)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.detailsShoesViewModel = detailsShoesViewModel
        setUpUI()
        setUpRatingBar()
        setUpChips()
        setUpColorRadioButton()
        setUpButtonCountrySizeButtonClick()
    }


    private fun setUpButtonCountrySizeButtonClick() {
        binding.btnUK.setOnClickListener {
            binding.btnUK.setTextColor(requireContext().getColor(R.color.black))
            binding.btnEU.setTextColor(requireContext().getColor(R.color.lightgray))
            binding.btnID.setTextColor(requireContext().getColor(R.color.lightgray))
        }

        binding.btnEU.setOnClickListener {
            binding.btnUK.setTextColor(requireContext().getColor(R.color.lightgray))
            binding.btnEU.setTextColor(requireContext().getColor(R.color.black))
            binding.btnID.setTextColor(requireContext().getColor(R.color.lightgray))
        }

        binding.btnID.setOnClickListener {
            binding.btnUK.setTextColor(requireContext().getColor(R.color.lightgray))
            binding.btnEU.setTextColor(requireContext().getColor(R.color.lightgray))
            binding.btnID.setTextColor(requireContext().getColor(R.color.black))
        }
    }

    private fun setUpColorRadioButton() {
        for (i in 0 until detailsShoesViewModel.shoesDetails.colors.size) {
            val radioButton = RadioButton(context).apply {
                this.height = dpToPx(35)
                this.width = dpToPx(35)
                this.background = context.getDrawable(R.drawable.color_picker)
                this.background.setTint(Color.parseColor(detailsShoesViewModel.shoesDetails.colors[i]))
                this.buttonDrawable = null
            }
            binding.rgColors.addView(radioButton)
        }
    }

    private fun setUpChips() {
        for (i in 0 until detailsShoesViewModel.shoesDetails.sizes.size) {
            val chip = Chip(context).apply {
                text = detailsShoesViewModel.shoesDetails.sizes[i].toString()
                this.setChipBackgroundColorResource(R.color.details_shoes_size_chip)
                this.checkedIcon = null
                this.isCheckable = true
                this.chipCornerRadius = 10F
                this.setTextColor(context.getColor(R.color.details_shoes_text_color))
            }
            binding.chipSizeGroup.addView(chip)
        }

    }

    private fun setUpRatingBar() {
        binding.ratingBar.rating = detailsShoesViewModel.shoesDetails.rating.toFloat()
    }

    private fun setUpUI() {
        val spannable = SpannableString("Detail Shoes")
        spannable.setSpan(
            ForegroundColorSpan(Color.RED),
            6, // start
            8, // end
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        Log.e("title", spannable.toString())
        binding.appBarTitle = spannable.toString()
    }

    fun dpToPx(dp: Int): Int {
        val density: Float = requireContext().resources
            .displayMetrics.density
        return (dp.toFloat() * density).roundToInt()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DetailShoes.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DetailShoes().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}