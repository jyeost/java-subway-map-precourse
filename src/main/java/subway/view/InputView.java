package subway.view;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.userInput.LineFunction;
import subway.domain.userInput.MainFunction;
import subway.domain.userInput.StationFunction;

import java.util.Scanner;

public class InputView implements Input {
    private static final String CHOOSE_FUNCTION_MSG = System.lineSeparator() + "## 원하는 기능을 선택하세요.";
    final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public MainFunction getMainChoice() {
        System.out.println(CHOOSE_FUNCTION_MSG);
        try {
            return MainFunction.validateUserChoice(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getMainChoice();
        }
    }

    @Override
    public StationFunction getStationFunctionChoice() {
        System.out.println(CHOOSE_FUNCTION_MSG);
        try {
            return StationFunction.validateUserChoice(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getStationFunctionChoice();
        }
    }

    @Override
    public StationFunction registerStation() {
        try {
            System.out.println(System.lineSeparator() + "## 등록할 역 이름을 입력하세요.");
            StationRepository.addStation(new Station(scanner.nextLine()));
            System.out.println("[INFO] 지하철 역이 등록되었습니다." + System.lineSeparator());
            return StationFunction.BACK;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return StationFunction.REGISTER;
        }
    }

    @Override
    public StationFunction deleteStation() {
        System.out.println(System.lineSeparator() + "## 삭제할 역 이름을 입력하세요.");
        if(StationRepository.deleteStation(scanner.nextLine())){
            System.out.println("[INFO] 지하철 역이 삭제되었습니다." + System.lineSeparator());
            return StationFunction.BACK;
        }
        System.out.println("[ERROR] 해당하는 역 이름이 없습니다.");
        return StationFunction.DELETE;
    }

    @Override
    public LineFunction getLineFunctionChoice() {
        System.out.println(CHOOSE_FUNCTION_MSG);
        try {
            return LineFunction.validateUserChoice(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getLineFunctionChoice();
        }
    }

    @Override
    public LineFunction registerLine() {
        try {
            System.out.println(System.lineSeparator() + "## 노선 이름을 입력하세요.");
            getLineInfo();
            System.out.println("[INFO] 지하철 역이 등록되었습니다." + System.lineSeparator());
            return LineFunction.BACK;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return LineFunction.REGISTER;
        }
    }

    private void getLineInfo() {
        String userInputLineName = scanner.nextLine();
        if (LineRepository.isExistName(userInputLineName)) throw new IllegalArgumentException("이미 존재하는 노선 이름 입니다.");
        Line line = new Line(userInputLineName);
        System.out.println(System.lineSeparator() + "## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        line.addSection(StationRepository.getStation(scanner.nextLine()));
        System.out.println(System.lineSeparator() + "## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        line.addSection(StationRepository.getStation(scanner.nextLine()));
        LineRepository.addLine(line);
    }

    @Override
    public LineFunction deleteLine() {
        System.out.println(System.lineSeparator() + "## 삭제할 노선 이름을 입력하세요.");
        if (LineRepository.deleteLineByName(scanner.nextLine())) {
            System.out.println("[INFO] 지하철 노선이 삭제되었습니다." + System.lineSeparator());
            return LineFunction.BACK;
        }
        System.out.println("[ERROR] 해당하는 노선 이름이 없습니다.");
        return LineFunction.DELETE;

    }
}
