package com.madtitan94.firstapp.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.madtitan94.firstapp.R
import com.madtitan94.firstapp.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {

    lateinit var binding: ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_dashboard)

        binding.btn1.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

        binding.btn2.setOnClickListener {
            startActivity(Intent(this,CoroutineBasicActivity::class.java))
        }

        binding.btn3.setOnClickListener {
            startActivity(Intent(this,CoroutineExample::class.java))
        }
    }
}