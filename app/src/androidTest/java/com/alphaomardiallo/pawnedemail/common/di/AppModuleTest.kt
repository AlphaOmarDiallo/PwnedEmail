package com.alphaomardiallo.pawnedemail.common.di

import com.alphaomardiallo.pawnedemail.BuildConfig
import com.alphaomardiallo.pawnedemail.common.data.util.RetrofitResultCallAdapterFactory
import com.alphaomardiallo.pawnedemail.feature.breachesregistered.data.remote.api.GetAllBreachesRegisteredApi
import com.alphaomardiallo.pawnedemail.feature.getallbreaches.data.remote.api.GetAllBreachesHIBPApi
import com.alphaomardiallo.pawnedemail.feature.getallbreaches.data.remote.datasource.AllBreachesDataSource
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Named
import javax.inject.Singleton
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [AppModule::class]
)
class AppModuleTest {
    @Provides
    @Singleton
    fun provideGetAllBreachesHIBPAPI(@Named(STANDARD_CLIENT) client: OkHttpClient): GetAllBreachesHIBPApi {

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        return Retrofit.Builder()
            .baseUrl(HIPB_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RetrofitResultCallAdapterFactory())
            .client(client)
            .build()
            .create(GetAllBreachesHIBPApi::class.java)
    }

    @Provides
    @Singleton
    fun provideGetAllBreachesRegistered(@Named(STANDARD_CLIENT) client: OkHttpClient): GetAllBreachesRegisteredApi {

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        return Retrofit.Builder()
            .baseUrl(HIPB_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RetrofitResultCallAdapterFactory())
            .client(client)
            .build()
            .create(GetAllBreachesRegisteredApi::class.java)
    }

    ///////////////////////////////////////////////////////////////////////////
    // DATA SOURCE
    ///////////////////////////////////////////////////////////////////////////

    @Provides
    @Singleton
    fun provideGetAllBreachesDataSource(api: GetAllBreachesHIBPApi): AllBreachesDataSource =
        AllBreachesDataSource(api)

    ///////////////////////////////////////////////////////////////////////////
    // HTTP CLIENT
    ///////////////////////////////////////////////////////////////////////////

    @Provides
    @Singleton
    @Named(STANDARD_CLIENT)
    fun provideStandardHIBPHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            addInterceptor(Interceptor { chain ->
                val originalRequest = chain.request().newBuilder()

                originalRequest.addHeader(
                    name = HIPB_API_KEY_HEADER,
                    value = BuildConfig.PAWNED_EMAIL_API
                )
                originalRequest.addHeader(name = HIPB_USER_AGENT_HEADER, value = APP_NAME)

                chain.proceed(originalRequest.build())
            })

            if (BuildConfig.DEBUG) {
                addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            }
        }.build()
    }

    ///////////////////////////////////////////////////////////////////////////
    // CONSTANTS
    ///////////////////////////////////////////////////////////////////////////

    private companion object {
        const val STANDARD_CLIENT = "standard"
        const val HIPB_API_KEY_HEADER = "hibp-api-key"
        const val HIPB_USER_AGENT_HEADER = "user-agent"
        const val HIPB_BASE_URL = "https://haveibeenpwned.com/api/v3/"
        const val APP_NAME = "pawned app by alpha diallo"
    }
}
