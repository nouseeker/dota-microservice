package dev.n7meless.economyservice.enums;

public enum DateEnum {
    THIS_WEEK("week"), THIS_MONTH("month"), LAST_3_MONTH("3month"), LAST_6_MONTH("6month"), LAST_12_MONTH("year");
    private String date;

    DateEnum(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return date;
    }

    public boolean equals(String name) {
        return this.toString().equals(name);
    }

    public static boolean fromDate(String date) {
        for (DateEnum dateEnum : DateEnum.values()) {
            if (dateEnum.equals(date)) {
                return true;
            }
        }
        return false;
    }
}
