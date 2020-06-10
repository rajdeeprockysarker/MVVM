package com.rajdeep.mvvm

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.atos.mobilehealthcareagent.database.AppDatabase
import com.atos.mobilehealthcareagent.database.Goal

class UserData(application: Application) : AndroidViewModel(application){

    val name: MutableLiveData<ArrayList<UserModel>> by lazy {
        MutableLiveData<ArrayList<UserModel>>()
    }

    val goal: MutableLiveData<List<Goal>> by lazy {
        MutableLiveData<List<Goal>>()
    }


    fun add(mUserModel:UserModel){

        if(name.value!=null) {
            var mUpdatedList: ArrayList<UserModel>? = name.value

            mUpdatedList?.add(mUserModel)
            name.value = mUpdatedList
        }
        else
        {
            val list = ArrayList<UserModel>()
            list.add(mUserModel)
            name.postValue(list)

        }

    }

    fun addGoal(){

        var db = AppDatabase.getAppDatabase(this.getApplication()) as AppDatabase
        var goal= Goal()
        goal.moveminute=123
        goal.steps=100

        db?.userDao()?.insertAllGoal(goal)

        this.goal.postValue(db?.userDao()?.allGoal as List<Goal>?)
    }

}