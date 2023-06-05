package com.example.demoproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CheckBoxDemo.newInstance] factory method to
 * create an instance of this fragment.
 */
class CheckBoxDemo : Fragment() {
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
        return inflater.inflate(R.layout.fragment_check_box_demo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cbElite = view.findViewById<CheckBox>(R.id.cbElite)
        val cbWhatMonday = view.findViewById<CheckBox>(R.id.cbWhatHappenedToMonday)
        val cbLucifer = view.findViewById<CheckBox>(R.id.cbLucifer)
        val btnShowDetails = view.findViewById<Button>(R.id.btnShowDetails)

        cbElite.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                Toast.makeText(context,"Checked ${cbElite.text}", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context,"Unchecked ${cbElite.text}", Toast.LENGTH_SHORT).show()
            }
        }

        btnShowDetails.setOnClickListener {
            var watchedList = ""
            if (cbElite.isChecked) {
                watchedList += " ${cbElite.text} "
            }
            if (cbWhatMonday.isChecked) {
                watchedList += " ${cbWhatMonday.text}"
            }
            if (cbLucifer.isChecked) {
                watchedList += " ${cbLucifer.text}"
            }
            Toast.makeText(context,watchedList,Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CheckBoxDemo.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CheckBoxDemo().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}