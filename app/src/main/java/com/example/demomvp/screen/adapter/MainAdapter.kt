package com.example.demomvp.screen.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demomvp.R
import com.example.demomvp.data.model.Cocktail
import com.example.demomvp.extentions.loadFromUrl
import kotlinx.android.synthetic.main.item_layout_cocktail.view.*

class MainAdapter(private var onItemClickListener: (Cocktail) -> Unit) :
    RecyclerView.Adapter<MainAdapter.ViewHolder?>() {

    private val mCocktails = mutableListOf<Cocktail>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout_cocktail, parent, false)
        return ViewHolder(view, onItemClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViewData(mCocktails[position])
    }

    override fun getItemCount() = mCocktails.size

    fun updateData(cocktails: MutableList<Cocktail>?) {
        cocktails?.let {
            mCocktails.clear()
            mCocktails.addAll(cocktails)
            notifyDataSetChanged()
        }
    }

    inner class ViewHolder(itemView: View, private var itemListener: (Cocktail) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        fun bindViewData(cocktail: Cocktail) {
            itemView.apply {
                cocktail.run{
                    textViewTitle.text = title
                    imageCocktail.loadFromUrl(urlImage)
                    setOnClickListener {
                        cocktail.let(itemListener)
                    }
                }
            }
        }
    }
}
