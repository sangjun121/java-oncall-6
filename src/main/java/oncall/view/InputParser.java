package oncall.view;

import java.util.Arrays;
import java.util.List;
import oncall.controller.dto.MonthAndStartDayRequest;
import oncall.controller.dto.WorkerRequest;
import oncall.util.Validator;

public class InputParser {
    private static final int MONTH_INDEX = 0;
    private static final int START_DAY_INDEX = 1;
    private static final int MIN_MONTH = 1;
    private static final int MAX_MONTH = 12;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_WORKER_COUNT = 5;
    private static final int MAX_WORKER_COUNT = 35;
    private static final List<String> VALID_DAY = List.of("월", "화", "수", "목", "금", "토", "일");

    public MonthAndStartDayRequest parseMonthAndStartDay(String input) {
        List<String> monthAndStartDay = Arrays.asList(input.split(","));
        String month = monthAndStartDay.get(MONTH_INDEX).trim();
        String startDay = monthAndStartDay.get(START_DAY_INDEX).trim();

        validateMonth(month);
        validateStartDay(startDay);

        return new MonthAndStartDayRequest(month, startDay);
    }

    public WorkerRequest parseWorkers(String weekdayInput, String holidayInput) {
        List<String> weekdayWorkers = Arrays.asList(weekdayInput.split(","));
        List<String> holidayWorkers = Arrays.asList(holidayInput.split(","));
        validateWorkerNames(weekdayWorkers);
        validateWorkerNames(holidayWorkers);
        return new WorkerRequest(weekdayWorkers, holidayWorkers);
    }

    private void validateMonth(String monthInput) {
        if (!Validator.isInRange(Integer.parseInt(monthInput), MIN_MONTH, MAX_MONTH)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }

    private void validateStartDay(String startDay) {
        if (!VALID_DAY.contains(startDay)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }

    private void validateWorkerNames(List<String> workerNames) {
        if (Validator.isDuplicated(workerNames)) {
            throw new IllegalArgumentException("[ERROR] 근무자 이름은 중복될 수 없습니다.");
        }

        if (!Validator.isInRange(workerNames.size(), MIN_WORKER_COUNT, MAX_WORKER_COUNT)) {
            throw new IllegalArgumentException("[ERROR] 근무자 인원은 최소 5명에서 최대 35명이어야 합니다.");
        }

        for (String name : workerNames) {
            if (!Validator.isLessOrEqualThan(name.length(), MAX_NAME_LENGTH)) {
                throw new IllegalArgumentException("[ERROR] 근무자 이름은 최대 5자여야 합니다.");
            }
        }
    }
}
