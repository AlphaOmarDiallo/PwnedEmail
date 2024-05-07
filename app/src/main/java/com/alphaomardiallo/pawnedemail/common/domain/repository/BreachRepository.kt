package com.alphaomardiallo.pawnedemail.common.domain.repository

import com.alphaomardiallo.pawnedemail.common.data.local.entity.BreachesEntity
import kotlinx.coroutines.flow.Flow

interface BreachRepository {

    suspend fun upsertBreach(breach: BreachesEntity)

    fun deleteAllBreaches()

    suspend fun getAllBreaches(): Flow<List<BreachesEntity>>

    suspend fun getCount(): Flow<Int>
}
