package com.surya.footballclub.ui.home

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.surya.footballclub.data.model.DataItem
import com.surya.footballclub.util.Constants
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.AnkoContext

class MainAdapter(val items: List<DataItem>, val listener: (DataItem) -> Unit) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(ItemUI().createView(AnkoContext.Companion.create(parent.context, parent)))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position], listener)

    inner class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        val image = itemView.findViewById<ImageView>(Constants.league_logo)
        val name = itemView.findViewById<TextView>(Constants.league_name)

        fun bind(item: DataItem, listener: (DataItem) -> Unit) {
            Glide.with(itemView.context)
                    .load(item.image)
                    .into(image)

            name.text = item.name

            itemView.setOnClickListener { listener(item) }
        }
    }
}