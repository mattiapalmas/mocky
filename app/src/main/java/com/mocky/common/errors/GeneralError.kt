package com.mocky.common.errors

class GeneralError(
    val errorMessage: String = "",
    cause: Throwable? = null
) : RuntimeException(errorMessage, cause)