package app.bangkit.architecturecomponent.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import app.bangkit.architecturecomponent.data.repository.UserLocalRepository
import app.bangkit.architecturecomponent.dispatcher.AppDispatcher
import app.bangkit.architecturecomponent.viewmodel.MainViewModel
import java.lang.IllegalArgumentException

/*
* Because our viewModel have parameters/arguments,
* we should to create the viewModel factory to passing
* the same arguments into viewModel
* */

class MainViewModelFactory constructor(
    private val userLocalRepository: UserLocalRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(
                userLocalRepository,
                AppDispatcher()
            ) as T
        }

        throw IllegalArgumentException("Unknown viewModel class")
    }

}