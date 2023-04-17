package com.example.LocalMarketplace.utils;

import com.example.LocalMarketplace.dto.GenericResponse;

public abstract class NetworkingRunnable implements Runnable{

    protected GenericResponse genericResponse;

    protected Exception exception;

    public NetworkingRunnable() {
    }

    public GenericResponse getGenericResponse() {
        return genericResponse;
    }

    public Exception getException() {
        return exception;
    }
}
