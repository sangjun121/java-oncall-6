package oncall.config;

import oncall.controller.OncallController;
import oncall.view.InputParser;
import oncall.view.InputView;
import oncall.view.OutputView;

public class AppConfig {
    private static final AppConfig INSTANCE = new AppConfig();

    private AppConfig() {
    }

    public static AppConfig getInstance() {
        return INSTANCE;
    }

    public InputView inputView() {
        return new InputView();
    }

    public InputParser inputParser() {
        return new InputParser();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public OncallController oncallController() {
        return new OncallController(inputView(), inputParser(), outputView());
    }
}
