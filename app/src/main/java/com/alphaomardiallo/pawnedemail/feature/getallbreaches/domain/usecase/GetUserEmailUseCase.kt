package com.alphaomardiallo.pawnedemail.feature.getallbreaches.domain.usecase

import com.alphaomardiallo.pawnedemail.common.domain.usecase.email.GetEmailUseCase
import javax.inject.Inject

class GetUserEmailUseCase @Inject constructor(
    private val getEmailUseCase: GetEmailUseCase,
) {

    suspend fun invoke() = getEmailUseCase.invoke()?.toEmail()?.email ?: ""
}
