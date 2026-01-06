package oncall.domain;

public enum Holiday {
    JANUARY_1ST("1", "1"),
    MARCH_1ST("3", "1"),
    MAY_5TH("5", "5"),
    JUNE_6TH("6", "6"),
    AUGUST_15TH("8", "15"),
    OCTOBER_3RD("10", "3"),
    OCTOBER_9TH("10", "9"),
    DECEMBER_25TH("12", "25");

    private final String month;
    private final String day;

    Holiday(String month, String day) {
        this.month = month;
        this.day = day;
    }
}
