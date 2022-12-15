package subway.view;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.userInput.MainFunction;
import subway.domain.userInput.StationFunction;

import java.util.Scanner;

public class InputView implements Input {
    final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public MainFunction getMainChoice() {
        System.out.println(System.lineSeparator() + "## 원하는 기능을 선택하세요.");
        try {
            return MainFunction.validateUserChoice(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getMainChoice();
        }
    }

    @Override
    public StationFunction getStationFunctionChoice() {
        System.out.println(System.lineSeparator() + "## 원하는 기능을 선택하세요.");
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
}
