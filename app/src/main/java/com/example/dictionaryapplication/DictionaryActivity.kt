package com.example.dictionaryapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dictionaryapplication.databinding.ActivityDictionaryBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DictionaryActivity : AppCompatActivity(),
    androidx.appcompat.widget.SearchView.OnQueryTextListener {

    private lateinit var binding: ActivityDictionaryBinding
    private lateinit var adapter: WordsAdapter
    private lateinit var wordsInterface: WordsDataInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDictionaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        wordsInterface = ApiUtils.getWordsDataInterface()

        allWordst()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)

        val item = menu?.findItem(R.id.action_search)
        val searchView = item?.actionView as androidx.appcompat.widget.SearchView
        searchView.setOnQueryTextListener(this)


        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(p0: String?): Boolean {
        Log.e("sending", p0!!)
        return true
    }

    override fun onQueryTextChange(p0: String?): Boolean {
        Log.e("Alphabet", p0!!)
        return true
    }

    fun allWordst() {

        wordsInterface.allWords().enqueue(object : Callback<WordsAnswer> {

            override fun onResponse(call: Call<WordsAnswer>, response: Response<WordsAnswer>) {

                val list = response.body()?.kelimeler

                adapter = WordsAdapter(this@DictionaryActivity, list!!)

                binding.recyclerView.adapter = adapter
            }

            override fun onFailure(call: Call<WordsAnswer>, t: Throwable) {

            }
        })
    }
}