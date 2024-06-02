package dev.prototype.iamportal.infra.restservices.kratos;

import dev.prototype.iamportal.infra.restservices.kratos.dto.IdentityPayload;
import dev.prototype.iamportal.infra.restservices.kratos.dto.IdentityResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.UUID;

public interface KratosApi {
    @GET("/admin/identities/{id}")
    Call<IdentityResponse> getIdentity(@Path("id") UUID id);

    @POST("/admin/identities")
    Call<Void> createIdentity(@Body IdentityPayload identity);
}
