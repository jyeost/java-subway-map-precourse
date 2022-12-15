package subway.domain.userInput;

public enum MainFunction {
    STATION("1", "역 관리"),
    LINE("2", "노선 관리"),
    SECTION("3", "구간 관리"),
    PRINT_LINES("4", "지하철 노선도 출력"),
    QUIT("Q", "종료");

    private final String key;
    private final String value;
    public final static String ERROR_MSG = "[ERROR] 선택할 수 없는 기능입니다.";
    private final static String FUNCTION_MSG = "## 메인 화면";

    MainFunction(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static String print() {
        StringBuilder sb = new StringBuilder(FUNCTION_MSG);
        for (MainFunction mainFunction : MainFunction.values()) {
            sb.append(System.lineSeparator() + mainFunction.key + ". " + mainFunction.value);
        }
        return sb.toString();
    }


    public static MainFunction validateUserChoice(String userInput) {
        for (MainFunction mainFunction : MainFunction.values()) {
            if (mainFunction.key.equals(userInput)) return mainFunction;
        }
        throw new IllegalArgumentException(ERROR_MSG);
    }


}
