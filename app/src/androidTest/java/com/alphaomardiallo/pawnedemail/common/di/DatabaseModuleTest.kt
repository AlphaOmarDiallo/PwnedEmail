package com.alphaomardiallo.pawnedemail.common.di

import android.content.Context
import androidx.room.Room
import com.alphaomardiallo.pawnedemail.common.data.local.BreachesDatabase
import com.alphaomardiallo.pawnedemail.common.data.local.util.DatabaseConstant
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DatabaseModule::class]
)
class DatabaseModuleTest {

    @Singleton
    @Provides
    fun provideBreachesDataBase(@ApplicationContext app: Context) =
        Room.databaseBuilder(
            context = app,
            klass = BreachesDatabase::class.java,
            name = "${DatabaseConstant.BREACHES_DB_NAME}Test"
        ).build()

    @Singleton
    @Provides
    fun provideBreaches(database: BreachesDatabase) = database.breachesDao()

    @Singleton
    @Provides
    fun provideEmail(database: BreachesDatabase) = database.emailDao()
}
