package com.alphaomardiallo.pawnedemail.feature.getallbreaches.data.model

import androidx.annotation.Keep
import com.alphaomardiallo.pawnedemail.feature.getallbreaches.domain.model.AllBreaches
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class BreachesDto(
    @field:Json(name = "Name") val name: String,
) {
    fun toAllBreaches() = AllBreaches(name = this.name)
}
