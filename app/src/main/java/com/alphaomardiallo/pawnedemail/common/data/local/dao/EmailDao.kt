package com.alphaomardiallo.pawnedemail.common.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.alphaomardiallo.pawnedemail.common.data.local.entity.EmailEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface EmailDao {

    @Upsert
    suspend fun upsertEmail(email: EmailEntity)

    @Query("SELECT * FROM email_table LIMIT 1")
    fun getFirstEmail(): Flow<EmailEntity?>

    /** Used only for test */
    @Query("DELETE FROM email_table")
    fun nukeEmailTable()
}
