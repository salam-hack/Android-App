package com.salamhack.presentation.uiModel

import androidx.compose.ui.graphics.Color
import com.salamhack.R
import com.salamhack.domain.entity.Category

data class CategoryUiModel(
    val id: String,
    val name: String,
    val icon: Int,
    val iconColor: Color,
    val iconBackgroundColor: Color
)

fun getCategoryIcon(categoryId: String): Int {
    return when (categoryId) {
        "EXP_FOOD" -> { R.drawable.ic_food }
        "EXP_TRANSPORT" -> { R.drawable.ic_food }
        "EXP_BILLS" -> { R.drawable.ic_food }
        "EXP_SHOPPING" -> { R.drawable.ic_food }
        "EXP_ENTERTAINMENT" -> { R.drawable.ic_food }
        "EXP_HEALTH" -> { R.drawable.ic_food }
        "EXP_EDUCATION" -> { R.drawable.ic_food }
        "EXP_GIFTS" -> { R.drawable.ic_food }
        "EXP_OTHER" -> { R.drawable.ic_food }
        "INC_SALARY" -> { R.drawable.ic_food }
        "INC_FREELANCE" -> { R.drawable.ic_food }
        "INC_INVESTMENTS" -> { R.drawable.ic_food }
        "INC_GIFTS" -> { R.drawable.ic_food }
        "INC_OTHER" -> { R.drawable.ic_food }
        "GOAL_ELECTRONICS" -> { R.drawable.ic_food }
        "GOAL_TRAVEL" -> { R.drawable.ic_food }
        "GOAL_CAR" -> { R.drawable.ic_food }
        "GOAL_HOME" -> { R.drawable.ic_food }
        "GOAL_PERSONAL" -> { R.drawable.ic_food }
        else -> { R.drawable.ic_category }
    }
}

fun getCategoryName(categoryId: String): String {
    return when (categoryId) {
        "EXP_FOOD" -> { "الطعام والمشروبات" }
        "EXP_TRANSPORT" -> { "المواصلات" }
        "EXP_BILLS" -> { "الفواتير والاشتراكات" }
        "EXP_SHOPPING" -> { "التسوق" }
        "EXP_ENTERTAINMENT" -> { "الترفيه" }
        "EXP_HEALTH" -> { "الرعاية الصحية" }
        "EXP_EDUCATION" -> { "التعليم" }
        "EXP_GIFTS" -> { "الهدايا والتبرعات" }
        "EXP_OTHER" -> { "أخرى" }
        "INC_SALARY" -> { "الراتب" }
        "INC_FREELANCE" -> { "العمل الحر" }
        "INC_INVESTMENTS" -> { "الاستثمارات" }
        "INC_GIFTS" -> { "الهدايا" }
        "INC_OTHER" -> { "دخل آخر" }
        "GOAL_ELECTRONICS" -> { "الإلكترونيات" }
        "GOAL_TRAVEL" -> { "السفر" }
        "GOAL_CAR" -> { "السيارة" }
        "GOAL_HOME" -> { "المنزل" }
        "GOAL_PERSONAL" -> { "شخصي" }
        else -> { "آخر" }
    }
}




fun Category.toUi(): CategoryUiModel {
    return when (id) {

        "EXP_FOOD" -> CategoryUiModel(
            id = id,
            name = name,
            icon= R.drawable.ic_tv,
            iconColor = Color(0xFFFF6B6B),
            iconBackgroundColor = Color(0x1AFF6B6B)
        )

        "EXP_TRANSPORT" -> CategoryUiModel(
            id, name,
            R.drawable.ic_tv,
            Color(0xFF4D96FF),
            Color(0x1A4D96FF)
        )

        "EXP_BILLS" -> CategoryUiModel(
            id, name,
            R.drawable.ic_tv,
            Color(0xFF4D96FF),
            Color(0x1A4D96FF)
        )

        "EXP_SHOPPING" -> CategoryUiModel(
            id, name,
            R.drawable.ic_tv,
            Color(0xFF4D96FF),
            Color(0x1A4D96FF)
        )

        "EXP_ENTERTAINMENT" -> CategoryUiModel(
            id, name,
            R.drawable.ic_tv,
            Color(0xFF4D96FF),
            Color(0x1A4D96FF)
        )

        "EXP_HEALTH" -> CategoryUiModel(
            id, name,
            R.drawable.ic_tv,
            Color(0xFF4D96FF),
            Color(0x1A4D96FF)
        )

        "EXP_EDUCATION" -> CategoryUiModel(
            id, name,
            R.drawable.ic_tv,
            Color(0xFF4D96FF),
            Color(0x1A4D96FF)
        )

        "EXP_GIFTS" -> CategoryUiModel(
            id, name,
            R.drawable.ic_tv,
            Color(0xFF4D96FF),
            Color(0x1A4D96FF)
        )

        "EXP_OTHER" -> CategoryUiModel(
            id, name,
            R.drawable.ic_tv,
            Color(0xFF4D96FF),
            Color(0x1A4D96FF)
        )

        "INC_SALARY" -> CategoryUiModel(
            id, name,
            R.drawable.ic_tv,
            Color(0xFF4D96FF),
            Color(0x1A4D96FF)
        )

        "INC_FREELANCE" -> CategoryUiModel(
            id, name,
            R.drawable.ic_tv,
            Color(0xFF4D96FF),
            Color(0x1A4D96FF)
        )

        "INC_INVESTMENTS" -> CategoryUiModel(
            id, name,
            R.drawable.ic_tv,
            Color(0xFF4D96FF),
            Color(0x1A4D96FF)
        )

        "INC_GIFTS" -> CategoryUiModel(
            id, name,
            R.drawable.ic_tv,
            Color(0xFF4D96FF),
            Color(0x1A4D96FF)
        )

        "INC_OTHER" -> CategoryUiModel(
            id, name,
            R.drawable.ic_tv,
            Color(0xFF4D96FF),
            Color(0x1A4D96FF)
        )

        "GOAL_ELECTRONICS" -> CategoryUiModel(
            id, name,
            R.drawable.ic_tv,
            Color(0xFF4D96FF),
            Color(0x1A4D96FF)
        )

        "GOAL_TRAVEL" -> CategoryUiModel(
            id, name,
            R.drawable.ic_tv,
            Color(0xFF4D96FF),
            Color(0x1A4D96FF)
        )

        "GOAL_CAR" -> CategoryUiModel(
            id, name,
            R.drawable.ic_tv,
            Color(0xFF4D96FF),
            Color(0x1A4D96FF)
        )

        "GOAL_HOME" -> CategoryUiModel(
            id, name,
            R.drawable.ic_tv,
            Color(0xFF4D96FF),
            Color(0x1A4D96FF)
        )

        "GOAL_PERSONAL" -> CategoryUiModel(
            id, name,
            R.drawable.ic_tv,
            Color(0xFF4D96FF),
            Color(0x1A4D96FF)
        )

        else -> CategoryUiModel(
            id, name,
            R.drawable.ic_category,
            Color(0xFF8C98A8),
            Color(0xFFF4F6F9)
        )
    }
}