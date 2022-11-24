package org.makovoz.driver;

import io.github.bonigarcia.wdm.config.DriverManagerType;

public final class DriverManagerFactory {
    private DriverManagerFactory() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    public static DriverManager getManager(DriverManagerType type) {

        return switch (type) {
            case CHROME -> new ChromeDriverManager();
            default -> throw new IllegalArgumentException(type.toString().concat(" is not supported"));
        };

    }
}
