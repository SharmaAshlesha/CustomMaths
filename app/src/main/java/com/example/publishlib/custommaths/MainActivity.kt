package com.example.publishlib.custommaths

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.example.publishlib.custommath.CustomMaths


class MainActivity : AppCompatActivity() {
    @BindView(R.id.edit_text_value1)
    private lateinit var editTextValue1: EditText

    @BindView(R.id.edit_text_value2)
    private lateinit var editTextValue2: EditText

    @BindView(R.id.text_result)
    private lateinit var textResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
    }

    @OnClick(R.id.btn_add)
    fun add() {
        if(!isValidData()){
            return
        }
        textResult.text = String.format(getString(R.string.text_result),CustomMaths.add(getNumericValueOf(editTextValue1) , getNumericValueOf(editTextValue1)))
    }

    private fun isValidData(): Boolean {
        return (isNumeric(editTextValue1) && isNumeric(editTextValue2))
    }

    @OnClick(R.id.btn_sub)
    fun sub() {
        if(!isValidData()){
            return
        }
        textResult.text = String.format(getString(R.string.text_result),CustomMaths.sub(getNumericValueOf(editTextValue1) , getNumericValueOf(editTextValue1)))
    }

    @OnClick(R.id.btn_mul)
    fun mul() {
        if(!isValidData()){
            return
        }
        String.format(getString(R.string.text_result),CustomMaths.multiply(getNumericValueOf(editTextValue1) , getNumericValueOf(editTextValue1)))
    }
    private fun getNumericValueOf(editField: EditText): Int {
        return Integer.valueOf(editField.text.toString())
    }

    private fun isNumeric(editField: EditText): Boolean {
        return try {
            Integer.valueOf(editField.text.toString())
            true
        } catch (e:Exception){
            false
        }
    }
}
