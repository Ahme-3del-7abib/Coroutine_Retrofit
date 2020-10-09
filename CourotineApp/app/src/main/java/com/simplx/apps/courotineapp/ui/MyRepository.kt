package com.simplx.apps.courotineapp.ui

import androidx.lifecycle.LiveData
import com.simplx.apps.courotineapp.api.RetrofitBuilder
import com.simplx.apps.courotineapp.pojo.User
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

object MyRepository {

    var job: CompletableJob? = null

    fun getUsers(userId: String): LiveData<User> {

        job = Job()

        return object : LiveData<User>() {
            override fun onActive() {
                super.onActive()

                job?.let { my_Job ->
                    CoroutineScope(IO + my_Job).launch {
                        val user = RetrofitBuilder.apiService.getUsers(userId)
                        withContext(Main) {
                            value = user
                            my_Job.complete()
                        }
                    }
                }
            }
        }
    }

    fun cancelJob() {
        job?.cancel()
    }

}