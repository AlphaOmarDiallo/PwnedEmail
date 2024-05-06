package com.alphaomardiallo.pawnedemail.common.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.alphaomardiallo.pawnedemail.common.data.local.entity.BreachesEntity

@Dao
interface BreachesDao {

    @Upsert
    suspend fun upsertBreach(breach: BreachesEntity)

    @Query("DELETE FROM breaches_table")
    fun nukeBreachesTable()
}
