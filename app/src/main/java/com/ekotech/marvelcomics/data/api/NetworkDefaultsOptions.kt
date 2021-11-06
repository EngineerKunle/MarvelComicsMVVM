package com.ekotech.marvelcomics.data.api

data class NetworkDefaultsOptions(
    val publicKey: String,
    val privateKey: String,
    val timeStamp: String,
    val orderBy: String,
    val titleStartsWith: String
)
