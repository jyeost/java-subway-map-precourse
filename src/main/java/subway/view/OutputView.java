package subway.view;

import subway.domain.Line;
import subway.domain.userInput.Main;

import java.util.List;

public class OutputView implements Output {
    @Override
    public void printMain() {
        System.out.print("## 메인 화면");
        System.out.println(Main.print());
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
