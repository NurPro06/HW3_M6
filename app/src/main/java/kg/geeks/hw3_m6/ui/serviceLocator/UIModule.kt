package kg.geeks.hw3_m6.ui.serviceLocator

import kg.geeks.hw3_m6.ui.screens.characters.CharactersViewModel
import kg.geeks.hw3_m6.ui.screens.episodes.EpisodesViewModel
import kg.geeks.hw3_m6.ui.screens.locations.LocationsViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val uiModule: Module = module {
    viewModel { CharactersViewModel(get()) }
    viewModel { EpisodesViewModel(get()) }
    viewModel { LocationsViewModel(get()) }
}