package com.example.mydodo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mydodo.data.Pizzas
import com.example.mydodo.templates.PizzaItem

class MainActivity : AppCompatActivity(), ItemAdapter.OnItemClickListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private lateinit var adapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        searchView = findViewById(R.id.searchView)

        val pizzas = Pizzas()
        val items = pizzas.getPizzasInfo();
        adapter = ItemAdapter(items, this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter


        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                adapter.filter.filter(newText)
                return true
            }
        })
    }

    override fun onItemClick(item: PizzaItem) {
        val intent = Intent(this, DetailActivity::class.java)
        val imageResource = item.image
        intent.putExtra("EXTRA_TITLE", item.title)
        intent.putExtra("EXTRA_DESCR", item.description)
        intent.putExtra("EXTRA_IMAGE", imageResource)
        intent.putExtra("EXTRA_PRICE", item.price.toString())
        startActivity(intent)
    }


}