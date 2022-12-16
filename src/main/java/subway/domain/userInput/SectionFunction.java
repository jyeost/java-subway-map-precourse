package subway.domain.userInput;

public enum SectionFunction {
    REGISTER("1", "구간 등록"),
    DELETE("2", "구간 삭제"),
    BACK("B", "돌아가기");

    private final static String FUNCTION_MSG = System.lineSeparator() + "## 구간 관리 화면";
    private final String key;
    private final String value;

    SectionFunction(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static String print() {
        StringBuilder sb = new StringBuilder(FUNCTION_MSG);
        for (SectionFunction sectionFunction : SectionFunction.values()) {
            sb.append(System.lineSeparator() + sectionFunction.key + ". " + sectionFunction.value);
        }
        return sb.toString();
    }

    public static SectionFunction validateUserChoice(String userInput) {
        for (SectionFunction sectionFunction : SectionFunction.values()) {
            if (sectionFunction.key.equals(userInput)) return sectionFunction;
        }
        throw new IllegalArgumentException(MainFunction.ERROR_MSG);
    }
}
