package io.github.aosn.util.tryable;

import java.util.function.Consumer;
import java.util.function.Function;

public final class Failure<T> implements Try<T> {
    private final Throwable error;

    Failure(Throwable t) {
        this.error = t;
    }

    @Override
    public T get() {
        throw new UnsupportedOperationException("Failure doesn't have any value. This has a follow error: ", error);
    }

    @Override
    public T orElseGet(T proxy) {
        return proxy;
    }

    @Override
    public T orElseThrow(Function<Throwable, RuntimeException> f) {
        throw f.apply(error);
    }

    @Override
    public boolean isSuccess() {
        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <U> Try<U> map(Function<T, U> f) {
        return (Try<U>) this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <U> Try<U> flatMap(Function<T, Try<U>> f) {
        return (Try<U>) this;
    }

    @Override
    public void forEach(Consumer<T> c) {
    }

    @Override
    public Success<T> recover(Function<Throwable, T> f) {
        return Try.succeeded(f.apply(error));
    }

}
