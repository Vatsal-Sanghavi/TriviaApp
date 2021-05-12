package com.android.triviaapp.ui.history.views

import com.android.triviaapp.models.GameDetails
import com.android.triviaapp.ui.base.MVPBaseView
import com.android.triviaapp.ui.history.presenters.HistoryPresenter
import java.util.ArrayList

interface HistoryView : MVPBaseView<HistoryPresenter> {
    fun initViews(arrayList: ArrayList<GameDetails>)
}