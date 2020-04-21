package com.demoapp.login.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.demoapp.R
import com.demoapp.login.model.UserModel
import com.demoapp.utils.SingleLiveEvent
import com.demoapp.utils.isValidLogin
import com.mindorks.framework.mvvm.data.repository.MainRepository


class LoginViewModel() : ViewModel() {


    var userModel = UserModel("", "")
    var userModelField: MutableLiveData<UserModel> = MutableLiveData<UserModel>()

    fun afterPasswordTextChanged(editableTexts: CharSequence) {
        userModel.password = editableTexts.toString()
    }

    fun afterEmailTextChanged(editableTexts: CharSequence) {
        userModel.userName = editableTexts.toString()
    }

    fun getLogin(): MutableLiveData<UserModel> {
        return userModelField
    }

    internal val toastMessage = MutableLiveData<Int>()

    fun testToast()  {
        toastMessage.value = R.string.app_name
    }


    fun onLoginClicked(): MutableLiveData<UserModel> {
        when {
            isValidLogin(userModel) -> {
                userModelField.setValue(userModel)
                toastMessage.value = R.string.login_success
                return userModelField
            }
            else ->{
                toastMessage.value = R.string.email_password_required
            }
        }
        return MutableLiveData<UserModel>()
    }

}