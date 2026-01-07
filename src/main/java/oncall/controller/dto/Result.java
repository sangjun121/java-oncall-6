package oncall.controller.dto;

public record Result(String month, String[] days, String[] schedules, boolean[] isHoliday) {
}
