package com.shrutipandit.alarmsk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shrutipandit.alarmsk.databinding.ActivityBalanceBinding

class BalanceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBalanceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBalanceBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}