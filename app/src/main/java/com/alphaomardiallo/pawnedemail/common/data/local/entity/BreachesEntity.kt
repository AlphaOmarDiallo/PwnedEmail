package com.alphaomardiallo.pawnedemail.common.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alphaomardiallo.pawnedemail.common.data.local.util.DatabaseConstant.BREACHES_ENTITY_NAME
import com.alphaomardiallo.pawnedemail.common.domain.model.Breach

@Entity(tableName = BREACHES_ENTITY_NAME)
data class BreachesEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "breaches_id") val id: Int = 0,
    @ColumnInfo(name = "breaches_name") val name: String,
    @ColumnInfo(name = "breaches_title") val title: String,
    @ColumnInfo(name = "breaches_domain") val domain: String,
    @ColumnInfo(name = "breaches_breach_date") val breachDate: String,
    @ColumnInfo(name = "breaches_added_date") val addedDate: String,
    @ColumnInfo(name = "breaches_modified_date") val modifiedDate: String,
    @ColumnInfo(name = "breaches_pwn_count") val pwnCount: Long,
    @ColumnInfo(name = "breaches_description") val description: String,
    @ColumnInfo(name = "breaches_logo_path") val logoPath: String,
    @ColumnInfo(name = "breaches_data_classes") val dataClasses: List<String>,
    @ColumnInfo(name = "breaches_is_verified") val isVerified: Boolean,
    @ColumnInfo(name = "breaches_is_fabricated") val isFabricated: Boolean,
    @ColumnInfo(name = "breaches_is_sensitive") val isSensitive: Boolean,
    @ColumnInfo(name = "breaches_is_retired") val isRetired: Boolean,
    @ColumnInfo(name = "breaches_is_spam_list") val isSpamList: Boolean,
    @ColumnInfo(name = "breaches_is_malware") val isMalware: Boolean,
    @ColumnInfo(name = "breaches_is_subscription_free") val isSubscriptionFree: Boolean,
) {
    fun toBreach() = Breach(
        name = this.name,
        title = this.title,
        domain = this.domain,
        breachDate = this.breachDate,
        addedDate = this.addedDate,
        modifiedDate = this.modifiedDate,
        pwnCount = this.pwnCount,
        description = this.description,
        logoPath = this.logoPath,
        dataClasses = this.dataClasses,
        isVerified = this.isVerified,
        isFabricated = this.isFabricated,
        isSensitive = this.isSensitive,
        isRetired = this.isRetired,
        isSpamList = this.isSpamList,
        isMalware = this.isMalware,
        isSubscriptionFree = this.isSubscriptionFree
    )
}
