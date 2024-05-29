package dev.prototype.iamportal.core.abstractions;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.util.Objects.requireNonNull;

public class Result<TValue>
{
    protected static final Result<Void> SUCCESS_VOID = new Result<>(true, null, Error.NONE);
    public Result(boolean isSuccess, TValue _value, Error error)
    {
        this.isSuccess = isSuccess;
        this.value = _value;
        this.error = error;
    }

    private final boolean isSuccess;
    private final TValue value;
    private boolean isFailure;
    private final Error error;


    public boolean isFailure() {
        return !isSuccess;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public static <TValue> Result<TValue> success(TValue _value) {
        return new Result<>(true, _value, Error.NONE);
    }

    /**
     * Constructs a result object for a succeeded operation with not critical error
     *
     * @param _value An object that is the result of an operation.
     * @param warning The warning (non-critical error) that occurred during an operation
     *
     * @return Success result with a wrapped object and error
     */
    public static <TValue> Result<TValue> success(TValue _value, Error warning) {
        return new Result<>(true, _value, warning);
    }

    public static Result<Void> success() {
        return SUCCESS_VOID;
    }

    public static Result<Void> success(Error warning) {
        return new Result<>(true, null, warning);
    }

    public static <TValue> Result<TValue> failure(Error error) {
        return new Result<>(false, null, error);
    }

    public Error getWarning() {
        return getError();
    }

    public Error getError() {
        return error;
    }

    /**
     * Performs an action if the current result is success;
     *
     * @param action An action to execute.
     *
     * @return A result of the executed action, or the current result if it failed.
     */
    public Result<TValue> ifSuccess(Supplier<Result<TValue>> action) {
        requireNonNull(action);
        if (isSuccess()) {
            return action.get();
        }
        return this;
    }

    /**
     * Performs an action if the current result is success;
     *
     * @param action An action to execute.
     */
    public void ifSuccess(Consumer<Result<TValue>> action) {
        requireNonNull(action);
        if (isSuccess()) {
            action.accept(this);
        }
    }

    /**
     * Performs a function if the current result is success producing a new result.
     *
     * @param function A function to apply.
     */
    public Result<TValue> ifSuccessApply(Function<Result<TValue>, Result<TValue>> function) {
        requireNonNull(function);
        if (isSuccess()) {
            return function.apply(this);
        }
        return this;
    }

    public Result<TValue> ifFailure(Consumer<Result<TValue>> action) {
        requireNonNull(action);
        if (isFailure()) {
            action.accept(this);
        }
        return this;
    }

    public TValue getValueOrElse(TValue other) {
        return value == null ? other : value;
    }

    public Optional<TValue> getValue() {
        return Optional.ofNullable(value);
    }

    public TValue getNonNullValue() {
        requireNonNull(value);

        return value;
    }
}

