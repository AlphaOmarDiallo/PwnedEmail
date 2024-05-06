package com.alphaomardiallo.pawnedemail.common.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alphaomardiallo.pawnedemail.common.data.local.util.DatabaseConstant.EMAIL_ENTITY_NAME

@Entity(tableName = EMAIL_ENTITY_NAME)
data class EmailEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "email_id") val id: Int = 0,
    @ColumnInfo(name = "email_email") val email: String? = null
)
