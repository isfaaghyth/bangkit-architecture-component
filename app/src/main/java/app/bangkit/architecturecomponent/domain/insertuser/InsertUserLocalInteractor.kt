package app.bangkit.architecturecomponent.domain.insertuser

import app.bangkit.architecturecomponent.domain.IUserLocalRepository
import app.bangkit.architecturecomponent.domain.mapper.UserMapper

class InsertUserLocalInteractor constructor(
        val repository: IUserLocalRepository
): InsertUserLocalUseCase {

    override fun insert(firstName: String, lastName: String) {
        repository.insert(UserMapper.mapTo(
                firstName, lastName
        ))
    }

}