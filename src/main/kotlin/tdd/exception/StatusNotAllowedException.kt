package tdd.exception

class StatusNotAllowedException(val operation: String, val status: String) : RuntimeException()
