package app.bangkit.architecturecomponent.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import app.bangkit.architecturecomponent.utils.AppDispatcher
import app.bangkit.architecturecomponent.utils.Injection

/*
* Because our viewModel have parameters/arguments,
* we should to create the viewModel factory to passing
* the same arguments into viewModel
* */

class MainViewModelFactory constructor(
    private val context: Context
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(
                    Injection.buildGetUserLocalUseCase(context),
                    Injection.buildInsertUserLocalUseCase(context),
                    AppDispatcher()
            ) as T
        }

        throw IllegalArgumentException("Unknown viewModel class")
    }

}