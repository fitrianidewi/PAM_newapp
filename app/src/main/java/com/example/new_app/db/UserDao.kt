package com.example.new_app.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(user: UserEntity)

    @Query("SELECT * FROM users WHERE email = :email AND password = :password")
    suspend fun getUserByEmailAndPassword(email: String, password: String): UserEntity?
    abstract fun updateUser(entity: UserEntity)
    abstract fun deleteUser(entity: UserEntity)
    abstract fun getAllUserInfo(): List<UserEntity>?
}