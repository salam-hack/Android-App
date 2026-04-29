package com.salamhack.data.source.local

import com.salamhack.domain.entity.Category

object LocalCategoriesDataSource {

    val expense = listOf(
        Category("EXP_FOOD", "الطعام والمشروبات"),
        Category("EXP_TRANSPORT", "المواصلات"),
        Category("EXP_BILLS", "الفواتير والاشتراكات"),
        Category("EXP_SHOPPING", "التسوق"),
        Category("EXP_ENTERTAINMENT", "الترفيه"),
        Category("EXP_HEALTH", "الرعاية الصحية",),
        Category("EXP_EDUCATION", "التعليم"),
        Category("EXP_GIFTS", "الهدايا والتبرعات"),
        Category("EXP_OTHER", "أخرى")
    )

    val income = listOf(
        Category("INC_SALARY", "الراتب"),
        Category("INC_FREELANCE", "العمل الحر"),
        Category("INC_INVESTMENTS", "الاستثمارات"),
        Category("INC_GIFTS", "الهدايا"),
        Category("INC_OTHER", "دخل آخر")
    )

    val goals = listOf(
        Category("GOAL_ELECTRONICS", "الإلكترونيات"),
        Category("GOAL_TRAVEL", "السفر"),
        Category("GOAL_CAR", "السيارة"),
        Category("GOAL_HOME", "المنزل"),
        Category("GOAL_PERSONAL", "شخصي")
    )

    fun getExpenseById(id: String): Category? {
        return expense.find { it.id == id }
    }

    fun getIncomeById(id: String): Category? {
        return income.find { it.id == id }
    }

    fun getGoalById(id: String): Category? {
        return goals.find { it.id == id }
    }
}