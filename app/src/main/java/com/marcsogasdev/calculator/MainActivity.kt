package com.marcsogasdev.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var tvInput: TextView? = null

    //private var btnOne : Button? = null
    var lastNumeric: Boolean = false
    var lastDot: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvInput = findViewById(R.id.tv_Input)

    }

    fun onDigit(view: View) {
        //Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show()

        //take the number of button and put on tvInput
        tvInput?.append((view as Button).text)
        lastNumeric = true
        lastDot = false

        /*
        var sentence = "marc"
        if(sentence.contains("marc")){

            tvInput?.append("Denis")
        }

        btnOne = findViewById(R.id.btnOne)
        btnOne?.setOnClickListener {
            tvInput?.append("1")
        }*/

    }

    fun onClear(view: View) {
        tvInput?.text = ""
    }

    fun onDecimalPoint(view: View) {
        if (lastNumeric && !lastDot) {
            tvInput?.append(".")
            lastNumeric = false
            lastDot = true
        }
    }

    fun onOperator(view: View) {
        tvInput?.text?.let {
            if (lastNumeric && !isOperatorAdded(it.toString())){
                tvInput?.append((view as Button).text)
                lastNumeric = false
                lastDot = false
            }
        }
    }


    private fun isOperatorAdded(value:String) : Boolean{
        return if (value.startsWith("-")){
            false
        }else{
            value.contains("/")
                || value.contains("*")
                || value.contains("+")
                || value.contains("-")
                //|| value.contains(".")
        }
    }

    fun onEqual(view : View){
        if(lastNumeric){
            var tvValue = tvInput?.text.toString()

        }

    }



}