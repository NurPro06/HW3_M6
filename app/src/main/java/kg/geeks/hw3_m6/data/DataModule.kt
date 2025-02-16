package kg.geeks.hw3_m6.data

import com.google.gson.Gson
import kg.geeks.hw3_m6.BuildConfig
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit

val dataModule: Module = module {

}
private fun provideRetrofit(): Retrofit{
    return Retrofit.Builder()
        .addConverterFactory()
        .baseUrl(BuildConfig.BASE_URL)
        .build()
}