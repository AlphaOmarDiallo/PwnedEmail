package com.alphaomardiallo.pawnedemail.common.domain.repository

import com.alphaomardiallo.pawnedemail.common.data.local.entity.EmailEntity
import kotlinx.coroutines.flow.Flow

interface EmailRepository {

    suspend fun upsertEmail(email: EmailEntity)

    suspend fun getFirstEmail(): Flow<EmailEntity?>
}
