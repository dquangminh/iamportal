package dev.prototype.iamportal.infra.restservices.kratos;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.prototype.iamportal.infra.restservices.RestCallHandler;
import dev.prototype.iamportal.infra.restservices.kratos.dto.IdentityResponse;
import jakarta.annotation.Nullable;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.Optional;
import java.util.UUID;

@Component
public class KratosClientImpl implements KratosClient {
    static final String API_BASE_URL = "http://localhost:4434/";
    static final String JSON_CONTENT_TYPE = "application/json";

    private final KratosApi restApi;

    public KratosClientImpl(ObjectMapper objectMapper) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .build();

        this.restApi = retrofit.create(KratosApi.class);
    }

    @Override
    @Nullable
    public Optional<IdentityResponse> getIdentity(UUID id) {
        var response = new RestCallHandler<>(restApi.getIdentity(id))
                .nullIfNotFound()
                .handle();

        return Optional.ofNullable(response);
    }
}
