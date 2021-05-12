package com.android.triviaapp.ui.questionaire.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.android.triviaapp.R
import com.android.triviaapp.models.GameDetails
import com.android.triviaapp.ui.base.BaseFragment
import com.android.triviaapp.ui.history.views.HistoryActivity
import com.android.triviaapp.ui.questionaire.presenters.GetNamePresenter
import com.android.triviaapp.utils.EXTRA_GAME
import kotlinx.android.synthetic.main.fragment_summary.*
import kotlinx.android.synthetic.main.item_games.*

class SummaryFragment : BaseFragment<GetNamePresenter>(), GetNameView {

    companion object {
        fun newInstance(gameDetails: GameDetails): SummaryFragment {
            val args = Bundle()
            args.putParcelable(EXTRA_GAME, gameDetails)
            val fragment = SummaryFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_summary, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewCreated()
    }

    override fun initViews() {
        val gameDetails = requireArguments().getParcelable<GameDetails>(EXTRA_GAME)!!
        setData(gameDetails)
        tvHistory.setOnClickListener {
            HistoryActivity.start(requireActivity())
//            requireActivity().finish()
        }
        tvFinish.setOnClickListener {
            Toast.makeText(
                requireActivity(),
                getString(R.string.thanks),
                Toast.LENGTH_LONG
            ).show()
            requireActivity().finish()
        }
    }

    private fun setData(gameDetails: GameDetails) {
        tvHeader.text = getString(R.string.summery_header, gameDetails.name)
        tvGameNo.visibility = View.GONE
        tvGameDate.visibility = View.GONE
        tvName.text = gameDetails.name
        tvQ1.text = gameDetails.question1
        tvA1.text = getString(R.string.answer, gameDetails.answer1)
        tvQ2.text = gameDetails.question2
        tvA2.text = getString(R.string.answer, gameDetails.answer2)
    }

    override fun getNewPresenter(): GetNamePresenter {
        return GetNamePresenter()
    }
}