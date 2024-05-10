package com.alphaomardiallo.pawnedemail.common.domain.model

sealed class ErrorEntity {
    data object Network : ErrorEntity()

    data object BadRequest : ErrorEntity()

    data object Unauthorized : ErrorEntity()

    data object TooManyRequest : ErrorEntity()

    data object AccessDenied : ErrorEntity()

    data object NotFound : ErrorEntity()

    data object NotAllowed : ErrorEntity()

    data object ServerError : ErrorEntity()

    data object ServiceUnavailable : ErrorEntity()

    data object Unknown : ErrorEntity()
}
