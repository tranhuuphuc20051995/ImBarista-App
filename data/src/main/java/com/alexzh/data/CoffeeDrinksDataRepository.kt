package com.alexzh.data

import com.alexzh.data.mapper.CoffeeMapper
import com.alexzh.data.repository.CoffeeDrinksCacheRepository
import com.alexzh.data.repository.PreferencesRepository
import com.alexzh.data.store.CoffeeDrinksDataStoreFactory
import com.alexzh.imbarista.domain.model.CoffeeDrink
import com.alexzh.imbarista.domain.repository.CoffeeDrinksRepository
import io.reactivex.Completable
import io.reactivex.Single
import java.lang.UnsupportedOperationException

class CoffeeDrinksDataRepository(
    private val mapper: CoffeeMapper,
    private val cacheRepository: CoffeeDrinksCacheRepository,
    private val storeFactory: CoffeeDrinksDataStoreFactory,
    private val preferencesRepository: PreferencesRepository
) : CoffeeDrinksRepository {

    override fun getCoffeeDrinks(): Single<List<CoffeeDrink>> {
        val sessionEntity = preferencesRepository.getSessionInfo()
        return storeFactory.getRemoteDataStore().getCoffeeDrinks(sessionEntity.accessToken)
            .map { it.map { entity -> mapper.mapFromEntity(entity) } }
    }

    override fun getCoffeeDrinksByName(name: String): Single<List<CoffeeDrink>> {
        return Single.error(UnsupportedOperationException("Not implemented yet"))
    }

    override fun getCoffeeDrinkById(id: Long): Single<CoffeeDrink> {
        return storeFactory.getRemoteDataStore().getCoffeeById(id)
            .map { mapper.mapFromEntity(it) }
    }

    override fun addCoffeeDrinkToFavourites(coffeeId: Long): Single<CoffeeDrink> {
        return storeFactory.getRemoteDataStore().setCoffeeAsFavourite(coffeeId)
            .map { mapper.mapFromEntity(it) }

    }

    override fun removeCoffeeDrinkFromFavourites(coffeeId: Long): Single<CoffeeDrink> {
        return storeFactory.getRemoteDataStore().setCoffeeAsNotFavourite(coffeeId)
            .map { mapper.mapFromEntity(it) }
    }
}