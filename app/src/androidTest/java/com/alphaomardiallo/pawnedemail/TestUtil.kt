package com.alphaomardiallo.pawnedemail

import com.alphaomardiallo.pawnedemail.common.data.local.entity.BreachesEntity
import com.alphaomardiallo.pawnedemail.common.domain.model.Breach
import com.google.gson.Gson

internal object TestUtil {

    private val jsonData = """
[
  {
    "name": "Dubsmash",
    "title": "Dubsmash",
    "domain": "dubsmash.com",
    "breachDate": "2018-12-01",
    "addedDate": "2019-02-25T08:35:58Z",
    "modifiedDate": "2019-02-25T08:35:58Z",
    "pwnCount": 161749950,
    "description": "In December 2018, the video messaging service <a href=\"https://www.theregister.co.uk/2019/02/11/620_million_hacked_accounts_dark_web/\" target=\"_blank\" rel=\"noopener\">Dubsmash suffered a data breach</a>. The incident exposed 162 million unique email addresses alongside usernames and PBKDF2 password hashes. In 2019, the data appeared listed for sale on a dark web marketplace (along with several other large breaches) and subsequently began circulating more broadly. The data was provided to HIBP by a source who requested it to be attributed to &quot;BenjaminBlue@exploit.im&quot;.",
    "logoPath": "https://haveibeenpwned.com/Content/Images/PwnedLogos/Dubsmash.png",
    "dataClasses": ["Email addresses", "Geographic locations", "Names", "Passwords", "Phone numbers", "Spoken languages", "Usernames"],
    "isVerified": true,
    "isFabricated": false,
    "isSensitive": false,
    "isRetired": false,
    "isSpamList": false,
    "isMalware": false,
    "isSubscriptionFree": false
  },
  {
    "name": "LeSlipFrancais",
    "title": "Le Slip Français",
    "domain": "leslipfrancais.fr",
    "breachDate": "2024-04-13",
    "addedDate": "2024-04-18T07:44:32Z",
    "modifiedDate": "2024-04-18T07:44:32Z",
    "pwnCount": 1495127,
    "description": "In April 2024, the French underwear maker <a href=\"https://twitter.com/troyhunt/status/1780856574787064075\" target=\"_blank\" rel=\"noopener\">Le Slip Français suffered a data breach</a>. The breach included 1.5M email addresses, physical addresses, names and phone numbers.",
    "logoPath": "https://haveibeenpwned.com/Content/Images/PwnedLogos/LeSlipFrancais.png",
    "dataClasses": ["Email addresses", "Names", "Phone numbers", "Physical addresses"],
    "isVerified": true,
    "isFabricated": false,
    "isSensitive": false,
    "isRetired": false,
    "isSpamList": false,
    "isMalware": false,
    "isSubscriptionFree": false
  },
  {
    "name": "OnlinerSpambot",
    "title": "Onliner Spambot",
    "domain": "",
    "breachDate": "2017-08-28",
    "addedDate": "2017-08-29T19:25:56Z",
    "modifiedDate": "2017-08-29T19:25:56Z",
    "pwnCount": 711477622,
    "description": "In August 2017, a spambot by the name of <a href=\"https://benkowlab.blogspot.com.au/2017/08/from-onliner-spambot-to-millions-of.html\" target=\"_blank\" rel=\"noopener\">Onliner Spambot was identified by security researcher Benkow moʞuƎq</a>. The malicious software contained a server-based component located on an IP address in the Netherlands which exposed a large number of files containing personal information. In total, there were 711 million unique email addresses, many of which were also accompanied by corresponding passwords. A full write-up on what data was found is in the blog post titled <a href=\"https://www.troyhunt.com/inside-the-massive-711-million-record-onliner-spambot-dump\" target=\"_blank\" rel=\"noopener\">Inside the Massive 711 Million Record Onliner Spambot Dump</a>.",
    "logoPath": "https://haveibeenpwned.com/Content/Images/PwnedLogos/Email.png",
    "dataClasses": ["Email addresses", "Passwords"],
    "isVerified": true,
    "isFabricated": false,
    "isSensitive": false,
    "isRetired": false,
    "isSpamList": true,
    "isMalware": false,
    "isSubscriptionFree": false
  }
]
"""

    val gson = Gson()
    val breaches: List<BreachesEntity> =
        gson.fromJson(jsonData, Array<Breach>::class.java).toList().map { it.toBreachEntity() }

    fun provideBreachEntityList() = breaches
}
