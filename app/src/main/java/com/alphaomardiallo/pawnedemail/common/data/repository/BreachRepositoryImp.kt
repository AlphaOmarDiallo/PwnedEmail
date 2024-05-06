package com.alphaomardiallo.pawnedemail.common.data.repository

import com.alphaomardiallo.pawnedemail.common.data.local.dao.BreachesDao
import com.alphaomardiallo.pawnedemail.common.data.local.entity.BreachesEntity
import com.alphaomardiallo.pawnedemail.common.domain.repository.BreachRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class BreachRepositoryImp @Inject constructor(
    private val breachesDao: BreachesDao,
) : BreachRepository {

    override suspend fun upsertBreach(breach: BreachesEntity) {
        breachesDao.upsertBreach(breach)
    }

    override fun deleteAllBreaches() {
        breachesDao.nukeBreachesTable()
    }

    override suspend fun getAllBreaches(): Flow<List<BreachesEntity>> {
        return breachesDao.getAllBreaches()
    }
}
