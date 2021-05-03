package com.example.boilerplate.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.boilerplate.R
import com.example.boilerplate.presentation.ui.itemList.ItemListFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

private const val TAG = "MainActivity Debug"

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var app: BaseApplication

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, ItemListFragment())
            .commit()
    }
}