package tdd.exception

class NotFoundException(val resource: String, val value: String) : RuntimeException()
