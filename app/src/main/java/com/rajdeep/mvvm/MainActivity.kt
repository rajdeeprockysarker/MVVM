package com.rajdeep.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.atos.mobilehealthcareagent.database.AppDatabase
import com.atos.mobilehealthcareagent.database.Goal
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val model: UserData by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Create the observer which updates the UI.
        val nameObserver = Observer<ArrayList<UserModel>> { mListUserModel ->
            // Update the UI, in this case, a TextView.
           // nameTextView.text = newName
            Log.e("Value Change","mUserModel.name")
//            textView.text=mUserModel.name
        }

        val goalObserver=Observer<List<Goal>> { mListUserModel ->
            // Update the UI, in this case, a TextView.
            // nameTextView.text = newName
            Log.e("Value Change","mUserModel.name")
//            textView.text=mUserModel.name
        }

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        model.name.observe(this, nameObserver)
        model.goal.observe(this, goalObserver)


        button.setOnClickListener{
            model.addGoal()
        }





    }
}
