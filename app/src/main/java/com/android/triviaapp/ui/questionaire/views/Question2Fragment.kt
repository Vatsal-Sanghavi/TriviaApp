package com.android.triviaapp.ui.questionaire.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.android.triviaapp.MyApp
import com.android.triviaapp.R
import com.android.triviaapp.models.GameDetails
import com.android.triviaapp.ui.base.BaseFragment
import com.android.triviaapp.ui.game.views.GameActivity
import com.android.triviaapp.ui.questionaire.presenters.GetNamePresenter
import com.android.triviaapp.utils.EXTRA_GAME
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.fragment_question_2.*

class Question2Fragment : BaseFragment<GetNamePresenter>(), GetNameView {

    companion object {
        fun newInstance(gameDetails: GameDetails): Question2Fragment {
            val args = Bundle()
            args.putParcelable(EXTRA_GAME, gameDetails)
            val fragment = Question2Fragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_question_2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewCreated()
    }

    override fun initViews() {
        val gameDetails = requireArguments().getParcelable<GameDetails>(EXTRA_GAME)!!
        tvNext.setOnClickListener {
            if (chipGroup.checkedChipIds.isEmpty()) {
                Toast.makeText(
                    requireActivity(),
                    getString(R.string.enter_valid_input),
                    Toast.LENGTH_LONG
                ).show()
            } else {
                val colorList = ArrayList<String>()
                for (id in chipGroup.checkedChipIds) {
                    val chip = chipGroup.findViewById<Chip>(id)
                    colorList.add(chip.text.toString())
                }
                gameDetails.question2 = getString(R.string.question_2)
                gameDetails.answer2 = colorList.joinToString()
                saveGameDetails(gameDetails)
                (requireActivity() as GameActivity)
                    .startFragment(SummaryFragment.newInstance(gameDetails))
            }
        }
    }

    private fun saveGameDetails(gameDetails: GameDetails) {
        val daoSession = (requireActivity().application as MyApp).daoSession!!
        daoSession.gameDetailsDao.insert(gameDetails)
    }

    override fun getNewPresenter(): GetNamePresenter {
        return GetNamePresenter()
    }
}