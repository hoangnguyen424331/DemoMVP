package com.example.demomvp.screen

import com.example.demomvp.data.model.Cocktail
import com.example.demomvp.data.source.CocktailRepository
import com.example.demomvp.data.source.remote.OnFetchDataJsonListener
import java.lang.Exception

class MainPresenter(private val repository: CocktailRepository?) :
    MainContract.Presenter {

    private var view: MainContract.View? = null

    override fun onStart() {
        getCocktails()
    }

    override fun onStop() {

    }

    override fun setView(view: MainContract.View?) {
        this.view = view
    }

    override fun getCocktails() {
        repository?.getCocktail(object : OnFetchDataJsonListener<MutableList<Cocktail>> {
            override fun onSuccess(data: MutableList<Cocktail>) {
                view?.onGetCocktailsSuccess(data)
            }

            override fun onError(exception: Exception?) {
                view?.onError(exception)
            }
        })
    }
}
