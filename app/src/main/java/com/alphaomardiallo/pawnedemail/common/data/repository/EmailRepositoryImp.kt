package com.alphaomardiallo.pawnedemail.common.data.repository

import com.alphaomardiallo.pawnedemail.common.data.local.dao.EmailDao
import com.alphaomardiallo.pawnedemail.common.data.local.entity.EmailEntity
import com.alphaomardiallo.pawnedemail.common.domain.repository.EmailRepository
import javax.inject.Inject

class EmailRepositoryImp @Inject constructor(
    private val emailDao: EmailDao,
) : EmailRepository {

    override suspend fun upsertEmail(email: EmailEntity) {
        emailDao.upsertEmail(email)
    }

    override suspend fun getFirstEmail() = emailDao.getFirstEmail()
}
