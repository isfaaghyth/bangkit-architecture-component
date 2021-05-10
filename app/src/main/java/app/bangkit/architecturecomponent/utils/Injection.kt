package app.bangkit.architecturecomponent.utils

import android.content.Context
import app.bangkit.architecturecomponent.data.AppDatabase
import app.bangkit.architecturecomponent.data.UserDao
import app.bangkit.architecturecomponent.data.repository.UserLocalRepository
import app.bangkit.architecturecomponent.domain.getusers.GetUserLocalInteractor
import app.bangkit.architecturecomponent.domain.getusers.GetUserLocalUseCase
import app.bangkit.architecturecomponent.domain.IUserLocalRepository
import app.bangkit.architecturecomponent.domain.insertuser.InsertUserLocalInteractor
import app.bangkit.architecturecomponent.domain.insertuser.InsertUserLocalUseCase

object Injection {

    // first, you need to preparing the repository
    private fun provideRepository(userDao: UserDao): IUserLocalRepository {
        return UserLocalRepository(userDao)
    }

    // second, we need to provide the usecase/interfactor
    private fun provideGetUserLocalUseCase(
            repository: IUserLocalRepository
    ): GetUserLocalUseCase {
        return GetUserLocalInteractor(repository)
    }

    private fun provideInsertUserLocalUseCase(
            repository: IUserLocalRepository
    ): InsertUserLocalUseCase {
        return InsertUserLocalInteractor(repository)
    }

    private fun buildRepository(context: Context): IUserLocalRepository {
        return provideRepository(
                AppDatabase.instance(context).userDao()
        )
    }

    // third, the builder of the usecase
    fun buildGetUserLocalUseCase(context: Context): GetUserLocalUseCase {
        return provideGetUserLocalUseCase(buildRepository(context))
    }

    fun buildInsertUserLocalUseCase(context: Context): InsertUserLocalUseCase {
        return provideInsertUserLocalUseCase(buildRepository(context))
    }

}