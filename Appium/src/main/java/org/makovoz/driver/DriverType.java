package org.makovoz.driver;

public enum DriverType {
    ANDROID("android"),
    IOS("ios");

    private final String name;

    DriverType(final String name) {
        this.name = name;
    }
}
