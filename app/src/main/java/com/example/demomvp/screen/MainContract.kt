package com.example.demomvp.screen

import com.example.demomvp.data.model.Cocktail
import com.example.demomvp.utils.BasePresenter
import java.lang.Exception

interface MainContract {

    interface View {
        fun onGetCocktailsSuccess(cocktails: MutableList<Cocktail>)
        fun onError(exception: Exception?)
    }

    interface Presenter : BasePresenter<View> {
        fun getCocktails()
    }
}
