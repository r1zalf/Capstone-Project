package com.rizalfahrudin.moviecatalogue

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.rizalfahrudin.moviecatalogue.main.PagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.elevation = 0f

        view_pager.adapter =
            PagerAdapter(this)

        val title = intArrayOf(R.string.movie, R.string.tv)
        TabLayoutMediator(tabs, view_pager) { tabs, position ->
            tabs.text = resources.getString(title[position])
        }.attach()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_favorite) {
            moveToFavorite()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun moveToFavorite(){
        try {
            val intent = Class.forName("com.rizalfahrudin.moviecatalogue.favorite.FavoriteActivity")
            startActivity(Intent(this, intent))
        } catch (e: Exception){
            Toast.makeText(this, "Tidak dapat membuka module", Toast.LENGTH_LONG).show()
        }
    }
}