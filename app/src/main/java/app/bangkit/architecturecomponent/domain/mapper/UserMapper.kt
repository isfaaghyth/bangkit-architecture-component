package app.bangkit.architecturecomponent.domain.mapper

import app.bangkit.architecturecomponent.data.entity.UserEntity
import app.bangkit.architecturecomponent.domain.model.User

object UserMapper {

    fun mapTo(firstName: String, lastName: String): UserEntity {
        return UserEntity(
                firstName = firstName,
                lastName = lastName
        )
    }

    fun mapToUser(userEntity: UserEntity): User {
        return User(
                uid = userEntity.uid,
                firstName = userEntity.firstName?: "",
                lastName = userEntity.lastName?: ""
        )
    }

}