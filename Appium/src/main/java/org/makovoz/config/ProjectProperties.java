package org.makovoz.config;

public final class ProjectProperties {
    private ProjectProperties() throws IllegalAccessException {
        throw new IllegalAccessException("Object should not be created");
    }

    public static final String PLATFORM = System.getProperty("platform", "ios");
    public static final String CAPABILITIES = System.getProperty("capabilities", "local");

}
