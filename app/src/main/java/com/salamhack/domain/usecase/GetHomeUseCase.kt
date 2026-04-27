package com.salamhack.domain.usecase

import com.salamhack.domain.entity.Balance
import com.salamhack.domain.entity.Goal
import com.salamhack.domain.entity.HomeEntity
import com.salamhack.domain.entity.SmartAnalysis
import com.salamhack.domain.entity.Transaction
import com.salamhack.domain.entity.User
import com.salamhack.domain.repository.HomeRepository

class GetHomeUseCase(
    private val repository: HomeRepository
) {
//    suspend operator fun invoke(): HomeEntity {
//        return repository.getHome()
//    }

    val fakeEntity = HomeEntity(
        user = User(
            name = "Muhammed Wael",
            profileImage = "https://i.pravatar.cc/300?img=12",
            hasNotification = true
        ),
        balance = Balance(
            currentBalance = 12840.75,
            currency = "EGP",
            incomeThisMonth = 22000.00,
            expensesThisMonth = 9159.25
        ),
        goals = listOf(
            Goal(
                title = "Emergency Fund",
                progress = 0.55f,
                savedAmount = 5500.0,
                targetAmount = 10000.0,
                message = "Nice progress — keep it up!"
            ),
            Goal(
                title = "New Laptop",
                progress = 0.30f,
                savedAmount = 4500.0,
                targetAmount = 15000.0,
                message = "You're 30% there."
            ),
            Goal(
                title = "Trip to Istanbul",
                progress = 0.72f,
                savedAmount = 18000.0,
                targetAmount = 25000.0,
                message = "Almost ready for your trip."
            )
        ),
        smartAnalysis = listOf(
            SmartAnalysis(message = "Your expenses are down 12% compared to last month."),
            SmartAnalysis(message = "Food & Drinks is your biggest category this month."),
            SmartAnalysis(message = "You can save ~800 EGP/week if you reduce takeout by 2 days.")
        ),
        transactions = listOf(
            Transaction(
                id = "tx_1001",
                title = "Salary",
                amount = 20000.0,
                isIncome = true,
                date = "2026-04-25",
                icon = "ic_salary"
            ),
            Transaction(
                id = "tx_1002",
                title = "Groceries",
                amount = 620.50,
                isIncome = false,
                date = "2026-04-25",
                icon = "ic_groceries"
            ),
            Transaction(
                id = "tx_1003",
                title = "Uber",
                amount = 95.0,
                isIncome = false,
                date = "2026-04-25",
                icon = "ic_transport"
            ),
            Transaction(
                id = "tx_1004",
                title = "Coffee",
                amount = 55.0,
                isIncome = false,
                date = "2026-04-24",
                icon = "ic_coffee"
            ),
            Transaction(
                id = "tx_1005",
                title = "Freelance Payment",
                amount = 2500.0,
                isIncome = true,
                date = "2026-04-23",
                icon = "ic_freelance"
            )
        )
    )

    // fake data
    suspend operator fun invoke(): HomeEntity {
        return fakeEntity
    }
}