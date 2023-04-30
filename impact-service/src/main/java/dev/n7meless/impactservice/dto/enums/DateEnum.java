package dev.n7meless.impactservice.dto.enums;

public enum DateEnum {
    ALLTIME("all"), WEEK("week"), MONTH("month"), THREEMONTHS("3month"), SIXMONTHS("6month"), YEAR("year");
    private final String date;

    DateEnum(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return date;
    }

    public boolean equals(String date) {
        return this.toString().equals(date);
    }

    public static boolean fromDate(String date) {
        for (DateEnum d : DateEnum.values()) {
            if (d.equals(date)) {
                return true;
            }
        }
        return false;
    }
}
