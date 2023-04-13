package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.validation.WinNumberValidation;

public class WinNumber {
    private final List<Integer> winNumber;
    private static final String ERROR_MESSAGE = "[ERROR] 6자리의 수를,로 구별해서 작성해야 합니다.";
    public WinNumber(String winNumber){
        validateWinNumber(winNumber);
        this.winNumber =  Arrays.stream(winNumber.split(",")).map(num->Integer.parseInt(num)).collect(Collectors.toList());;
    }

    private List<Integer> validateWinNumber(String number){
        try{
            WinNumberValidation.validate(number);
        }catch(IllegalArgumentException e){
            System.out.println(ERROR_MESSAGE);
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        return Arrays.stream(number.split(",")).map(num->Integer.parseInt(num)).collect(Collectors.toList());
    }


    public List<Integer> getWinNumber(){
        return winNumber;
    }
}
