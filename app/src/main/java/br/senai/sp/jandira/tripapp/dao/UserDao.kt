package br.senai.sp.jandira.tripapp.dao

import androidx.room.*
import br.senai.sp.jandira.tripapp.model.User


@Dao
interface UserDao {

    @Insert
    fun save(user: User): Long

    //servirá como um boolean, pois o boolean não existe do SQLite
    @Update
    fun update(user: User): Int

    @Delete
    fun delete(user: User): Int

    //email é o nome do metodo que quando eu chamar, irá fazer a consulta
    @Query("SELECT * FROM tbl_user WHERE email = :email AND password = :password")//Consulta
    fun authenticate(email: String, password: String): User

    @Query("SELECT * FROM tbl_user WHERE email = :email")
    fun findUserByEmail(email: String): User

}