package com.surya.footballclub.ui.home

import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import com.surya.footballclub.data.model.DataItem
import com.surya.footballclub.ui.home.detail.DetailActivity
import com.surya.footballclub.util.Constants
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivityUI(val items: List<DataItem>) : AnkoComponent<MainActivity> {
    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        verticalLayout {
            lparams(matchParent, wrapContent)
            recyclerView {
                layoutManager = GridLayoutManager(context,2)
                addItemDecoration(DividerItemDecoration(context, 1))
                adapter = MainAdapter(items) {
                    startActivity<DetailActivity>(Constants.DATA_ITEM to it)
                }
            }
        }
    }
}