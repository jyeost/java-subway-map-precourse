package subway.view;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.domain.userInput.LineFunction;
import subway.domain.userInput.StationFunction;

import java.util.List;

public class OutputView implements Output {
    @Override
    public void printFunctions(String print) {
        System.out.println(print);
    }

    @Override
    public void printAllLinesAndStation(List<Line> lines) {
        System.out.println(System.lineSeparator() + "## 지하철 노선도");
        for (Line line : lines) {
            System.out.println("[INFO] " + line.getName() + System.lineSeparator() + "[INFO] ---");
            System.out.println(line.toString());
        }
    }

    @Override
    public StationFunction printAllStations() {
        if (StationRepository.stations().size() == 0) {
            System.out.println("[ERROR] 등록된 역이 존재하지 않습니다.");
            return StationFunction.INQUIRY;
        }
        System.out.println(StationRepository.printAllStations() + System.lineSeparator());
        return StationFunction.BACK;
    }

    @Override
    public LineFunction printAllLines() {
        if (LineRepository.lines().size() == 0) {
            System.out.println("[ERROR] 등록된 노선이 존재하지 않습니다.");
            return LineFunction.INQUIRY;
        }
        System.out.println(LineRepository.printAllLines() + System.lineSeparator());
        return LineFunction.BACK;
    }


}
