package com.android.triviaapp.ui.questionaire.presenters

import com.android.triviaapp.ui.base.MVPBasePresenter
import com.android.triviaapp.ui.questionaire.views.GetNameView


class GetNamePresenter() : MVPBasePresenter<GetNameView>() {

    fun onViewCreated() {
        view.initViews()
    }

}
