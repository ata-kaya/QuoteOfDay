package com.atakaya.quoteofday.domain.usecase

abstract class UseCase<T> {
    abstract fun execute(): T
}

abstract class BaseUseCase {
    abstract fun execute()
}

abstract class ParameterizedSuspendUseCase<P> {
    abstract suspend fun exec(params: P)
}

abstract class ParameterizedUseCase<T, P> {
    abstract fun exec(params: P): T
}
