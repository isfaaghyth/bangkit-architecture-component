package app.bangkit.architecturecomponent.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

interface CoroutineDispatchers {
    fun main(): CoroutineDispatcher
    fun io(): CoroutineDispatcher
}

class TestDispatcher : CoroutineDispatchers {
    override fun main(): CoroutineDispatcher {
        return Dispatchers.Unconfined
    }

    override fun io(): CoroutineDispatcher {
        return Dispatchers.Unconfined
    }
}

class AppDispatcher : CoroutineDispatchers {
    override fun main(): CoroutineDispatcher {
        return Dispatchers.Main
    }

    override fun io(): CoroutineDispatcher {
        return Dispatchers.IO
    }
}