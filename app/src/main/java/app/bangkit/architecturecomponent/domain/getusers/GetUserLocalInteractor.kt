package app.bangkit.architecturecomponent.domain.getusers

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import app.bangkit.architecturecomponent.domain.IUserLocalRepository
import app.bangkit.architecturecomponent.domain.mapper.UserMapper
import app.bangkit.architecturecomponent.domain.model.User

class GetUserLocalInteractor constructor(
        private val repository: IUserLocalRepository
): GetUserLocalUseCase {

    override fun getAll(): LiveData<List<User>> {
        return Transformations.map(repository.getAll()) {
            it.map { userEntity ->
                UserMapper.mapToUser(userEntity)
            }
        }
    }

}