package dev.prototype.iamportal.infra.restservices;

import dev.prototype.iamportal.infra.restservices.kratos.KratosErrors;
import dev.prototype.iamportal.shared.exceptions.ExternalCallException;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

import static dev.prototype.iamportal.shared.errors.ErrorDetail.forError;

public class RestCallHandler<TResponse> {
    private final Call<TResponse> call;
    private static final int HTTP_CODE_NOT_FOUND = 404;
    private static final int HTTP_CODE_UNAUTHORIZED = 401;

    private boolean nullIfNotFound;

    private static final String EXTERNAL_CALL_CLIENT_ERROR_MSG = "External call - client error";
    private static final String EXTERNAL_CALL_SERER_ERROR_MSG = "External call - server error";

//    public CallbackHandler<TResponse>  unauthorized()

    public RestCallHandler<TResponse> nullIfNotFound() {
        nullIfNotFound = true;
        return this;
    }
    public RestCallHandler(Call<TResponse> call) {
        this.call = call;
        nullIfNotFound = false;
    }

    public TResponse handle() {
        try {
            Response<TResponse> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            }

            int responseCode = response.code();
            if (responseCode == HTTP_CODE_NOT_FOUND && nullIfNotFound) {
                return null;
            }

//            if (responseCode == 401) {}
            if (responseCode > 401 && responseCode < 500) {
                throw new ExternalCallException(EXTERNAL_CALL_CLIENT_ERROR_MSG, forError(KratosErrors.BadRequest));
            }

            throw new ExternalCallException(EXTERNAL_CALL_SERER_ERROR_MSG, forError(KratosErrors.ServerError));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
