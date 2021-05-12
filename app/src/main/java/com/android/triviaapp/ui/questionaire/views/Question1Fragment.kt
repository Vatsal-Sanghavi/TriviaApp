package com.android.triviaapp.ui.questionaire.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.android.triviaapp.R
import com.android.triviaapp.models.GameDetails
import com.android.triviaapp.ui.base.BaseFragment
import com.android.triviaapp.ui.game.views.GameActivity
import com.android.triviaapp.ui.history.views.HistoryActivity
import com.android.triviaapp.ui.questionaire.presenters.GetNamePresenter
import com.android.triviaapp.utils.EXTRA_GAME
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.fragment_question_1.*

class Question1Fragment : BaseFragment<GetNamePresenter>(), GetNameView {

    companion object {
        fun newInstance(gameDetails: GameDetails): Question1Fragment {
            val args = Bundle()
            args.putParcelable(EXTRA_GAME, gameDetails)
            val fragment = Question1Fragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_question_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewCreated()
    }

    override fun initViews() {
        val gameDetails = requireArguments().getParcelable<GameDetails>(EXTRA_GAME)!!
        tvNext.setOnClickListener {
            if (chipGroup.checkedChipId == View.NO_ID) {
                Toast.makeText(
                    requireActivity(),
                    getString(R.string.enter_valid_input),
                    Toast.LENGTH_LONG
                ).show()
            } else {
                gameDetails.question1 = getString(R.string.question_1)
                gameDetails.answer1 =
                    chipGroup.findViewById<Chip>(chipGroup.checkedChipId).text.toString()
                (requireActivity() as GameActivity).startFragment(Question2Fragment.newInstance(gameDetails))
            }
        }
    }

    override fun getNewPresenter(): GetNamePresenter {
        return GetNamePresenter()
    }
}