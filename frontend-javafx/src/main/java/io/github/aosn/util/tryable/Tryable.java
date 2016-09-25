package io.github.aosn.util.tryable;

public interface Tryable {
    default <T> Try<T> Try(Supplier<T> f) {
        return Try.to(f);
    }
    default <T> Try<T> Succeeded(T value) {
        return Try.succeeded(value);
    }
    default <T> Try<T> Failed(Throwable error) {
        return Try.failed(error);
    }
}
