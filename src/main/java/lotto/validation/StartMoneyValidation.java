package lotto.validation;

public class StartMoneyValidation {


    public static void checkMoneyAllValid(String money) throws IllegalArgumentException {
        if (onlyNumber(money) && divide1000NoRemains(money) && doNotStartWithZero(money)
            && overThan1000(money)) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 1000이상의 배수가 입력되어야 합니다.");
    }

    private static boolean divide1000NoRemains(String money) {
        return Integer.parseInt(money) % 1000 == 0;
    }

    private static boolean doNotStartWithZero(String money) {
        return money.charAt(0) - '0' != 0;
    }

    private static boolean overThan1000(String money) {
        return Integer.parseInt(money) >= 1000;
    }

    private static boolean onlyNumber(String money) {
        String regExp = "^[0-9]+$";
        return money.matches(regExp);
    }

}
