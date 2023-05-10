package com.example.demoproject.customview

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.demoproject.R

class CustomViewCalculator(context: Context, attrs: AttributeSet): ConstraintLayout(context, attrs) {

    init {
        initView()
    }

    enum class Operation {
        ADDITION,
        SUBTRACTION,
        MULTIPLICATION,
        DIVISION,
        INIT
    }

    private fun initView() {
        val v = inflate(context, R.layout.custom_layout_calculator, this)
        val btn1 = v.findViewById<Button>(R.id.btn1)
        val btn2 = v.findViewById<Button>(R.id.btn2)
        val btn3 = v.findViewById<Button>(R.id.btn3)
        val btn4 = v.findViewById<Button>(R.id.btn4)
        val btn5 = v.findViewById<Button>(R.id.btn5)
        val btn6 = v.findViewById<Button>(R.id.btn6)
        val btn7 = v.findViewById<Button>(R.id.btn7)
        val btn8 = v.findViewById<Button>(R.id.btn8)
        val btnAdd = v.findViewById<Button>(R.id.btnPlus)
        val btnEqual = v.findViewById<Button>(R.id.btnEqual)
        val edText = v.findViewById<EditText>(R.id.edText)
        var opeartion: Operation = Operation.INIT

        btn1.setOnClickListener {
            Toast.makeText(context,"1",Toast.LENGTH_SHORT).show()
            setText(edText, btn1)
        }

        btnAdd.setOnClickListener {
            opeartion = Operation.ADDITION
            Toast.makeText(context,"1",Toast.LENGTH_SHORT).show()
            setText(edText, btnAdd)
        }

        btnEqual.setOnClickListener {
            val text = edText.text.toString()
            val expr = text.split("+")
            Log.e("Expr", expr.toString())
            val ans = expr[0].toInt() + expr[1].toInt()
            when (opeartion) {
                Operation.ADDITION -> edText.setText(ans.toString())
                else -> {

                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setText(ed: EditText, btn: Button) {
        val text = ed.text.toString()
        when(btn.id) {
            R.id.btn1 -> ed.setText(text + "1")
            R.id.btnPlus -> ed.setText("$text+")
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

}