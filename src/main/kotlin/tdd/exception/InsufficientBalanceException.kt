package tdd.exception

class InsufficientBalanceException(val amount: Double, val value: Double) : RuntimeException()
