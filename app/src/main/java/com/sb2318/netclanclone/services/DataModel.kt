package com.sb2318.netclanclone.services

data class DataModel(
    val title:String,
    val location: String,
    val distance: Long,
    val progress:Int,
    val tags: List<String>,
    val experiencedYear: Int,
    val companyType:String, // in client screen, in case of individual it will replace by status
    val companyName:String, // NA| 1 Years Of experience
    val status:String,  // in individual screen, in case of merchant it will replace by companyType

  )
