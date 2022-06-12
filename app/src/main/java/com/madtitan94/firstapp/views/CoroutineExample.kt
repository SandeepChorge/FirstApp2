package com.madtitan94.firstapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.madtitan94.firstapp.ExampleSingleton
import com.madtitan94.firstapp.R
import com.madtitan94.firstapp.databinding.ActivityCoroutineExampleBinding
import com.madtitan94.firstapp.viewmodel.CoroutineViewModel

class CoroutineExample : AppCompatActivity() {

    lateinit var binding: ActivityCoroutineExampleBinding
    lateinit var viewModel: CoroutineViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_coroutine_example)
        title = "Coroutine API Example"

        viewModel = ViewModelProvider(this).get(CoroutineViewModel::class.java)

        viewModel.user.observe(this,Observer{
            user -> println("DEBUG : ${user}")
            Glide.with(this).load(user.image).into(binding.image);
        })
        viewModel.setUserId("1")
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.cancelJobs()
    }
}