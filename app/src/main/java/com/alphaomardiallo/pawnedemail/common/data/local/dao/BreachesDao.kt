package com.alphaomardiallo.pawnedemail.common.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.alphaomardiallo.pawnedemail.common.data.local.entity.BreachesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BreachesDao {

    @Upsert
    suspend fun upsertBreach(breach: BreachesEntity)

    @Query("DELETE FROM breaches_table")
    fun nukeBreachesTable()

    @Query("SELECT * FROM breaches_table")
    fun getAllBreaches(): Flow<List<BreachesEntity>>

    @Query("SELECT COUNT(*) FROM breaches_table")
    fun getCount(): Flow<Int>
}
