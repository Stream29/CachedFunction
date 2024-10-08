package indi.stream

fun <T : Any, R : Any> ((T) -> R).cached(containerProvider: () -> MutableMap<T, R>): ((T) -> R) =
    cached(containerProvider())

fun <T : Any, R : Any> ((T) -> R).cached(container: MutableMap<T, R>): ((T) -> R) =
    { arg: T -> container.getOrPut(arg) { this(arg) } }