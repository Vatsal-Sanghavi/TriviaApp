package com.android.triviaapp

import android.app.Application
import com.android.triviaapp.models.DaoMaster
import com.android.triviaapp.models.DaoMaster.DevOpenHelper
import com.android.triviaapp.models.DaoSession
import com.android.triviaapp.utils.DB_NAME

class MyApp : Application() {
    var daoSession: DaoSession? = null
        private set

    override fun onCreate() {
        super.onCreate()
        daoSession = DaoMaster(
            DevOpenHelper(this, DB_NAME).writableDb
        ).newSession()
    }
}