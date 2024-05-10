package com.alphaomardiallo.pawnedemail.feature.breachesregistered.data.model

import androidx.annotation.Keep
import com.alphaomardiallo.pawnedemail.feature.breachesregistered.domain.model.BreachesRegistered
import com.squareup.moshi.Json

/**
 * Represents a data class for breach information.
 * @property name A Pascal-cased name representing the breach which is unique across all other breaches.
 *                 This value never changes and may be used to name dependent assets (such as images)
 *                 but should not be shown directly to end users (see the "Title" attribute instead).
 * @property title A descriptive title for the breach suitable for displaying to end users. It's unique
 *                 across all breaches but individual values may change in the future (i.e. if another
 *                 breach occurs against an organisation already in the system). If a stable value is required
 *                 to reference the breach, refer to the "Name" attribute instead.
 * @property domain The domain of the primary website the breach occurred on. This may be used for identifying
 *                  other assets external systems may have for the site.
 * @property breachDate The date (with no time) the breach originally occurred on in ISO 8601 format.
 *                      This is not always accurate — frequently breaches are discovered and reported long
 *                      after the original incident. Use this attribute as a guide only.
 * @property addedDate The date and time (precision to the minute) the breach was added to the system
 *                      in ISO 8601 format.
 * @property modifiedDate The date and time (precision to the minute) the breach was modified in ISO 8601 format.
 *                        This will only differ from the AddedDate attribute if other attributes represented
 *                        here are changed or data in the breach itself is changed (i.e. additional data is
 *                        identified and loaded). It is always either equal to or greater than the AddedDate
 *                        attribute, never less than.
 * @property pwnCount The total number of accounts loaded into the system. This is usually less than the
 *                     total number reported by the media due to duplication or other data integrity issues
 *                     in the source data.
 * @property description Contains an overview of the breach represented in HTML markup. The description may
 *                       include markup such as emphasis and strong tags as well as hyperlinks.
 * @property dataClasses This attribute describes the nature of the data compromised in the breach and contains
 *                       an alphabetically ordered string array of impacted data classes.
 * @property isVerified Indicates that the breach is considered unverified. An unverified breach may not have
 *                      been hacked from the indicated website. An unverified breach is still loaded into HIBP
 *                      when there's sufficient confidence that a significant portion of the data is legitimate.
 * @property isFabricated Indicates that the breach is considered fabricated. A fabricated breach is unlikely
 *                        to have been hacked from the indicated website and usually contains a large amount
 *                        of manufactured data. However, it still contains legitimate email addresses and
 *                        asserts that the account owners were compromised in the alleged breach.
 * @property isSensitive Indicates if the breach is considered sensitive. The public API will not return any
 *                       accounts for a breach flagged as sensitive.
 * @property isRetired Indicates if the breach has been retired. This data has been permanently removed and
 *                      will not be returned by the API.
 * @property isSpamList Indicates if the breach is considered a spam list. This flag has no impact on any
 *                       other attributes but it means that the data has not come as a result of a security
 *                       compromise.
 * @property isMalware Indicates if the breach is sourced from malware. This flag has no impact on any other
 *                      attributes, it merely flags that the data was sourced from a malware campaign rather
 *                      than a security compromise of an online service.
 * @property isSubscriptionFree Indicates if the breach is subscription free. This flag has no impact on any
 *                               other attributes, it is only used when running a domain search where a
 *                               sufficiently sized subscription isn't present.
 * @property logoPath A URI that specifies where a logo for the breached service can be found. Logos are
 *                     always in PNG format.
 */
@Keep
data class AllBreachesDto(
    @Json(name = "AddedDate") val addedDate: String,
    @Json(name = "BreachDate") val breachDate: String,
    @Json(name = "DataClasses") val dataClasses: List<String>,
    @Json(name = "Description") val description: String,
    @Json(name = "Domain") val domain: String,
    @Json(name = "IsFabricated") val isFabricated: Boolean,
    @Json(name = "IsMalware") val isMalware: Boolean,
    @Json(name = "IsRetired") val isRetired: Boolean,
    @Json(name = "IsSensitive") val isSensitive: Boolean,
    @Json(name = "IsSpamList") val isSpamList: Boolean,
    @Json(name = "IsSubscriptionFree") val isSubscriptionFree: Boolean,
    @Json(name = "IsVerified") val isVerified: Boolean,
    @Json(name = "LogoPath") val logoPath: String,
    @Json(name = "ModifiedDate") val modifiedDate: String,
    @Json(name = "Name") val name: String,
    @Json(name = "PwnCount") val pwnCount: Int,
    @Json(name = "Title") val title: String,
) {
    fun toBreachesRegistered() = BreachesRegistered(
        addedDate = this.addedDate,
        breachDate = this.breachDate,
        dataClasses = this.dataClasses,
        description = this.description,
        domain = this.domain,
        isFabricated = this.isFabricated,
        isMalware = this.isMalware,
        isRetired = this.isRetired,
        isSensitive = this.isSensitive,
        isSpamList = this.isSpamList,
        isSubscriptionFree = this.isSubscriptionFree,
        isVerified = this.isVerified,
        logoPath = this.logoPath,
        modifiedDate = this.modifiedDate,
        name = this.name,
        pwnCount = this.pwnCount,
        title = this.title
    )
}
