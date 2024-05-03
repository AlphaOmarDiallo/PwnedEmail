package com.alphaomardiallo.pawnedemail.feature.getallbreaches.data.model

import com.alphaomardiallo.pawnedemail.feature.getallbreaches.domain.model.AllBreaches
import com.squareup.moshi.Json

data class BreachesDto(
    @field:Json(name = "Name") val name: String,
) {
    fun toAllBreaches() = AllBreaches(name = this.name)
}
