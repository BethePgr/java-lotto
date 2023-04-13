package lotto.domain;

import lotto.validation.StartMoneyValidation;

public class Money {

    private final String money;
    private static final String ERROR_MESSAGE = "[ERROR] 1000이상의 배수만 입력 가능합니다.";

    public Money(String money){
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(String money){
        try{
            StartMoneyValidation.checkMoneyAllValid(money);
        }catch(IllegalArgumentException e){
            System.out.println(ERROR_MESSAGE);
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public String getMoney(){
        return money;
    }
}
