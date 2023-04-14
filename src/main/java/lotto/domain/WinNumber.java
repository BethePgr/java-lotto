package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.validation.WinNumberValidation;

public class WinNumber {

    private final List<Integer> winNumber;

    public WinNumber(String winNumber) {
        validateWinNumber(winNumber);
        this.winNumber = Arrays.stream(winNumber.split(",")).map(num -> Integer.parseInt(num))
            .collect(Collectors.toList());

    }

    private List<Integer> validateWinNumber(String number) {
        WinNumberValidation.validate(number);
        return Arrays.stream(number.split(",")).map(num -> Integer.parseInt(num))
            .collect(Collectors.toList());
    }

    public List<Integer> getWinNumber() {
        return winNumber;
    }
}
