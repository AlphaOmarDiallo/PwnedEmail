package com.alphaomardiallo.pawnedemail.common.domain.repository

import com.alphaomardiallo.pawnedemail.common.data.local.entity.EmailEntity

interface EmailRepository {

    suspend fun upsertEmail(email: EmailEntity)

    suspend fun getFirstEmail(): EmailEntity?
}
