package app.bangkit.architecturecomponent.data.repository

import androidx.lifecycle.LiveData
import app.bangkit.architecturecomponent.data.UserDao
import app.bangkit.architecturecomponent.data.entity.UserEntity
import app.bangkit.architecturecomponent.domain.IUserLocalRepository

class UserLocalRepository constructor(
    private val user: UserDao
) : IUserLocalRepository {

    override fun getAll(): LiveData<List<UserEntity>> {
        return user.getAll()
    }

    override fun insert(userEntity: UserEntity) {
        user.insert(userEntity)
    }

    override fun delete(userEntity: UserEntity) {
        user.delete(userEntity)
    }

}