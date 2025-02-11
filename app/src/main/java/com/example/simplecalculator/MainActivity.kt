package com.example.simplecalculator

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var ce: TextView
    private lateinit var c: TextView
    private lateinit var back: TextView
    private lateinit var div: TextView
    private lateinit var num7: TextView
    private lateinit var num8: TextView
    private lateinit var num9: TextView
    private lateinit var mul: TextView
    private lateinit var num4: TextView
    private lateinit var num5: TextView
    private lateinit var num6: TextView
    private lateinit var sub: TextView
    private lateinit var num1: TextView
    private lateinit var num2: TextView
    private lateinit var num3: TextView
    private lateinit var add: TextView
    private lateinit var oppo: TextView
    private lateinit var num0: TextView
    private lateinit var dot: TextView
    private lateinit var equal: TextView
    private lateinit var res: TextView

    private var calculation = ""
    private var calculation1 = ""
    private var calculation2 = ""
    private var state = 1
    private var state1 = 0
    private var op1 = 0
    private var op2 = 0
    private var cal = 0
    private var result = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ce = findViewById(R.id.button1)
        c = findViewById(R.id.button2)
        back = findViewById(R.id.button3)
        div = findViewById(R.id.button4)
        num7 = findViewById(R.id.button5)
        num8 = findViewById(R.id.button6)
        num9 = findViewById(R.id.button7)
        mul = findViewById(R.id.button8)
        num4 = findViewById(R.id.button9)
        num5 = findViewById(R.id.button10)
        num6 = findViewById(R.id.button11)
        sub = findViewById(R.id.button12)
        num1 = findViewById(R.id.button13)
        num2 = findViewById(R.id.button14)
        num3 = findViewById(R.id.button15)
        add = findViewById(R.id.button16)
        oppo = findViewById(R.id.button17)
        num0 = findViewById(R.id.button18)
        dot = findViewById(R.id.button19)
        equal = findViewById(R.id.button20)
        res = findViewById(R.id.textView)

        fun onClick(v: View?) {
            v?.let {
                val id = it.id
                when (id) {
                    num0.id, num1.id, num2.id, num3.id, num4.id, num5.id,
                    num6.id, num7.id, num8.id, num9.id -> {
                        state1 = 0
                        calculation += (it as TextView).text
                        calculation1 += it.text
                        result += it.text
                        res.text = calculation
                    }

                    add.id, sub.id, mul.id, div.id -> {
                        cal = when (id) {
                            add.id -> 1
                            sub.id -> 2
                            mul.id -> 3
                            div.id -> 4
                            else -> 0
                        }

                        if (state == 1) {
                            if (calculation == "" && state1 != 1) {
                                return
                            } else if (state1 == 1) {
                                calculation = res.text.toString() + (it as TextView).text
                                res.text = calculation
                                return
                            } else {
                                state = 2
                                op1 = calculation1.toInt()
                            }
                        }

                        calculation1 = ""
                        calculation += (it as TextView).text
                        calculation2 = calculation
                        res.text = calculation
                    }

                    equal.id -> {
                        if (calculation == "+" || calculation == "-" || calculation == "*" || calculation == "/") {
                            return
                        }

                        if (state == 1) {
                            res.text = res.text.toString()
                        }
                        if (calculation == "" && state == 1) {
                            res.text = calculation
                            return
                        }
                        if (res.text.toString() == "" && state == 1) {
                            res.text = calculation
                            return
                        }
                        if (state == 2 && calculation1 == "") {
                            return
                        }

                        op2 = calculation1.toInt()
                        when (cal) {
                            1 -> {
                                res.text = (op1 + op2).toString()
                                op1 += op2
                            }

                            2 -> {
                                res.text = (op1 - op2).toString()
                                op1 -= op2
                            }

                            3 -> {
                                res.text = (op1 * op2).toString()
                                op1 *= op2
                            }

                            4 -> {
                                if (op2 == 0) {
                                    res.text = "Syntax error"
                                    return
                                }
                                res.text = (op1.toDouble() / op2).toString()
                                op1 /= op2
                            }
                        }
                        state = 1
                        state1 = 1
                        calculation = ""
                        calculation1 = ""
                    }

                    c.id -> {
                        if (state == 1) {
                            calculation = ""
                            calculation1 = ""
                            res.text = calculation
                        }
                        if (state == 2) {
                            calculation = calculation2
                            calculation1 = ""
                            res.text = calculation
                        }
                    }

                    ce.id -> {
                        calculation = ""
                        calculation1 = ""
                        calculation2 = ""
                        state1 = 0
                        state = 1
                        op1 = 0
                        res.text = calculation
                    }

                    back.id -> {
                        if (state == 1) {
                            if (calculation == "") {
                                res.text = calculation
                                return
                            } else if (res.text.toString() == "") {
                                res.text = calculation
                                return
                            } else {
                                calculation = calculation.substring(0, calculation.length - 1)
                                calculation1 = calculation1.substring(0, calculation1.length - 1)
                                res.text = calculation
                            }
                        } else if (state == 2) {
                            if (calculation1 == "") {
                                state = 1
                                calculation = calculation.substring(0, calculation.length - 1)
                                calculation1 = calculation
                                res.text = calculation
                            } else {
                                calculation = calculation.substring(0, calculation.length - 1)
                                calculation1 = calculation1.substring(0, calculation1.length - 1)
                                res.text = calculation
                            }
                        }
                    }
                }
            }
        }
        ce.setOnClickListener { onClick(it) }
        back.setOnClickListener { onClick(it) }
        mul.setOnClickListener { onClick(it) }
        div.setOnClickListener { onClick(it) }
        num0.setOnClickListener { onClick(it) }
        num1.setOnClickListener { onClick(it) }
        num2.setOnClickListener { onClick(it) }
        num3.setOnClickListener { onClick(it) }
        num4.setOnClickListener { onClick(it) }
        num5.setOnClickListener { onClick(it) }
        num6.setOnClickListener { onClick(it) }
        num7.setOnClickListener { onClick(it) }
        num8.setOnClickListener { onClick(it) }
        num9.setOnClickListener { onClick(it) }
        add.setOnClickListener { onClick(it) }
        equal.setOnClickListener { onClick(it) }
        sub.setOnClickListener { onClick(it) }
        c.setOnClickListener { onClick(it) }
        oppo.setOnClickListener { onClick(it) }
    }
}