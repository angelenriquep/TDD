package com.example.shared.domain;

import java.util.Objects;

public abstract class StringValueObject {
    private String value;

    public StringValueObject(String value) { this.value = value; }

    public String value() { return value; }

    @Override
    public String toString() { return value; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringValueObject that = (StringValueObject) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() { return Objects.hash(value); }
}
