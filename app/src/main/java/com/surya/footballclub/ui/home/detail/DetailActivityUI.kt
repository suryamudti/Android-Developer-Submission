package com.surya.footballclub.ui.home.detail

import android.graphics.Typeface
import android.view.Gravity
import com.bumptech.glide.Glide
import com.surya.footballclub.R
import com.surya.footballclub.data.model.DataItem
import org.jetbrains.anko.*

class DetailActivityUI(val item: DataItem) : AnkoComponent<DetailActivity> {
    val id_image = 2
    val id_name = 3

    override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {
        relativeLayout {
            lparams(wrapContent, wrapContent)

            verticalLayout{
                gravity = Gravity.CENTER

                imageView {

                    setImageResource(R.drawable.soccer)
                }.lparams (matchParent, wrapContent)


            }.lparams(matchParent, dip(132))

            imageView {
                id = id_image
                Glide.with(this)
                        .load(item.image)
                        .into(this)
            }.lparams(dip(100), dip(100)) {
                centerHorizontally()
                topMargin = dip(80)
            }

            textView {
                id = id_name
                text = item.name
                textSize = 24f
                setTypeface(null, Typeface.BOLD)
            }.lparams {
                below(id_image)
                centerHorizontally()
            }

            textView {
                padding = dip(16)
                text = item.description
            }.lparams {
                below(id_name)
            }
        }
    }
}