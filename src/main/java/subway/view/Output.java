package subway.view;

import subway.domain.Line;
import subway.domain.userInput.StationFunction;

import java.util.List;

public interface Output {
    void printFunctions(String print);

    void printAllLines(List<Line> lines);

    StationFunction printAllStations();
}
