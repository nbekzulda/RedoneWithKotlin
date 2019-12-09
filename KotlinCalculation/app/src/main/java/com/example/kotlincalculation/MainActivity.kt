package com.example.kotlincalculation

import androidx.appcompat.app.AppCompatActivity

import android.content.pm.ActivityInfo
import android.view.*
import android.os.Bundle
import com.example.kotlincalculation.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var number1: Double = 0.0
    private var number2: Double = 0.0
    private var text: String? = null
    var operation: Char = ' '
    private var check = true
    private var checkNumber = true
    private var checkOperation = true
    private var delete = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {
            number1 = savedInstanceState.getDouble("number1")
            number2 = savedInstanceState.getDouble("number2")
            operation = savedInstanceState.getChar("operation")
            checkOperation = savedInstanceState.getBoolean("checkOperation")
            checkNumber = savedInstanceState.getBoolean("checkNumber")
            check = savedInstanceState.getBoolean("check")
            delete = savedInstanceState.getBoolean("delete")
            numberInput.setText(savedInstanceState.getString("numberInput"))
        }
    }


    override fun onClick(view: View) {
        try {
            if (numberInput.getText().toString() == "Infinity" || numberInput.getText().toString() == "Wrong operation please enter C" || numberInput.getText().toString() == "NaN") {
                numberInput.setText("Wrong operation please enter C")
                checkNumber = false
                delete = false
            }
            when (view.id) {

                R.id.buttonNumber0 -> {
                    if (checkNumber)
                        numberInput.append("0")
                }
                R.id.buttonNumber1 -> {
                    if (checkNumber) {
                        numberInput.append("1")
                    }
                }
                R.id.buttonNumber2 -> {
                    if (checkNumber) {
                        numberInput.append("2")
                    }
                }
                R.id.buttonNumber3 -> {
                    if (checkNumber) {
                        numberInput.append("3")
                    }
                }
                R.id.buttonNumber4 -> {
                    if (checkNumber) {
                        numberInput.append("4")
                    }
                }
                R.id.buttonNumber5 -> {
                    if (checkNumber) {
                        numberInput.append("5")
                    }
                }
                R.id.buttonNumber6 -> {
                    if (checkNumber) {
                        numberInput.append("6")
                    }
                }
                R.id.buttonNumber7 -> {
                    if (checkNumber) {
                        numberInput.append("7")
                    }
                }
                R.id.buttonNumber8 -> {
                    if (checkNumber) {
                        numberInput.append("8")
                    }
                }
                R.id.buttonNumber9 -> {
                    if (checkNumber) {
                        numberInput.append("9")
                    }

                }
                R.id.buttonDot -> {
                    if (check && checkNumber) {
                        numberInput.setText(numberInput.getText().toString() + ".")
                        check = false
                    }
                }
                R.id.buttonPlus -> {
                    check = true
                    checkNumber = true
                    checkOperation = true


                    if (numberInput.getText().toString().length != 0) {
                        number1 = (numberInput.getText().toString()).toDouble()
                    }
                    numberInput.setText("")
                    operation = '+'
                }
                R.id.buttonMultiply -> {
                    checkOperation = true
                    check = true
                    checkNumber = true
                    checkOperation = true
                    if (numberInput.getText().toString().length  != 0) {
                        number1 = (numberInput.getText().toString()).toDouble()
                    }
                    numberInput.setText("")
                    operation = 'x'
                }
                R.id.buttonMinus -> {
                    checkOperation = true
                    check = true
                    checkNumber = true
                    if (numberInput.getText().toString().length  != 0) {
                        number1 = (numberInput.getText().toString()).toDouble()
                    }
                    numberInput.setText("")
                    operation = '-'
                }
                R.id.buttonDivide -> {
                    check = true
                    checkNumber = true
                    if (numberInput.getText().toString().length  != 0) {
                        number1 = (numberInput.getText().toString()).toDouble()
                    }
                    numberInput.setText("")
                    operation = '/'
                }
                R.id.buttonMod -> {
                    check = true
                    checkNumber = true
                    if (numberInput.getText().toString().length  != 0) {
                        number1 = (numberInput.getText().toString()).toDouble()
                    }
                    numberInput.setText("")
                    operation = '%'
                }
                R.id.buttonFactorial -> {
                    try {
                        val number = (numberInput.getText().toString()).toDouble()
                        if (number < 20 && number >= 0) {
                            var s: Long = 1
                            var i = 1
                            while (i <= number) {
                                s *= i
                                i++
                            }
                            numberInput.setText(s.toString())
                        }
                    } catch (e: Exception) {
                        numberInput.setText("Wrong operation")
                    }

                }
                R.id.buttonDelete -> {
                    if (delete) {
                        text = numberInput.getText().toString()
                        if (text!!.length > 0) {
                            text = text!!.substring(0, text!!.length - 1)
                            numberInput.setText(text)
                        }
                    }
                }
                R.id.buttonResult -> {
                    checkNumber = false
                    check = false
                    try {

                        if (checkOperation) {
                            number2 = (numberInput.getText().toString()).toDouble()
                            numberInput.setText(operation(number1, number2).toString())
                            if (numberInput.getText().toString() == "NaN")
                                numberInput.setText("Wrong operation")
                            number1 = number2
                            checkOperation = false
                        } else {
                            number2 = (numberInput.getText().toString()).toDouble()
                            numberInput.setText(operation(number2, number1).toString())
                            if (numberInput.getText().toString() == "NaN")
                                numberInput.setText("Wrong operation")
                        }
                    } catch (e: Exception) {

                    }

                }
                R.id.power -> {
                    if (numberInput.getText().toString().length  != 0) {
                        number1 = (numberInput.getText().toString()).toDouble()
                    }
                    if (number1 >= 0) {
                        numberInput.setText(Math.pow(number1, number2).toString())
                    } else {
                        numberInput.setText("Wrong operation please enter C")
                    }
                }
                R.id.buttonSqrt -> {
                    if (numberInput.getText().toString().length  != 0) {
                        number1 = (numberInput.getText().toString()).toDouble()
                    }
                    if (number1 >= 0) {
                        numberInput.setText(Math.sqrt(number1).toString())
                    } else {
                        numberInput.setText("Wrong operation please enter C")
                    }
                }
                R.id.buttonSin -> {
                    if (numberInput.getText().toString().length  != 0) {
                        number1 = (numberInput.getText().toString()).toDouble()
                    }
                    if (number1 == 30.0)
                        numberInput.setText("0.5")
                    else
                        numberInput.setText(Math.sin(Math.toRadians(number1)).toString())
                }
                R.id.buttonCos -> {
                    if (numberInput.getText().toString().length  != 0) {
                        number1 = (numberInput.getText().toString()).toDouble()
                    }
                    if (number1 == 60.0)
                        numberInput.setText("0.5")
                    else
                        numberInput.setText(Math.cos(Math.toRadians(number1)).toString())
                }
                R.id.buttonClear -> {
                    checkNumber = true
                    checkOperation = true
                    check = true
                    delete = true
                    number1 = 0.0
                    number2 = 0.0
                    numberInput.setText("")
                }
            }
        }
        catch (e: Exception) {
            numberInput.setText("Wrong operation please enter C")
        }

    }

    fun operation(num1: Double, num2: Double): Double {
        when (operation) {
            '+' -> return num1 + num2
            '-' -> return num1 - num2
            'x' -> return num1 * num2
            '/' -> return num1 / num2
            '%' -> return num1 % num2
            else -> return 0.0
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("numberInput", numberInput!!.text.toString())
        outState.putDouble("number1", number1)
        outState.putDouble("number2", number2)
        outState.putBoolean("check", check)
        outState.putBoolean("checkNumber", checkNumber)
        outState.putBoolean("delete", delete)
        outState.putChar("operation", operation)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.getString("numberInput")
        savedInstanceState.getString("number1")
        savedInstanceState.getString("number2")
        savedInstanceState.getString("checkNumber")
        savedInstanceState.getString("check")
        savedInstanceState.getString("operation")
        savedInstanceState.getString("delete")
        savedInstanceState.getString("checkOperation")

    }
}