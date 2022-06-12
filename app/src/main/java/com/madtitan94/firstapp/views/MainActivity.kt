package com.madtitan94.firstapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.madtitan94.firstapp.R
import com.madtitan94.firstapp.viewmodel.MainActivityViewModel
import com.madtitan94.firstapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var  viewmodel : MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        title = "MVVM LiveData Example"

        viewmodel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding.model = viewmodel
        // you must set lifecycle owner, otherwise the contents on the UI does not change according to livedata
        binding.setLifecycleOwner(this)


      /*  //you can use this method as well to observe the changes done on mutable livedata
        viewmodel.currentNumber.observe(this, Observer {
            binding.label.text = it.toString()
        })*/

        binding.incrementButton.setOnClickListener {
            viewmodel.Increment()
        }
    }

    private fun updateText() {
        binding.label.text = viewmodel.currentNumber.toString();
    }
}