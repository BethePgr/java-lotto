package lotto.validation;

import java.util.Arrays;

public class WinNumberValidation {

    public static void validate(String str) {
        if (isDistinctSizeSix(str) && isSizeSix(str) && isNumberBetween1And45(str)) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 1~45사이의 숫자 6개,사이에 컴마만 사용가능하다.");
    }

    private static boolean isSizeSix(String str) {
        return (int) Arrays.stream(str.split(",")).count() == 6;
    }

    private static boolean isDistinctSizeSix(String str) {
        return (int) Arrays.stream(str.split(",")).distinct().count() == 6;
    }

    private static boolean isNumberBetween1And45(String str) {
        return Arrays.stream(str.split(",")).mapToInt(Integer::parseInt)
            .allMatch(num -> num >= 1 && num <= 45);
    }
}
