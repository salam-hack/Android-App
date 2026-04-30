package com.salamhack.data.source.remote.transaction.mapper

import com.salamhack.data.source.remote.transaction.dto.ParsedTransactionDataDto
import com.salamhack.domain.entity.ParsedTransaction

fun ParsedTransactionDataDto.toDomain(): ParsedTransaction {
    val isIncome = categoryId?.startsWith("INC_") == true

    val title = product ?: merchant ?: "معاملة غير معروفة"

    return ParsedTransaction(
        title = title,
        amount = amount ?: 0.0,
        isIncome = isIncome,
        categoryId = categoryId.orEmpty(),
        date = date.orEmpty(),
        merchant = merchant.orEmpty()
    )
}