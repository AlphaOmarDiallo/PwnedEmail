package com.alphaomardiallo.pawnedemail.common.data.local.dao

import androidx.room.Dao
import androidx.room.Upsert
import com.alphaomardiallo.pawnedemail.common.data.local.entity.EmailEntity

@Dao
interface EmailDao {

    @Upsert
    suspend fun upsertEmail(email: EmailEntity)
}
