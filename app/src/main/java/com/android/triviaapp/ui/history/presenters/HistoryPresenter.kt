package com.android.triviaapp.ui.history.presenters

import com.android.triviaapp.models.DaoSession
import com.android.triviaapp.ui.base.MVPBasePresenter
import com.android.triviaapp.ui.history.views.HistoryView

class HistoryPresenter(private val daoSession: DaoSession) : MVPBasePresenter<HistoryView>() {
    fun onActivityCreated() {
        val list = daoSession.gameDetailsDao.queryBuilder().list() as ArrayList
        view.initViews(list)
    }
}