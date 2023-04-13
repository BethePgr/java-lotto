package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Money;
import lotto.domain.WinNumber;
import lotto.validation.BonusNumberValidation;
import lotto.validation.StartMoneyValidation;
import lotto.validation.WinNumberValidation;

public class InputView {
    private static final String START_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String INPUT_WIN_MESSAGE = "당첨 번호를 입력해주세요.";
    private static final String INPUT_BONUS_MESSAGE = "보너스 번호를 입력해 주세요.";

    public String inputStartMoney(){
        System.out.println(START_MESSAGE);
         Money moneys = new Money(Console.readLine());
         String money = moneys.getMoney();
        return money;
    }

    public String inputWinNumber(){
        System.out.println();
        System.out.println(INPUT_WIN_MESSAGE);
        return Console.readLine();
    }

    public String inputBonusNumber(List<Integer> winNumber){
        System.out.println();
        System.out.println(INPUT_BONUS_MESSAGE);
        String number = Console.readLine();
        try{
            BonusNumberValidation.validate(number,winNumber);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            throw new IllegalArgumentException("[ERROR] 1과 45 사이의 숫자여야합니다.");
        }
        return number;
    }

}
