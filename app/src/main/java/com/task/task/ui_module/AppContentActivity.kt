package com.task.task.ui_module
import android.os.Bundle
import com.task.task.R
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity

class AppContentActivity : DaggerAppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_content)
    }

}


