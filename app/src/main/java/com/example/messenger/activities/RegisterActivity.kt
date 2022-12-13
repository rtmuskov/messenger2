package com.example.messenger.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.messenger.databinding.ActivityMainBinding
import com.example.messenger.databinding.ActivityRegisterBinding
import com.mikepenz.materialdrawer.Drawer

class RegisterActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }
}