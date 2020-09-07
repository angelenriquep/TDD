package com.example.shared.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class Identifier implements Serializable {
    private String value;

    public Identifier(String value) {
        ensureValidUuid(value);

        this.value = value;
    }

    // No exponemos el Uuid, para no transformar el to string
    // Si cambiamos la implementacion de como generamos los identificadores, como
    // lo que nos llega es un string y lo que sacamos tambien no forzamos al cliente
    // a cambiar su sistema.
    public String value() { return value; }

    private void ensureValidUuid(String value) { UUID.fromString(value); }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Identifier that = (Identifier) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
