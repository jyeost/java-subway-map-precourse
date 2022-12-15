package subway;

import subway.controller.subwayController;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        new subwayController(new InputView(scanner), new OutputView()).manageSubwayLines();
        scanner.close();
    }
}
