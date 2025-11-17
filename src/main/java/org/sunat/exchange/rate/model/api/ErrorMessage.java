package org.sunat.exchange.rate.model.api;

import lombok.Data;

@Data
public class ErrorMessage {
    private String message;
    private Boolean status;

    public ErrorMessage(String message, Boolean status) {
        super();
        this.message = message;
        this.status = status;
    }

    public ErrorMessage() {
        super();
    }
}
