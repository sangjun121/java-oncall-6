package oncall.domain;

public class Month {
    private static final String[] DAYS = {"월", "화", "수", "목", "금", "토", "일"};

    private final String month;
    private final String endDate;
    private final String[] days;
    private final boolean[] isHoliday;

    public Month(String month, String startDay) {
        this.month = month;
        this.endDate = getEndDate(month);
        this.days = setDays(Integer.parseInt(endDate), startDay);

    }

    private String getEndDate(String month) {
        return Calendar.valueOf(month).getEndDate();
    }

    private String[] setDays(int endDate, String startDay) {
        String[] days = new String[endDate];
        int startDayIndex = findDayIndex(startDay);

        for (int i = 0; i < endDate; i++) {
            days[i] = DAYS[(startDayIndex + i) % 7];
        }

        return days;
    }

    private int findDayIndex(String startDay) {
        for (int i = 0; i < DAYS.length; i++) {
            if (DAYS[i].equals(startDay)) {
                return i;
            }
        }

        throw new IllegalArgumentException("ERROR: 올바르지 않은 요일입니다.");
    }
}
