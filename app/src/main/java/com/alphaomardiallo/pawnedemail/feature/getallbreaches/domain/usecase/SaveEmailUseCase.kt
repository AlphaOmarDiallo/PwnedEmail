package com.alphaomardiallo.pawnedemail.feature.getallbreaches.domain.usecase

import com.alphaomardiallo.pawnedemail.common.domain.model.Email
import com.alphaomardiallo.pawnedemail.common.domain.usecase.email.UpsertEmailUseCase
import javax.inject.Inject

class SaveEmailUseCase @Inject constructor(
    private val upsertEmailUseCase: UpsertEmailUseCase,
) {

    suspend fun invoke(email: Email) = upsertEmailUseCase.invoke(email)
}
