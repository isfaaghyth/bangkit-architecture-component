package app.bangkit.architecturecomponent.data

import androidx.lifecycle.LiveData
import androidx.room.*
import app.bangkit.architecturecomponent.data.entity.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAll(): LiveData<List<UserEntity>>

    @Query("SELECT * FROM user WHERE first_name LIKE :firstName AND last_name LIKE :lastName LIMIT 1")
    fun getUserByName(firstName: String, lastName: String): UserEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(user: UserEntity)

    @Delete
    fun delete(user: UserEntity)

}