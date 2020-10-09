package com.simplx.apps.courotineapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.simplx.apps.courotineapp.pojo.User

class UsersViewModel : ViewModel() {

    private val userId: MutableLiveData<String> = MutableLiveData()

    val user: LiveData<User> = Transformations
        .switchMap(userId) {
            MyRepository.getUsers(it)
        }

    fun setUserId(user_id: String) {
        if (userId.value == user_id) {
            return
        } else {
            userId.value = user_id
        }
    }

    fun cancelJobs() {
        MyRepository.cancelJob()
    }
}
