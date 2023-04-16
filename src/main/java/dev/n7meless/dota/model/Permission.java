package dev.n7meless.dota.model;

public enum Permission {
    DEVELOPERS_READ("developers:read"),
    DEVELOPERS_WRITE("developers:write");

    public String getPermission() {
        return permission;
    }

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }
}
