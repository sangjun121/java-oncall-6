package oncall.util;

public class Validator {
    public static boolean isInRange(int target, int min, int max) {
        return target >= min && target <= max;
    }
}
