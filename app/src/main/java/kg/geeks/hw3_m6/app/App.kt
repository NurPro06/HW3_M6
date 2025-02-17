package kg.geeks.hw3_m6.app

import android.app.Application
import kg.geeks.hw3_m6.data.serviseLocator.dataModule
import kg.geeks.hw3_m6.ui.serviceLocator.uiModule
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            modules(listOf(dataModule, uiModule))

        }
    }
}