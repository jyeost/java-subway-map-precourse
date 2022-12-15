package subway.view;

import subway.domain.userInput.Main;

import java.util.Scanner;

public class InputView implements Input {
    final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Main getMainChoice() {
        System.out.println(System.lineSeparator() + "## 원하는 기능을 선택하세요.");
        try {
             return Main.validateUserChoice(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getMainChoice();
        }
    }
}
