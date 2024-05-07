package com.alphaomardiallo.pawnedemail.common.domain.usecase.email

import com.alphaomardiallo.pawnedemail.common.domain.model.Email
import com.alphaomardiallo.pawnedemail.common.domain.repository.EmailRepository
import javax.inject.Inject

class UpsertEmailUseCase @Inject constructor(
    private val emailRepository: EmailRepository,
) {

    suspend fun invoke(email: Email) = emailRepository.upsertEmail(email.toEmailEntity())
}
