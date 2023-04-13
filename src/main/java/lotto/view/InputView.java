package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.StartMoneyValidation;

public class InputView {
    private static final String START_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String BUYING_MESSAGE = "개를 구매했습니다.";


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

}
