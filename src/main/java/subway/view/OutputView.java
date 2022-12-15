package subway.view;

import subway.domain.Line;

import java.util.List;

public class OutputView implements Output {
    @Override
    public void printFunctions(String print) {
        System.out.println(print);
    }

    @Override
    public void printAllLines(List<Line> lines) {
        System.out.println(System.lineSeparator() + "## 지하철 노선도");
        for (Line line : lines) {
            System.out.println("[INFO] " + line.getName() + System.lineSeparator() + "[INFO] ---");
            System.out.println(line.toString());
        }
    }


}
