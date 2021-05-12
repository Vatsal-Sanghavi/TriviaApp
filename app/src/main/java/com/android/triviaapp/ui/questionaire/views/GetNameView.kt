package com.android.triviaapp.ui.questionaire.views

import com.android.triviaapp.ui.base.MVPBaseView
import com.android.triviaapp.ui.questionaire.presenters.GetNamePresenter

interface GetNameView : MVPBaseView<GetNamePresenter> {
    fun initViews()
}