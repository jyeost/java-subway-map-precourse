package subway.domain.userInput;

public enum Main {
    STATION("1", "역 관리"),
    LINE("2", "노선 관리"),
    SECTION("3", "구간 관리"),
    PRINT_LINES("4", "지하철 노선도 출력"),
    QUIT("Q", "종료");

    private final String key;
    private final String value;

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
        throw new IllegalArgumentException(printErrorMsg());
    }

    private static String printErrorMsg() {
        String print = "[ERROR] 기능선택은 [";
        for (Main main : Main.values()) {
            print += main.key + ", ";
        }
        print = print.substring(0, print.length() - 2) + "] 를 정확하게 입력해주세요.";
        return print;
    }
}
