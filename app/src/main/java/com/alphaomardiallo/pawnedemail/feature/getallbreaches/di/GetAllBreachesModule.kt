package com.alphaomardiallo.pawnedemail.feature.getallbreaches.di

import com.alphaomardiallo.pawnedemail.feature.getallbreaches.data.remote.datasource.AllBreachesDataSource
import com.alphaomardiallo.pawnedemail.feature.getallbreaches.data.repository.AllBreachesHIBPRepositoryImp
import com.alphaomardiallo.pawnedemail.feature.getallbreaches.domain.repository.AllBreachesHIBPRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class GetAllBreachesModule {

    @Provides
    @Singleton
    fun provideAllBreachesRepository(
        allBreachesDataSource: AllBreachesDataSource,
    ): AllBreachesHIBPRepository = AllBreachesHIBPRepositoryImp(allBreachesDataSource)
}
