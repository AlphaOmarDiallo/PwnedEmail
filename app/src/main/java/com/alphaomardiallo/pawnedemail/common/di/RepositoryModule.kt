package com.alphaomardiallo.pawnedemail.common.di

import com.alphaomardiallo.pawnedemail.common.data.local.dao.BreachesDao
import com.alphaomardiallo.pawnedemail.common.data.local.dao.EmailDao
import com.alphaomardiallo.pawnedemail.common.data.repository.BreachRepositoryImp
import com.alphaomardiallo.pawnedemail.common.data.repository.EmailRepositoryImp
import com.alphaomardiallo.pawnedemail.common.domain.repository.BreachRepository
import com.alphaomardiallo.pawnedemail.common.domain.repository.EmailRepository
import com.alphaomardiallo.pawnedemail.feature.allbreaches.data.remote.datasource.AllBreachesRegisteredDataSource
import com.alphaomardiallo.pawnedemail.feature.allbreaches.data.repository.AllBreachesRegisteredRepositoryImp
import com.alphaomardiallo.pawnedemail.feature.allbreaches.domain.repository.AllBreachesRegisteredRepository
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
class RepositoryModule {

    @Provides
    @Singleton
    fun provideBreachesRepository(breachesDao: BreachesDao): BreachRepository =
        BreachRepositoryImp(breachesDao)

    @Provides
    @Singleton
    fun provideEmailRepository(emailDao: EmailDao): EmailRepository =
        EmailRepositoryImp(emailDao)

    @Provides
    @Singleton
    fun provideAllBreachesRepository(
        allBreachesDataSource: AllBreachesDataSource,
    ): AllBreachesHIBPRepository = AllBreachesHIBPRepositoryImp(allBreachesDataSource)

    @Provides
    @Singleton
    fun provideAllBreachesRegisteredRepository(
        allBreachesRegisteredDataSource: AllBreachesRegisteredDataSource,
    ): AllBreachesRegisteredRepository =
        AllBreachesRegisteredRepositoryImp(allBreachesRegisteredDataSource)
}
