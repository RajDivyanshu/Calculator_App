package com.kotlinninja.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import com.kotlinninja.mycalculator.databinding.ActivityMainBinding
import java.lang.StringBuilder
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var check=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) //providing a direct reference for the root view of the corresponding layout file
        //Pass the root view to setContentView() to make it the active view on the screen.

        binding.txtInput.movementMethod= ScrollingMovementMethod()
        binding.txtInput.isActivated = true
        binding.txtInput.isPressed= true

        var text:String



        //Input Numbers
        binding.btn1.setOnClickListener {
            text= binding.txtInput.text.toString()+"1"
            binding.txtInput.setText(text)
            result(text)
        }

        binding.btn2.setOnClickListener {
            text= binding.txtInput.text.toString()+"2"
            binding.txtInput.setText(text)
            result(text)
        }
        binding.btn3.setOnClickListener {
            text= binding.txtInput.text.toString()+"3"
            binding.txtInput.setText(text)
            result(text)
        }
        binding.btn4.setOnClickListener {
            text= binding.txtInput.text.toString()+"4"
            binding.txtInput.setText(text)
            result(text)
        }
        binding.btn5.setOnClickListener {
            text= binding.txtInput.text.toString()+"5"
            binding.txtInput.setText(text)
            result(text)
        }
        binding.btn6.setOnClickListener {
            text= binding.txtInput.text.toString()+"6"
            binding.txtInput.setText(text)
            result(text)
        }
        binding.btn7.setOnClickListener {
            text= binding.txtInput.text.toString()+"7"
            binding.txtInput.setText(text)
            result(text)
        }
        binding.btn8.setOnClickListener {
            text= binding.txtInput.text.toString()+"8"
            binding.txtInput.setText(text)
            result(text)
        }
        binding.btn9.setOnClickListener {
            text= binding.txtInput.text.toString()+"9"
            binding.txtInput.setText(text)
            result(text)
        }
        binding.btnDot.setOnClickListener {
            text= binding.txtInput.text.toString()+"."
            binding.txtInput.setText(text)
            result(text)
        }
        binding.btn0.setOnClickListener {
            text= binding.txtInput.text.toString()+"0"
            binding.txtInput.setText(text)
            result(text)
        }
        binding.btn00.setOnClickListener {
            text= binding.txtInput.text.toString()+"00"
            binding.txtInput.setText(text)
            result(text)
        }

        //Operators
         binding.btnAdd.setOnClickListener {
              text= binding.txtInput.text.toString()+"+"
             binding.txtInput.setText(text)
             check= check+1
         }
        binding.btnMinus.setOnClickListener {
            text= binding.txtInput.text.toString()+"-"
            binding.txtInput.setText(text)
            check= check+1
        }
        binding.btnMultiply.setOnClickListener {
            text= binding.txtInput.text.toString()+"*"
            binding.txtInput.setText(text)
            check= check+1
        }
        binding.btnDivide.setOnClickListener {
            text= binding.txtInput.text.toString()+"/"
            binding.txtInput.setText(text)
            check= check+1
        }
        binding.btnPercent.setOnClickListener {
            text= binding.txtInput.text.toString()+"%"
            binding.txtInput.setText(text)
            check= check+1
        }
        binding.btnEqual.setOnClickListener {
            text= binding.txtResult.text.toString()
            binding.txtInput.setText(text)
            binding.txtResult.setText(null)
        }
        binding.btnClear.setOnClickListener {
            binding.txtInput.setText(null)
            binding.txtResult.setText(null)
        }
        binding.btnBackSpace.setOnClickListener {
            var backSpace:String?= null
            if (binding.txtInput.text.isNotEmpty()){

                val stringBuilder= StringBuilder(binding.txtInput.text)
                val find= binding.txtInput.text.toString()
                val find2= find.last()

                if(find2.equals('+')||find2.equals('-')||find2.equals('*')||find2.equals('/')||find2.equals('%')){
                    check= check-1
                }

                stringBuilder.deleteCharAt(binding.txtInput.text.length - 1)
                backSpace= stringBuilder.toString()
                binding.txtInput.setText(backSpace)

                result(backSpace)

            }

        }



    }

    private fun result(text: String) {

        val engine:ScriptEngine=ScriptEngineManager().getEngineByName("rhino")
        try {
            val result:Any= engine.eval(text)
            var mainr= result.toString()
            if (check==0){
                binding.txtResult.setText(null)
            } else{
                binding.txtResult.setText(mainr)
            }
        } catch (e:ScriptException){
            Log.d("TAG", "ERROR")
        }
    }
}