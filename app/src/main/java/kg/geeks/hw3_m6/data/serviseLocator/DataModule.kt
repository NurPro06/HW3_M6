package kg.geeks.hw3_m6.data.serviseLocator

import kg.geeks.hw3_m6.BuildConfig
import kg.geeks.hw3_m6.data.api.CharacterApiService
import kg.geeks.hw3_m6.data.api.EpisodeApiService
import kg.geeks.hw3_m6.data.api.LocationApiService
import kg.geeks.hw3_m6.data.repository.CharactersRepository
import kg.geeks.hw3_m6.data.repository.EpisodesRepository
import kg.geeks.hw3_m6.data.repository.LocationsRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val dataModule: Module = module {
    single { provideOkHttpClient() }
    single { provideRetrofit(get()) }
    single { get<Retrofit>().create(CharacterApiService::class.java) }
    single { get<Retrofit>().create(EpisodeApiService::class.java) }
    single { get<Retrofit>().create(LocationApiService::class.java) }
    single { CharactersRepository(get()) }
    single { EpisodesRepository(get()) }
    single { LocationsRepository(get()) }
}

private fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()
}

private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .build()
}