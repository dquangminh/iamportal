package dev.prototype.iamportal.infra.restservices.kratos;

import dev.prototype.iamportal.core.abstractions.Error;

public class KratosErrors {
    public static Error BadRequest = new Error(
            50000,
            "Kratos.BadRequest",
            "Kratos BadRequest");
    public static Error ServerError = new Error(
            50001,
            "Kratos.ServerEror",
            "Kratos ServerError"
    );
}
