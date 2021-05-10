package app.bangkit.architecturecomponent.domain.insertuser

interface InsertUserLocalUseCase {
    fun insert(firstName: String, lastName: String)
}