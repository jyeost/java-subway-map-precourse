package subway.view;

import subway.domain.userInput.Main;

public class OutputView implements Output {
    @Override
    public void printMain() {
        System.out.print("## 메인 화면");
        System.out.println(Main.print());
    }
}
