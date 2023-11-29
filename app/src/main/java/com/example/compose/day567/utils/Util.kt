package com.example.compose.day567.utils

fun calculateTipAmount(totalBillAmount: Double, tipPercentage: Int): Double {
    return if (totalBillAmount > 1 && totalBillAmount.toString()
            .isNotEmpty()
    ) (totalBillAmount * tipPercentage) / 100 else 0.0
}

fun calculateTotalPerPerson(totalBill: Double, splitBy: Int, tipPercentage: Int): Double {
    val bill = calculateTipAmount(totalBill, tipPercentage) + totalBill
    return (bill / splitBy)
}