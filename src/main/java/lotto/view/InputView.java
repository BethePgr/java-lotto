package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String START_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String INPUT_WIN_MESSAGE = "당첨 번호를 입력해주세요.";
    private static final String INPUT_BONUS_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static String inputStartMoney() {
        System.out.println(START_MESSAGE);
        return Console.readLine();
    }

    public static String inputWinNumber() {
        System.out.println();
        System.out.println(INPUT_WIN_MESSAGE);
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println();
        System.out.println(INPUT_BONUS_MESSAGE);
        return Console.readLine();
    }

}
