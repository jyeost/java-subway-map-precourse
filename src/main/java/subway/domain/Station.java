package subway.domain;

public class Station {
    private final String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isEqualName(String stationName) {
        return this.name.equals(stationName);
    }
}
