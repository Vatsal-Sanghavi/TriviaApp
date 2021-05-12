package com.android.triviaapp.ui.game.presenters

import com.android.triviaapp.models.DaoSession
import com.android.triviaapp.ui.base.MVPBasePresenter
import com.android.triviaapp.ui.game.views.GameView
import com.android.triviaapp.ui.history.views.HistoryView

class GamePresenter(daoSession: DaoSession) : MVPBasePresenter<GameView>() {
    fun onActivityCreated() {
        view.initViews()
    }
}