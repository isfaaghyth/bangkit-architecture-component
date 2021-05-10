package app.bangkit.architecturecomponent.domain

import androidx.lifecycle.LiveData
import app.bangkit.architecturecomponent.data.entity.UserEntity

interface IUserLocalRepository {
    fun getAll(): LiveData<List<UserEntity>>
    fun insert(userEntity: UserEntity)
    fun delete(userEntity: UserEntity)
}