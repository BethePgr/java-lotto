package lotto.domain;

import java.util.List;

public class WinNumber {
    private final List<Integer> winNumber;

    public WinNumber(List<Integer> winNumber){
        this.winNumber = winNumber;
    }

    public List<Integer> getWinNumber(){
        return winNumber;
    }
}
