package app.bangkit.architecturecomponent.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0,

    @ColumnInfo(name = "first_name")
    val firstName: String?,

    @ColumnInfo(name = "last_name")
    val lastName: String?
)