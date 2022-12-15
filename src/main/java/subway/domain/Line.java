package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private List<Station> sections = new ArrayList<>();

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
            sb.append(station.getName());
        }
        return sb.toString();
    }
}
