package com.example.dictionaryapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class WordsAdapter(private val context: Context, val wordsList: List<Words>) :
    RecyclerView.Adapter<WordsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var wordCard: CardView = view.findViewById(R.id.wordCard)
        var englishText: TextView = view.findViewById(R.id.englishText)
        var turkishText: TextView = view.findViewById(R.id.turkishText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_design, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val word = wordsList[position]
        holder.englishText.text = word.ingilizce
        holder.turkishText.text = word.turkce

        holder.wordCard.setOnClickListener {

            val intent = Intent(context, DetailActivity::class.java)

            intent.putExtra("object", word)

            context.startActivity(intent)

        }
    }

    override fun getItemCount() = wordsList.size

}
