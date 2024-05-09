package com.alphaomardiallo.pawnedemail.common.domain.usecase.email

import com.alphaomardiallo.pawnedemail.common.domain.repository.EmailRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.flow

class GetEmailUseCase @Inject constructor(
    private val emailRepository: EmailRepository,
) {

    suspend fun invoke() = flow {
        emailRepository.getFirstEmail().collect { email ->
            emit(email?.toEmail())
        }
    }
}
