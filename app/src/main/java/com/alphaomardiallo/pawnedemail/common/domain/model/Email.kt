package com.alphaomardiallo.pawnedemail.common.domain.model

import com.alphaomardiallo.pawnedemail.common.data.local.entity.EmailEntity

data class Email(val email: String? = null) {

    fun toEmailEntity() = EmailEntity(
        email = this.email
    )
}
