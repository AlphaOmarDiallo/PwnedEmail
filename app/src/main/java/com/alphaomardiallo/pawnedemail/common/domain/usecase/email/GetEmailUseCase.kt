package com.alphaomardiallo.pawnedemail.common.domain.usecase.email

import com.alphaomardiallo.pawnedemail.common.domain.repository.EmailRepository
import javax.inject.Inject

class GetEmailUseCase @Inject constructor(
    private val emailRepository: EmailRepository,
) {

    suspend fun invoke() = emailRepository.getFirstEmail()
}
