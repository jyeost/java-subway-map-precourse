package subway.view;

import subway.domain.Line;

import java.util.List;

public interface Output {
    void printMain();

    void printAllLines(List<Line> lines);
}
