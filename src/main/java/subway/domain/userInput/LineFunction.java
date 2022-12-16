package subway.domain.userInput;

public enum LineFunction {
    REGISTER("1", "노선 등록"),
    DELETE("2", "노선 삭제"),
    INQUIRY("3", "노선 조회"),
    BACK("B", "돌아가기");

    private final static String FUNCTION_MSG = System.lineSeparator() + "## 노선 관리 화면";
    private final String key;
    private final String value;

    LineFunction(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static String print() {
        StringBuilder sb = new StringBuilder(FUNCTION_MSG);
        for (LineFunction lineFunction : LineFunction.values()) {
            sb.append(System.lineSeparator() + lineFunction.key + ". " + lineFunction.value);
        }
        return sb.toString();
    }

    public static LineFunction validateUserChoice(String userInput) {
        for (LineFunction lineFunction : LineFunction.values()) {
            if (lineFunction.key.equals(userInput)) return lineFunction;
        }
        throw new IllegalArgumentException(MainFunction.ERROR_MSG);
    }
}
