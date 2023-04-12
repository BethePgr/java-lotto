package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.StartMoneyValidation;

public class InputView {
    private static final String START_MESSAGE = "구입 금액을 입력해 주세요.";

    public String inputStartMoney(){
        System.out.println(START_MESSAGE);
        String money =  Console.readLine();
        try{
            StartMoneyValidation.checkMoneyAllValid(money);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return money;
    }

}
