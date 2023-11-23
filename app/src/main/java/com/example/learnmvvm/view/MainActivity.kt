package com.example.learnmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewAnimationUtils
import androidx.lifecycle.ViewModelProvider
import com.example.learnmvvm.R
import com.example.learnmvvm.databinding.ActivityMainBinding
import com.example.learnmvvm.viewmodel.CalculatorViewModel

class   MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var calculatorViewModel: CalculatorViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        calculatorViewModel = ViewModelProvider(this).get(CalculatorViewModel::class.java)

        binding.calculateButton.setOnClickListener{
            val num1 = binding.editTextNum1.text.toString().toIntOrNull()?:0
            val num2 = binding.editTextNum2.text.toString().toIntOrNull()?:0

            val result = calculatorViewModel.calculateSum(num1,num2)
            binding.resutTextView.text="${result.sum}"
        }

    }
}