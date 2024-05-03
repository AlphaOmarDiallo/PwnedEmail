package com.alphaomardiallo.pawnedemail.common.di

import com.alphaomardiallo.pawnedemail.common.domain.navigator.AppNavigator
import com.alphaomardiallo.pawnedemail.common.domain.navigator.AppNavigatorImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NavigationModule {

    @Binds
    @Singleton
    abstract fun bindAppNavigator(appNavigatorImp: AppNavigatorImp): AppNavigator
}
