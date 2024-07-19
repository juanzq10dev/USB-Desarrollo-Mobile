package com.example.mvvmwithfragments.repositories

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvmwithfragments.daos.ContactDao
import com.example.mvvmwithfragments.models.Contact

@Database(entities = [Contact::class], version = 2)
abstract class ContactsAppDatabase: RoomDatabase() {
    abstract val contactDao: ContactDao

    companion object {
        @Volatile
        private var INSTANCE: ContactsAppDatabase? = null
        fun getInstance(context: Context): ContactsAppDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(context.applicationContext,
                        ContactsAppDatabase::class.java, "contacts_db")
                        .fallbackToDestructiveMigration() // .addMigrations() <- Create a migration class with logic to do a migration.
                        .build()
                }

                INSTANCE = instance
                return instance
            }
        }
    }


}