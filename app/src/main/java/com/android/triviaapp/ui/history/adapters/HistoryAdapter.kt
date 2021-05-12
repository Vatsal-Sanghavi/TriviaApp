package com.android.triviaapp.ui.history.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.triviaapp.R
import com.android.triviaapp.models.GameDetails
import kotlinx.android.synthetic.main.item_games.view.*
import java.util.*


class HistoryAdapter(
    var arrayList: ArrayList<GameDetails>,
    private val itemClickListener: (Int) -> Unit
) : RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_games,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(arrayList[position], itemClickListener)
    }

    fun setList(arrayList: ArrayList<GameDetails>) {
        this.arrayList = arrayList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(
            gameDetails: GameDetails,
            itemClickListener: (Int) -> Unit
        ) {
            itemView.tvGameNo.text =
                itemView.context.getString(R.string.game_d, adapterPosition + 1)
            itemView.tvGameDate.text = gameDetails.attendDate
            itemView.tvName.text = gameDetails.name
            itemView.tvQ1.text = gameDetails.question1
            itemView.tvA1.text = itemView.context.getString(R.string.answer, gameDetails.answer1)
            itemView.tvQ2.text = gameDetails.question2
            itemView.tvA2.text = itemView.context.getString(R.string.answer, gameDetails.answer2)
            itemView.setOnClickListener {
                itemClickListener(adapterPosition)
            }
        }
    }
}