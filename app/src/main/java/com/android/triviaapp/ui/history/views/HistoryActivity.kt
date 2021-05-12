package com.android.triviaapp.ui.history.views

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.triviaapp.MyApp
import com.android.triviaapp.R
import com.android.triviaapp.models.GameDetails
import com.android.triviaapp.ui.base.BaseActivity
import com.android.triviaapp.ui.game.views.GameActivity
import com.android.triviaapp.ui.history.adapters.HistoryAdapter
import com.android.triviaapp.ui.history.presenters.HistoryPresenter
import kotlinx.android.synthetic.main.activity_history.*
import java.util.*


class HistoryActivity : BaseActivity<HistoryPresenter>(), HistoryView {

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, HistoryActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        title = getString(R.string.game_history)
        presenter.onActivityCreated()
    }

    override fun initViews(arrayList: ArrayList<GameDetails>) {
        // Setup recycler view
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = HistoryAdapter(arrayList,
            fun(pos: Int) {
                // Handle item click
            })
        recyclerView.adapter = adapter
    }

    override fun getNewPresenter(): HistoryPresenter {
        // Pass daoSession instance to fetch game history
        return HistoryPresenter((application as MyApp).daoSession!!)
    }
}
