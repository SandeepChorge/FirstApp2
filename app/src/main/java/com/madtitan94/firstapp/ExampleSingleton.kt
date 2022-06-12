package com.madtitan94.firstapp

import com.madtitan94.firstapp.models.User

object ExampleSingleton {

    val singletonUser : User by lazy {
        User("sandeep@gmail.com","sandeep","someimage.png")
    }
}