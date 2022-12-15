package subway.domain;

public class Station {
    private final String name;
    private static final int MIN_NAME_LENGTH = 3;
    private static final String STATION_ERROR_MSG = "[ERROR] 역 이름은 " + MIN_NAME_LENGTH + "이상이여야 합니다";

    public Station(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name == null || name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(STATION_ERROR_MSG);
        }
    }

    public String getName() {
        return name;
    }

    public boolean isEqualName(String stationName) {
        return this.name.equals(stationName);
    }

    @Override
    public boolean equals(Object obj) {
        Station station = (Station) obj;
        return this.name.equals(station.name);
    }
}
