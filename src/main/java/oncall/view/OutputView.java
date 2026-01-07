package oncall.view;

import oncall.controller.dto.Result;

public class OutputView {
    private static final String RESULT_FORMAT = "%s월 %s일 %s %s\n";

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printResult(Result result) {
        for (int i = 0; i < result.schedules().length; i++) {
            System.out.printf(RESULT_FORMAT, result.month(), i + 1, result.days()[i], result.schedules()[i]);
        }
    }
}
