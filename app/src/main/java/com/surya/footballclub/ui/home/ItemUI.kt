package com.surya.footballclub.ui.home

import android.annotation.SuppressLint
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.surya.footballclub.util.Constants.Companion.league_logo
import com.surya.footballclub.util.Constants.Companion.league_name
import com.surya.footballclub.util.dp
import org.jetbrains.anko.*

class ItemUI : AnkoComponent<ViewGroup> {


    @SuppressLint("NewApi")
    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        verticalLayout {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            padding = dip(16)

            imageView {
                id = league_logo
            }.lparams(width = 50.dp, height = 50.dp)

            textView {
                gravity = Gravity.CENTER
                textAlignment = View.TEXT_ALIGNMENT_GRAVITY
                id = league_name
            }.lparams(wrapContent, wrapContent) {
                margin = dip(5)
            }
        }
    }
}