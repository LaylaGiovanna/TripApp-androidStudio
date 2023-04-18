package br.senai.sp.jandira.tripapp.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.tripapp.model.User

//Representa nosso banco de dados

//quando estiver com ENTITIES o ROOM sabe que é para criar o banco
@Database(entities = [User::class], version = 3)
abstract class TripDb : RoomDatabase() {
    abstract fun userDao(): UserDao
    companion object {
        private lateinit var instanceDb: TripDb

        fun getDataBase(context: Context): TripDb {
            //:: se positivo  !:: se negativo (not)
            if (!::instanceDb.isInitialized) {
                //se ele NÃO estiver inicializado ele retorna o instance db
                //invertemos para não ser preciso o else
                instanceDb = Room
                    .databaseBuilder(
                        context,
                        TripDb::class.java,
                        "db_trip"
                    ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
            }
            return instanceDb
        }
    }
}