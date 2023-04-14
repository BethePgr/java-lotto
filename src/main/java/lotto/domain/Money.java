package lotto.domain;

import lotto.validation.StartMoneyValidation;

public class Money {

    private final String money;

    public Money(String money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(String money) throws IllegalArgumentException {
        StartMoneyValidation.checkMoneyAllValid(money);
    }

    public String getMoney() {
        return money;
    }
}
