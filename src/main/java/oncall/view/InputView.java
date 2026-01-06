package oncall.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String MONTH_AND_START_DAY_INPUT_GUIDE = "비상 근무를 배정할 월과 시작 요일을 입력하세요>";

    public String readMonthAndStartDay(){
        System.out.print(MONTH_AND_START_DAY_INPUT_GUIDE);
        return readLine();
    }
}
