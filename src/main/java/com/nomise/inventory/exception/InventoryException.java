package com.nomise.inventory.exception;

public enum InventoryException {

    INTERNAL_SERVER_ERROR(new RuntimeException("Internal Server Error")),
    BAD_REQUEST(new RuntimeException("Bad Request")),
    NOT_FOUND(new RuntimeException("Not Found")),;

    private final RuntimeException exception;

    InventoryException(RuntimeException ex){
        this.exception = ex;
    }

    public Exception getException(){
        return this.exception;
    }
}
