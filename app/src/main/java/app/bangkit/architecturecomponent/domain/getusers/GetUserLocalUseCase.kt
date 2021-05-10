package app.bangkit.architecturecomponent.domain.getusers

import androidx.lifecycle.LiveData
import app.bangkit.architecturecomponent.domain.model.User

interface GetUserLocalUseCase {
    fun getAll(): LiveData<List<User>>
}