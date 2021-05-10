package app.bangkit.architecturecomponent.data.repository

import androidx.lifecycle.LiveData
import app.bangkit.architecturecomponent.data.UserDao
import app.bangkit.architecturecomponent.data.entity.UserEntity

class UserLocalRepository constructor(
    private val user: UserDao
) {

    fun getAll(): LiveData<List<UserEntity>> {
        return user.getAll()
    }

    fun insert(userEntity: UserEntity) {
        user.insert(userEntity)
    }

    fun delete(userEntity: UserEntity) {
        user.delete(userEntity)
    }

}