package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.validation.BonusNumberValidation;
import lotto.validation.StartMoneyValidation;
import lotto.validation.WinNumberValidation;

public class InputView {
    private static final String START_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String INPUT_WIN_MESSAGE = "당첨 번호를 입력해주세요.";
    private static final String INPUT_BONUS_MESSAGE = "보너스 번호를 입력해 주세요.";

    public String inputStartMoney(){
        System.out.println(START_MESSAGE);
        String money =  Console.readLine();
        try{
            StartMoneyValidation.checkMoneyAllValid(money);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            throw new IllegalArgumentException("[ERROR] 1000의 배수만 입력 가능합니다.");
        }
        return money;
    }

    public List<String> inputWinNumber(){
        System.out.println();
        System.out.println(INPUT_WIN_MESSAGE);
        String number = Console.readLine();
        try{
            WinNumberValidation.validate(number);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            throw new IllegalArgumentException("[ERROR] 6자리의 수를,로 구별해서 작성해야 합니다.");
        }
        return Arrays.stream(number.split(",")).collect(Collectors.toList());
    }

    public String inputBonusNumber(List<String> winNumber){
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
