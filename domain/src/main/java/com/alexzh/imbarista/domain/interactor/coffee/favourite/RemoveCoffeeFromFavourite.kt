package com.alexzh.imbarista.domain.interactor.coffee.favourite

import com.alexzh.imbarista.domain.executor.PostExecutionThread
import com.alexzh.imbarista.domain.interactor.CompletableUseCase
import com.alexzh.imbarista.domain.repository.CoffeesRepository
import io.reactivex.Completable
import java.lang.IllegalArgumentException

class RemoveCoffeeFromFavourite constructor(
    private val coffeesRepository: CoffeesRepository,
    postExecutionThread: PostExecutionThread
) : CompletableUseCase<RemoveCoffeeFromFavourite.Param>(postExecutionThread) {

    override fun buildCompletableUseCase(param: Param?): Completable {
        if (param == null) throw IllegalArgumentException("Param can't be null")
        return coffeesRepository.removeCoffeeFromFavourites(param.coffeeId)
    }

    data class Param(val coffeeId: Long) {
        companion object {
            fun forCoffee(id: Long): Param {
                return Param(id)
            }
        }
    }
}