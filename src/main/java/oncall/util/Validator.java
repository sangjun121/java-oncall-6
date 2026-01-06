package oncall.util;

import java.util.HashSet;
import java.util.List;

public class Validator {
    public static boolean isInRange(int target, int min, int max) {
        return target >= min && target <= max;
    }

    public static boolean isDuplicated(List<String> target) {
        return new HashSet<>(target).size() != target.size();
    }
}
