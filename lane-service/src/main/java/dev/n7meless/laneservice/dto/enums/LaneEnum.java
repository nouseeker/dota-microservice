package dev.n7meless.laneservice.dto.enums;

public enum LaneEnum {
    MIDLANE("mid"), OFFLANE("off"), JUNGLE("jungle"), ROAMING("roaming");
    private final String lane;

    LaneEnum(String lane) {
        this.lane = lane;
    }

    public static LaneEnum fromLane(String lane) {
        for (LaneEnum e : LaneEnum.values()) {
            if (e.equals(lane)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return lane;
    }

    public boolean equals(String lane) {
        return this.toString().equals(lane);
    }

}
