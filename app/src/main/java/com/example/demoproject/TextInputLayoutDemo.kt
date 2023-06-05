package com.example.demoproject

import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlin.reflect.typeOf

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TextInputLayoutDemo.newInstance] factory method to
 * create an instance of this fragment.
 */
class TextInputLayoutDemo : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        return inflater.inflate(R.layout.fragment_text_input_layout_demo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tfEmailLayout = view.findViewById<TextInputLayout>(R.id.tfEmailLayout)
        val tfEmail = view.findViewById<TextInputEditText>(R.id.tfEmail)
        val tfPassLayout = view.findViewById<TextInputLayout>(R.id.tfUsernameLayout)
        val tfPass = view.findViewById<TextInputEditText>(R.id.tfUserName)
        val btnClick = view.findViewById<Button>(R.id.btnClick)

        btnClick.setOnClickListener {
            if (tfEmail.text!!.isEmpty()) {
                tfEmailLayout.isErrorEnabled = true
                tfEmailLayout.error = "Please fill this field"
            } else {
                tfEmailLayout.isErrorEnabled = false
                tfEmailLayout.error = ""
            }
            if (tfPass.text!!.isEmpty()) {
                tfPassLayout.isErrorEnabled = true
                tfPassLayout.error = "Please Fill this field"
            } else {
                tfPassLayout.isErrorEnabled = false
                tfPassLayout.error = ""
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TextInputLayoutDemo.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TextInputLayoutDemo().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}