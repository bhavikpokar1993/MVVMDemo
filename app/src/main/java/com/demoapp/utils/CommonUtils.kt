package com.demoapp.utils

import android.content.Context
import android.content.Intent
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import com.demoapp.login.model.UserModel
import java.util.regex.Pattern


const val TAG = "log_tag"

fun isValidLogin(userModel: UserModel): Boolean {
    when {
        (!TextUtils.isEmpty(userModel.userName) && (Patterns.EMAIL_ADDRESS.matcher(userModel.userName)
            .matches()) && (!userModel.userName.equals("email", true)) &&
                (!TextUtils.isEmpty(userModel.password)) &&
                (!userModel.password.equals(
                    "password",
                    true
                )) && userModel.password.length >= 6) -> {
            return true
        }
        else -> {
            return false
        }
    }
}


/*
* Start Activity from Activity
* */
inline fun <reified T : Any> Context.launchActivity(
    noinline init: Intent.() -> Unit = {}
) {
    val intent: Intent = newIntent<T>(this)
    intent.init()
    startActivity(intent)
}

inline fun <reified T : Any> newIntent(context: Context): Intent =
    Intent(context, T::class.java)


fun Context.showToast(message: String?, duration: Int = Toast.LENGTH_SHORT) {
    if (!message.isNullOrEmpty())
        Toast.makeText(this, message, duration).show()
}