package lotto.domain;

import java.util.List;
import lotto.validation.BonusNumberValidation;

public class BonusNumber {

    private final String bonusNumber;


    public BonusNumber(String bonusNumber, List<Integer> winNumber) {
        validateBonusNumber(bonusNumber, winNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(String number, List<Integer> winNumber)
        throws IllegalArgumentException {
        BonusNumberValidation.validate(number, winNumber);
    }

    public String getBonusNumber() {
        return bonusNumber;
    }
}
