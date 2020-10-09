package com.simplx.apps.courotineapp.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.simplx.apps.courotineapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: UsersViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(UsersViewModel::class.java)
        viewModel.setUserId("1")
        viewModel.user.observe(this, Observer {

            txtView.text = "$it.username  $it.email"
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.cancelJobs()
    }
}