package org.example.springlab.enums;

public enum StudentStatus {
    ACTIVE,
    VACATION;

    public String getStatus() {
        return this.name();
    }
}
