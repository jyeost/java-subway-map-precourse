package subway;

import subway.controller.MainController;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        new MainController(new InputView(scanner), new OutputView()).manageSubwayLines();
        scanner.close();
    }
}
