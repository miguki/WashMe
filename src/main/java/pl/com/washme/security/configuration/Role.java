package pl.com.washme.security.configuration;

public enum Role {

    ADMIN, USER;

    private static final String ROLE_PREFIX = "ROLE_";

    public String nameWithPrefix() {
        return ROLE_PREFIX + name();
    }

}
