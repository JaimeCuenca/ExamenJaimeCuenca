package com.example.examenjaimecuenca

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity(){
    companion object {
        const val VAR1 = ""
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        val tV = findViewById<TextView>(R.id.textView1)
        val eT2 = findViewById<EditText>(R.id.eT2)
        val bDT = findViewById<Button>(R.id.bDT)
        val bOT = findViewById<Button>(R.id.bOT)
        val bFT = findViewById<Button>(R.id.bFT)

        var mostrar =intent.getStringExtra(VAR1)?.split(' ')
        if (mostrar != null) {
            for (i in mostrar){
                tV.text= tV.text.toString() + "\n" +i
            }
        }

        eT2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                s?.let {
                    if(it.isNotEmpty()) {
                        var numero : String = eT2.text.toString()
                        if(numero.toInt() < 0){
                            eT2.text.clear()
                        }
                    }
                }
            }

        })

        bDT.setOnClickListener(){
            if (mostrar != null) {
                tV.text=""
                for (i in mostrar){
                    tV.text= tV.text.toString() + "\n" +i+" " +i.length
                }
            }
        }

        bOT.setOnClickListener(){
            if (mostrar != null) {
                var listaTam : ArrayList<Int> = ArrayList()
                for (i in mostrar){
                   listaTam.add(i.length)
                }
                listaTam.sort()
                var anterior=0
                tV.text=""
                for(i in listaTam) {
                    for (j in mostrar){
                        if (j.length == i) {
                            if(i!=anterior)
                                tV.text = tV.text.toString() + "\n" +j
                        }
                    }
                    anterior = i
                }
            }
        }

        bFT.setOnClickListener(){
            if (mostrar != null){
                tV.text=""
                var num =2
                if(eT2.text.isNotEmpty())
                    num = eT2.text.toString().toInt()
                for(j in mostrar){
                    if(j.length>num){
                        tV.text = tV.text.toString() + "\n" +j
                    }
                }
            }
        }
    }
}