package com.demoapp.login.view

import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.demoapp.R
import com.demoapp.databinding.ActivityMainBinding
import com.demoapp.login.model.UserModel
import com.demoapp.login.viewmodel.LoginViewModel
import com.demoapp.main.view.MainActivity
import com.demoapp.utils.launchActivity
import org.w3c.dom.Text

class LoginActivity : AppCompatActivity() {

    lateinit var loginViewModel: LoginViewModel

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initViewModel()

        binding.viewModel = loginViewModel

        buttonClick()

        loginError()
    }

    fun initViewModel() {
        loginViewModel = ViewModelProviders.of(
            this
        ).get(LoginViewModel::class.java)
    }

    fun loginError() {
        this.loginViewModel.toastMessage.observe(this, Observer { res ->
            if (res != null) {
                val message = getString(res)
                Toast.makeText(this@LoginActivity, message, Toast.LENGTH_LONG).show()
            }

        })
    }
    fun buttonClick() {
        this.loginViewModel.getLogin().observe(this, Observer<UserModel> { userModel ->
            if (!TextUtils.isEmpty(userModel.userName) && !TextUtils.isEmpty(userModel.password)) {
                Toast.makeText(
                    this@LoginActivity,
                    "Email " + userModel.userName
                        .toString() + ", Password " + userModel.password,
                    Toast.LENGTH_SHORT
                ).show()

                launchActivity<MainActivity>()
            }

        })
    }
}
