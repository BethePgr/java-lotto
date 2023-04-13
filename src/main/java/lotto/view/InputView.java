package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.StartMoneyValidation;
import lotto.validation.WinNumberValidation;

public class InputView {
    private static final String START_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String INPUT_WIN_MESSAGE = "당첨 번호를 입력해주세요.";


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

    public String inputWinNumber(){
        System.out.println(INPUT_WIN_MESSAGE);
        String number = Console.readLine();
        try{
            WinNumberValidation.validate(number);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            throw new IllegalArgumentException("[ERROR] 6자리의 수를,로 구별해서 작성해야 합니다.");
        }
        return number;
    }



}
