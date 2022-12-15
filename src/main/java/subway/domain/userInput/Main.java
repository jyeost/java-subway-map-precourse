package subway.domain.userInput;

public enum Main {
    STATION("1", "역 관리"),
    LINE("2", "노선 관리"),
    SECTION("3", "구간 관리"),
    PRINT_LINES("4", "지하철 노선도 출력"),
    QUIT("Q", "종료");

    private final String key;
    private final String value;
    private final static String mainErrorMsg = "[ERROR] 선택할 수 없는 기능입니다.";

    Main(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static String print() {
        StringBuilder sb = new StringBuilder();
        for (Main main : Main.values()) {
            sb.append(System.lineSeparator() + main.key + ". " + main.value);
        }
        return sb.toString();
    }


    public static Main validateUserChoice(String userInput) {
        for (Main main : Main.values()) {
            if (main.key.equals(userInput)) return main;
        }
        throw new IllegalArgumentException(mainErrorMsg);
    }


}
