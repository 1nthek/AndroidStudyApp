package com.example.androidstudyapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidstudyapp.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            //액티비티 종료
            finish()
        }
//        setContentView(R.layout.activity_second);
    }

}