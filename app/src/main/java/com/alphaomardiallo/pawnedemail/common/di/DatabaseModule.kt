package com.alphaomardiallo.pawnedemail.common.di

import android.content.Context
import androidx.room.Room
import com.alphaomardiallo.pawnedemail.common.data.local.BreachesDatabase
import com.alphaomardiallo.pawnedemail.common.data.local.util.DatabaseConstant.BREACHES_DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideBreachesDataBase(@ApplicationContext app: Context) =
        Room.databaseBuilder(
            context = app,
            klass = BreachesDatabase::class.java,
            name = BREACHES_DB_NAME
        ).build()

    @Singleton
    @Provides
    fun provideBreaches(database: BreachesDatabase) = database.breachesDao()

    @Singleton
    @Provides
    fun provideEmail(database: BreachesDatabase) = database.emailDao()
}
