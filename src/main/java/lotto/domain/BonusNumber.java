package lotto.domain;

import java.util.List;
import lotto.validation.BonusNumberValidation;

public class BonusNumber {

    private final String bonusNumber;
    private static final String ERROR_MESSAGE = "[ERROR] 1과 45 사이의 숫자여야합니다.";

    public BonusNumber(String bonusNumber,List<Integer> winNumber){
        validateBonusNumber(bonusNumber,winNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(String number,List<Integer> winNumber){
        try{
            BonusNumberValidation.validate(number,winNumber);
        }catch (IllegalArgumentException e){
            System.out.println(ERROR_MESSAGE);
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
    public String getBonusNumber(){
        return bonusNumber;
    }
}
