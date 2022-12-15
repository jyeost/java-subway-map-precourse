package subway.domain.userInput;

public enum StationFunction {
    REGISTER("1", "역 등록"),
    DELETE("2", "역 삭제"),
    INQUIRY("3", "역 조회"),
    BACK("B", "돌아가기");

    private final static String FUNCTION_MSG = System.lineSeparator() + "## 역 관리 화면";
    private final String key;
    private final String value;

    StationFunction(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static String print() {
        StringBuilder sb = new StringBuilder(FUNCTION_MSG);
        for (StationFunction stationFunction : StationFunction.values()) {
            sb.append(System.lineSeparator() + stationFunction.key + ". " + stationFunction.value);
        }
        return sb.toString();
    }

    public static StationFunction validateUserChoice(String userInput) {
        for (StationFunction stationFunction : StationFunction.values()) {
            if (stationFunction.key.equals(userInput)) return stationFunction;
        }
        throw new IllegalArgumentException(MainFunction.ERROR_MSG);
    }
}
