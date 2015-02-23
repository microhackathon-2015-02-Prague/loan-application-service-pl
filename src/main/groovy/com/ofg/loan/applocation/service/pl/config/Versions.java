package com.ofg.loan.applocation.service.pl.config;

public final class Versions {
    private Versions() {
        throw new UnsupportedOperationException("Can't instantiate a utility class");
    }

    public static final String APP_NAME = "com.ofg.loan-application-service-pl";
    public static final String VND_PREFIX = "application/vnd";
    public static final String JSON_TYPE_SUFFIX = "+json";

    public static final String VERSION_1 = "v1";
    public static final String LOAN_APPLICATION_SERVICE_JSON_VERSION_1 = VND_PREFIX + "." + APP_NAME + "." + VERSION_1 + JSON_TYPE_SUFFIX;
}

