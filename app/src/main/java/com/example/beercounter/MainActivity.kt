package com.example.beercounter

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.beercounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var i = 1
        bindingClass.imageButton.setOnClickListener {
            bindingClass.textView.text = i++.toString()
            Toast.makeText(this,"Another beer!", Toast.LENGTH_SHORT).show()
            if ( bindingClass.textView.text == "5") {
                bindingClass.textView.setTextColor(getColor(R.color.yellow))
                bindingClass.textView.textSize += 1F
            } else if (bindingClass.textView.text == "10") {
                bindingClass.textView.textSize += 1F
                bindingClass.textView.setTextColor(getColor(R.color.red))
            }
        }
    }
}