package oncall.controller;

import oncall.controller.dto.MonthAndStartDayRequest;
import oncall.controller.dto.WorkerRequest;
import oncall.view.InputParser;
import oncall.view.InputView;
import oncall.view.OutputView;

public class OncallController {
    private final InputView inputView;
    private final InputParser inputParser;
    private final OutputView outputView;

    public OncallController(InputView inputView, InputParser inputParser, OutputView outputView) {
        this.inputView = inputView;
        this.inputParser = inputParser;
        this.outputView = outputView;
    }

    public void runApplication() {
        MonthAndStartDayRequest monthAndStartDayRequest = readMonthAndStartDay();
        WorkerRequest workerRequest = readWorkers();
    }

    private MonthAndStartDayRequest readMonthAndStartDay() {
        try {
            String monthAndStartDay = inputView.readMonthAndStartDay();
            return inputParser.parseMonthAndStartDay(monthAndStartDay);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return readMonthAndStartDay();
        }
    }

    private WorkerRequest readWorkers() {
        try {
            String weekdayWorkers = inputView.readWeekdayWorker();
            String holidayWorkers = inputView.readHolidayWorker();

            return inputParser.parseWorkers(weekdayWorkers, holidayWorkers);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return readWorkers();
        }
    }
}
