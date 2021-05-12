package com.android.triviaapp.ui.game.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.android.triviaapp.MyApp
import com.android.triviaapp.R
import com.android.triviaapp.ui.base.BaseActivity
import com.android.triviaapp.ui.game.presenters.GamePresenter
import com.android.triviaapp.ui.questionaire.views.GetNameFragment


class GameActivity : BaseActivity<GamePresenter>(), GameView {

    companion object {
        fun start(context: AppCompatActivity) {
            val intent = Intent(context, GameActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        presenter.onActivityCreated()
    }

    override fun initViews() {
        // Load game steps
        startFragment(GetNameFragment.newInstance())
    }

    override fun getNewPresenter(): GamePresenter {
        // Pass daoSession instance to fetch game history
        return GamePresenter((application as MyApp).daoSession!!)
    }

    private fun showAlert() {
        val alertDialog: AlertDialog = AlertDialog.Builder(this).create()
        alertDialog.setTitle(getString(R.string.quit_game))
        alertDialog.setMessage(getString(R.string.quit_game_descr))
        alertDialog.setButton(
            AlertDialog.BUTTON_NEUTRAL,
            getString(R.string.ok)
        ) { dialog, which ->
            super.onBackPressed()
            dialog.dismiss()
        }
        alertDialog.show()
    }

    override fun onBackPressed() {
        // Take confirmation for quiting app
        showAlert()
    }
}
