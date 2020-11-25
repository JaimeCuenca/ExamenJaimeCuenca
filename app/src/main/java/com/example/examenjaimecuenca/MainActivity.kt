package com.example.examenjaimecuenca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton = findViewById<Button>(R.id.Bnext)
        val eT = findViewById<EditText>(R.id.eT1)

        eT.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                s?.let {
                    if(it.isNotEmpty()) {
                        var espacios = it.split(' ')
                        boton.isEnabled = espacios.size >= 4
                    }
                }
            }
        })

        boton.setOnClickListener(){
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(SecondActivity.VAR1, eT.text.toString())
            startActivity(intent)
        }
    }
}