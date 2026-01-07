package oncall.application;

import java.util.List;
import oncall.controller.dto.MonthAndStartDayRequest;
import oncall.controller.dto.Result;
import oncall.controller.dto.WorkerRequest;
import oncall.domain.Month;

public class OncallService {
    public Result runOncall(MonthAndStartDayRequest monthAndStartDayRequest, WorkerRequest workerRequest) {
        Month month = setMonthInformation(monthAndStartDayRequest.month(), monthAndStartDayRequest.day());
        String[] dates = assignSchedule(month, workerRequest);
        return new Result(month.getMonth(), month.getDays(), checkSchedule(dates, month.getIsHoliday()),
                month.getIsHoliday());
    }

    private Month setMonthInformation(String month, String startDay) {
        return new Month(month, startDay);
    }

    private String[] assignSchedule(Month month, WorkerRequest workerRequest) {
        String[] dates = new String[Integer.parseInt(month.getEndDate())];
        dates = assignWeekdaySchedule(dates, workerRequest.getWeekdayWorkers(), month.getIsHoliday());
        dates = assignHolidaySchedule(dates, workerRequest.getHolidayWorkers(), month.getIsHoliday());

        return dates;
    }

    private String[] checkSchedule(String[] dates, boolean[] isHoliday) {
        for (int i = 0; i < dates.length - 1; i++) {
            if (dates[i].equals(dates[i + 1]) && isHoliday[i + 1]) {
                for (int j = i + 2; j < dates.length; j++) {
                    if (isHoliday[j]) {
                        String tmp = dates[j];
                        dates[j] = dates[i + 1];
                        dates[i + 1] = tmp;
                        i = 0;
                        break;
                    }
                }
            }

            if (dates[i].equals(dates[i + 1]) && !isHoliday[i + 1]) {
                for (int j = i + 2; j < dates.length; j++) {
                    if (!isHoliday[j]) {
                        String tmp = dates[j];
                        dates[j] = dates[i + 1];
                        dates[i + 1] = tmp;
                        i = 0;
                        break;
                    }
                }
            }
        }
        return dates;
    }

    private String[] assignWeekdaySchedule(String[] dates, List<String> weekdayWorkers, boolean[] isHoliday) {
        int workerIndex = 0;

        for (int i = 0; i < dates.length; i++) {
            if (isHoliday[i] == false) {
                dates[i] = weekdayWorkers.get(workerIndex % weekdayWorkers.size());
                workerIndex++;
            }
        }

        return dates;
    }

    private String[] assignHolidaySchedule(String[] dates, List<String> holidayWorkers, boolean[] isHoliday) {
        int workerIndex = 0;

        for (int i = 0; i < dates.length; i++) {
            if (isHoliday[i] == true) {
                dates[i] = holidayWorkers.get(workerIndex % holidayWorkers.size());
                workerIndex++;
            }
        }

        return dates;
    }
}
