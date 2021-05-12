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
import com.android.triviaapp.ui.questionaire.presenters.GetNamePresenter
import kotlinx.android.synthetic.main.fragment_get_name.*
import java.text.SimpleDateFormat
import java.util.*

class GetNameFragment : BaseFragment<GetNamePresenter>(), GetNameView {

    companion object {
        fun newInstance(): GetNameFragment {
            val args = Bundle()
            val fragment = GetNameFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_get_name, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewCreated()
    }

    override fun initViews() {
        val gameDetails = GameDetails()
        tvNext.setOnClickListener {
            val name = etName.text.toString().trim()
            if (name.isEmpty()) {
                Toast.makeText(
                    requireActivity(),
                    getString(R.string.enter_valid_input),
                    Toast.LENGTH_LONG
                ).show()
            } else {
                gameDetails.name = name
                val sdf = SimpleDateFormat("dd MMM hh:mm aaa", Locale.getDefault())
                gameDetails.attendDate = sdf.format(System.currentTimeMillis())
                (requireActivity() as GameActivity)
                    .startFragment(Question1Fragment.newInstance(gameDetails))
            }
        }
    }

    override fun getNewPresenter(): GetNamePresenter {
        return GetNamePresenter()
    }
}