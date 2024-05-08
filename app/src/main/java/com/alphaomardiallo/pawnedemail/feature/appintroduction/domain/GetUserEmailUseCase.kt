package com.alphaomardiallo.pawnedemail.feature.appintroduction.domain

import com.alphaomardiallo.pawnedemail.common.domain.usecase.email.GetEmailUseCase
import javax.inject.Inject

class GetUserEmailOrNullUseCase @Inject constructor(
    private val getEmailUseCase: GetEmailUseCase,
) {

    suspend fun invoke() = getEmailUseCase.invoke()
}
