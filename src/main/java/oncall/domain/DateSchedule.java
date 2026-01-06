package oncall.domain;

public class DateSchedule {
    private final String month;
    private final String date;
    private final String day;
    private final String worker;

    public DateSchedule(String month, String date, String day, String worker){
        this.month = month;
        this.date = date;
        this.day = day;
        this.worker = worker;
    }

    public String getMonth() {
        return month;
    }

    public String getDate() {
        return date;
    }

    public String getDay() {
        return day;
    }

    public String getWorker() {
        return worker;
    }
}
