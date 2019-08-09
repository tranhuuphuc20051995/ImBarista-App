package com.alexzh.imbarista.domain.repository

import com.alexzh.imbarista.domain.model.CoffeeDrink
import io.reactivex.Completable
import io.reactivex.Single

interface CoffeeDrinksRepository {

    fun getCoffeeDrinks(): Single<List<CoffeeDrink>>

    fun getCoffeeDrinksByName(name: String): Single<List<CoffeeDrink>>

    fun getCoffeeDrinkById(id: Long): Single<CoffeeDrink>

    fun addCoffeeDrinkToFavourites(coffeeId: Long): Completable

    fun removeCoffeeDrinkFromFavourites(coffeeId: Long): Completable
}