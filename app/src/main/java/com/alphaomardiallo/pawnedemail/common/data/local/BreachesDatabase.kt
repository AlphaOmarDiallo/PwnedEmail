package com.alphaomardiallo.pawnedemail.common.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.alphaomardiallo.pawnedemail.common.data.local.converter.StringListConverter
import com.alphaomardiallo.pawnedemail.common.data.local.dao.BreachesDao
import com.alphaomardiallo.pawnedemail.common.data.local.dao.EmailDao
import com.alphaomardiallo.pawnedemail.common.data.local.entity.BreachesEntity
import com.alphaomardiallo.pawnedemail.common.data.local.entity.EmailEntity

@Database(
    entities = [BreachesEntity::class, EmailEntity::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(StringListConverter::class)
abstract class BreachesDatabase: RoomDatabase() {

    abstract fun breachesDao(): BreachesDao

    abstract fun emailDao(): EmailDao
}
