package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class CalculatorActivity : AppCompatActivity() {
    lateinit var one: TextView
    lateinit var two: TextView
    lateinit var three: TextView
    lateinit var four: TextView
    lateinit var five: TextView
    lateinit var six: TextView
    lateinit var seven: TextView
    lateinit var eight: TextView
    lateinit var nine: TextView
    lateinit var zero: TextView
    lateinit var point: TextView
    lateinit var equal: TextView
    lateinit var modulo: TextView
    lateinit var divide: TextView
    lateinit var bsp: ImageView
    lateinit var subs: TextView
    lateinit var add: TextView
    lateinit var ac: TextView
    lateinit var changesign: TextView
    lateinit var expr: TextView
    lateinit var result: TextView
    lateinit var multiple: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        one=findViewById(R.id.one)
        two=findViewById(R.id.two)
        three=findViewById(R.id.three)
        four=findViewById(R.id.four)
        five=findViewById(R.id.five)
        six=findViewById(R.id.six)
        seven=findViewById(R.id.seven)
        eight=findViewById(R.id.eight)
        nine=findViewById(R.id.nine)
        zero=findViewById(R.id.zero)
        add=findViewById(R.id.add)
        subs=findViewById(R.id.subs)
        bsp=findViewById(R.id.bsp)
        ac=findViewById(R.id.ac)
        point=findViewById(R.id.point)
        modulo=findViewById(R.id.modulo)
        subs=findViewById(R.id.subs)
        equal=findViewById(R.id.equal)
        divide=findViewById(R.id.divide)
        expr=findViewById(R.id.expr)
        changesign=findViewById(R.id.changesign)
        result=findViewById(R.id.result)
        multiple=findViewById(R.id.multiple)

        one.setOnClickListener {
            appendText("1", true)
        }
        two.setOnClickListener {
            appendText("2", true)
        }
        three.setOnClickListener {
            appendText("3", true)
        }
        four.setOnClickListener {
            appendText("4", true)
        }
        five.setOnClickListener {
            appendText("5", true)
        }
        six.setOnClickListener {
            appendText("6", true)
        }
        seven.setOnClickListener {
            appendText("7", true)
        }
        eight.setOnClickListener {
            appendText("8", true)
        }
        nine.setOnClickListener {
            appendText("9", true)
        }
        zero.setOnClickListener {
            appendText("0", true)
        }
        divide.setOnClickListener {
            appendText("/", false)
        }
        multiple.setOnClickListener {
            appendText("*", false)
        }
        modulo.setOnClickListener {
            appendText("%", false)
        }
        point.setOnClickListener {
            appendText(".", true)
        }
        subs.setOnClickListener {
            appendText("-", false)
        }
        add.setOnClickListener {
            appendText("+", false)
        }
        equal.setOnClickListener {
            try{
                val exppr=ExpressionBuilder(expr.text.toString()).build()
                val answer=exppr.evaluate()
                result.text=answer.toString()
            } catch (e: Exception){
                result.text=e.message
            }
        }

        bsp.setOnClickListener{
            result.text=""
            result.hint=""
            val value=expr.text
            if(value.isNotEmpty()){
                expr.text=value.substring(0, value.length-1)
                result.text=value.substring(0, value.length-1)

            }
        }
        ac.setOnClickListener {
            expr.text=""
            result.text=""
            result.hint=""
        }
        changesign.setOnClickListener {
            result.text = ""
            result.hint = ""
            if (expr.text.isNotEmpty() && expr.text[0] == '-') {
                expr.text = expr.text.substring(1)
            } else {
                expr.text = "-${expr.text}"
            }
        }


    }

        private fun appendText(value: String, toBeCleared: Boolean){
            if(result.text!=""){
                expr.text=""
            }

            if(toBeCleared){
                 result.text=""
                expr.append(value)
            }
            else{
                expr.append(result.text)
                expr.append(value)
                result.text=""
            }

            result.hint=expr.text

        }
}