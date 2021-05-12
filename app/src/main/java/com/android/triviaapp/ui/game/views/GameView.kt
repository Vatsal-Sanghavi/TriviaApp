package com.android.triviaapp.ui.game.views

import com.android.triviaapp.ui.base.MVPBaseView
import com.android.triviaapp.ui.game.presenters.GamePresenter
import com.android.triviaapp.ui.history.presenters.HistoryPresenter

interface GameView : MVPBaseView<GamePresenter> {
    fun initViews()
}