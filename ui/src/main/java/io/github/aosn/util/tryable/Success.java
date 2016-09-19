package io.github.aosn.util.tryable;

import java.util.function.Consumer;
import java.util.function.Function;

public final class Success<T> implements Try<T> {
    private final T value;

    Success(T value) {
        this.value = value;
    }

    @Override
    public T get() {
        return value;
    }

    @Override
    public T orElseGet(T proxy) {
        return value;
    }

    @Override
    public T orElseThrow(Function<Throwable, RuntimeException> f) {
        return value;
    }

    @Override
    public boolean isSuccess() {
        return true;
    }

    @Override
    public <U> Try<U> map(Function<T, U> f) {
        return Try.succeeded(f.apply(value));
    }

    @Override
    public <U> Try<U> flatMap(Function<T, Try<U>> f) {
        return f.apply(value);
    }

    @Override
    public void forEach(Consumer<T> c) {
        c.accept(value);
    }

    @Override
    public Success<T> recover(Function<Throwable, T> f) {
        return this;
    }
}
