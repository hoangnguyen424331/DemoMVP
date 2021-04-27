package com.example.demomvp.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.demomvp.R
import com.example.demomvp.data.model.Cocktail
import com.example.demomvp.data.source.CocktailRepository
import com.example.demomvp.screen.adapter.MainAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity(), MainContract.View {

    private val adapterCocktail by lazy {
        MainAdapter { }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initData()
    }

    override fun onGetCocktailsSuccess(cocktails: MutableList<Cocktail>) {
        adapterCocktail.updateData(cocktails)
    }

    override fun onError(exception: Exception?) {
        Toast.makeText(this, exception?.message, Toast.LENGTH_SHORT).show()
    }

    private fun initView() {
        recyclerViewCocktail.apply {
            setHasFixedSize(true)
            adapter = adapterCocktail
        }
    }

    private fun initData() {
        val presenter = MainPresenter(CocktailRepository.instance)
        presenter.apply {
            setView(this@MainActivity)
            onStart()
        }
    }
}

