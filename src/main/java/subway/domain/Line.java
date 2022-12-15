package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final String name;
    private final List<Station> sections = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addSection(Station station) {
        if (station != null) {
            this.sections.add(station);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Station station : sections) {
            sb.append("[INFO] " + station.getName() + System.lineSeparator());
        }
        return sb.toString();
    }

}
