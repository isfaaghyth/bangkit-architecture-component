package app.bangkit.architecturecomponent.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.bangkit.architecturecomponent.data.entity.UserEntity
import app.bangkit.architecturecomponent.data.repository.UserLocalRepository
import app.bangkit.architecturecomponent.dispatcher.CoroutineDispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val userLocalRepository: UserLocalRepository,
    private val dispatchers: CoroutineDispatchers
) : ViewModel() {

    fun getAllUsers(): LiveData<List<UserEntity>> {
        return userLocalRepository.getAll()
    }

    fun insert(firstName: String, lastName: String) {
        val userEntity = UserEntity(
            firstName = firstName,
            lastName = lastName
        )

        viewModelScope.launch(dispatchers.io()) {
            userLocalRepository.insert(userEntity)
        }
    }

}