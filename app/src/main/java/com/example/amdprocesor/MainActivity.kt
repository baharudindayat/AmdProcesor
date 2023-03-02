package com.example.amdprocesor

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.amdprocesor.adapter.ListProcAdapter
import com.example.amdprocesor.model.Model

class MainActivity : AppCompatActivity() {
    private lateinit var rvHeroes: RecyclerView
    private val list = ArrayList<Model>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHeroes = findViewById(R.id.rv_heroes)
        rvHeroes.setHasFixedSize(true)

        list.addAll(getProcesorList())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                val about = Intent(this, About::class.java)
                startActivity(about)
            }

        }
        return super.onOptionsItemSelected(item)
    }

    private fun getProcesorList(): ArrayList<Model> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataSpecs = resources.getStringArray(R.array.core)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.photo)
        val listHero = ArrayList<Model>()
        for (i in dataName.indices) {
            val hero = Model(dataName[i],dataSpecs[i] ,dataDescription[i], dataPhoto[i])
            listHero.add(hero)
        }
        return listHero
    }

    private fun showRecyclerList() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListProcAdapter(list)
        rvHeroes.adapter = listHeroAdapter
    }


}