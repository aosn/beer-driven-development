package io.github.aosn.util.tryable;

import java.util.function.Consumer;
import java.util.function.Function;

public interface Try<T> {
    T get();
    T orElseGet(T proxy);
    T orElseThrow(Function<Throwable, RuntimeException> f);
    boolean isSuccess();
    default boolean isFailure() {
        return !isSuccess();
    }
    <U> Try<U> map(Function<T, U> f);
    <U> Try<U> flatMap(Function<T, Try<U>> f);
    void forEach(Consumer<T> c);
    Success<T> recover(Function<Throwable, T> f);

    static <T> Try<T> to(Supplier<T> f) {
        try {
            return succeeded(f.get());
        } catch (Throwable t) {
            return failed(t);
        }
    }

    static <T> Success<T> succeeded(T value) {
        return new Success<>(value);
    }

    static <T> Failure<T> failed(Throwable error) {
        return new Failure<>(error);
    }
}
