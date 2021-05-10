package app.bangkit.architecturecomponent.presentation

import android.os.Looper
import androidx.lifecycle.ViewModel
import app.bangkit.architecturecomponent.domain.getusers.GetUserLocalUseCase
import app.bangkit.architecturecomponent.domain.insertuser.InsertUserLocalUseCase
import app.bangkit.architecturecomponent.utils.CoroutineDispatchers
import java.util.concurrent.Executors

class MainViewModel(
        private val getUserLocalUseCase: GetUserLocalUseCase,
        private val insertUserLocalUseCase: InsertUserLocalUseCase,
        private val dispatchers: CoroutineDispatchers
) : ViewModel() {

    private val executors = Executors.newSingleThreadExecutor()
    private val looper = Looper.getMainLooper()

    fun getAllUsers()
            = getUserLocalUseCase.getAll()

    fun insert(firstName: String, lastName: String) {
        executors.execute {
            insertUserLocalUseCase.insert(firstName, lastName)
        }
    }

}