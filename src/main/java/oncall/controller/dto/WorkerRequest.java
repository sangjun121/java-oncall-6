package oncall.controller.dto;

import java.util.ArrayList;
import java.util.List;
import oncall.util.Validator;

public final class WorkerRequest {
    private final List<String> weekdayWorkers;
    private final List<String> holidayWorkers;

    public WorkerRequest(List<String> weekdayWorkers, List<String> holidayWorkers) {
        List<String> trimedWeekdayWorkers = trim(weekdayWorkers);
        List<String> trimedHolidayWorkers = trim(holidayWorkers);
        validate(trimedWeekdayWorkers);
        validate(trimedHolidayWorkers);

        this.weekdayWorkers = trimedWeekdayWorkers;
        this.holidayWorkers = trimedHolidayWorkers;
    }

    public List<String> getHolidayWorkers() {
        return holidayWorkers;
    }

    public List<String> getWeekdayWorkers() {
        return weekdayWorkers;
    }

    private List<String> trim(List<String> workers) {
        List<String> trimedWorkers = new ArrayList<>();

        for (String worker : workers) {
            trimedWorkers.add(worker.trim());
        }

        return trimedWorkers;
    }

    private void validate(List<String> workers) {
        if(Validator.isDuplicated(workers)){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }
}
