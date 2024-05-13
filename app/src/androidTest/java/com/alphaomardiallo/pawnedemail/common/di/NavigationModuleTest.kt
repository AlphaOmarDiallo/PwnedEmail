package com.alphaomardiallo.pawnedemail.common.di

import com.alphaomardiallo.pawnedemail.common.domain.navigator.AppNavigator
import com.alphaomardiallo.pawnedemail.common.domain.navigator.AppNavigatorImp
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [NavigationModule::class]
)
abstract class NavigationModuleTest {

    @Binds
    @Singleton
    abstract fun bindAppNavigator(appNavigatorImp: AppNavigatorImp): AppNavigator
}
