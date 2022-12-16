package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static boolean isExistName(String name) {
        return lines.stream().anyMatch(line -> Objects.equals(line.getName(), name));
    }

    public static String printAllLines() {
        StringBuilder sb = new StringBuilder(System.lineSeparator() + "## 노선 목록");
        for (Line line : lines) {
            sb.append(System.lineSeparator()).append("[INFO] ").append(line.getName());
        }
        return sb.toString();
    }

}
