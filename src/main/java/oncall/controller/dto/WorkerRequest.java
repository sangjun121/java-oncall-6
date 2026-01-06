package oncall.controller.dto;

import java.util.List;

public record WorkerRequest(List<String> weekdayWorkers, List<String> holidayWorkers) {
}
