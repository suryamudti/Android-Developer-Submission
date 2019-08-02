package com.surya.footballclub.ui.home

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.surya.footballclub.data.model.DataItem
import com.surya.footballclub.R
import com.surya.footballclub.ui.home.about.AboutActivity
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {

    var itemList: MutableList<DataItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadDataFromResource()
        MainActivityUI(itemList).setContentView(this)
    }

    fun loadDataFromResource() {
        val nameList = resources.getStringArray(R.array.league_name)
        val imageList = resources.obtainTypedArray(R.array.league_logo)
        val descriptionList = resources.getStringArray(R.array.league_description)

        itemList.clear()
        for (i in nameList.indices)itemList.add(DataItem(imageList.getResourceId(i, 0), nameList[i], descriptionList[i]))
        imageList.recycle()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId

        if (id == R.id.about_button) {
            val intent = Intent(this,AboutActivity::class.java)
            startActivity(intent)
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
