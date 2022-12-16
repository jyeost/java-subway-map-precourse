package subway.view;

import subway.domain.Line;
import subway.domain.userInput.LineFunction;
import subway.domain.userInput.StationFunction;

import java.util.List;

public interface Output {
    void printFunctions(String print);

    void printAllLinesAndStation(List<Line> lines);

    StationFunction printAllStations();

    LineFunction printAllLines();
}
