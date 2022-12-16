package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final String name;
    private final List<Station> sections = new ArrayList<>();
    private static final int LINE_NAME_MIN_LENGTH = 3;
    private static final String LINE_NAME_ERROR = "[ERROR] 노선 이름은 "+LINE_NAME_MIN_LENGTH +"글자 이상이어야 합니다.";

    public Line(String name) {
        if (name == null || name.trim().length() < LINE_NAME_MIN_LENGTH) {
            throw new IllegalArgumentException(LINE_NAME_ERROR);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addSection(Station station) {
        if (station == null) throw new IllegalArgumentException("[ERROR] 존재하지 않는 역 이름입니다.");
        if (sections.contains(station)) throw new IllegalArgumentException("[ERROR] 해당 노선에 이미 등록된 역입니다.");
        this.sections.add(station);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Station station : sections) {
            sb.append("[INFO] " + station.getName() + System.lineSeparator());
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        Line line = (Line) obj;
        return this.name.equals(line.name);
    }

}
