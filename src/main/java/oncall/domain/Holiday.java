package oncall.domain;

import java.util.ArrayList;
import java.util.List;

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
    private final String date;

    Holiday(String month, String date) {
        this.month = month;
        this.date = date;
    }

    public static List<Integer> getDateByMonth(String target) {
        List<Integer> dates = new ArrayList<>();

        for (Holiday holiday : Holiday.values()) {
            if(holiday.month.equals(target)){
                dates.add(Integer.parseInt(holiday.date));
            }
        }

        return dates;
    }
}
