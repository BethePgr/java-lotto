package lotto.validation;

import java.util.List;

public class BonusNumberValidation {

    public static void validate(String str, List<Integer> winNumber){
        if(isBetween1And45(str) && notInWinNumber(str,winNumber)){
            return;
        }
        throw new IllegalArgumentException("보너스 번호는 1과 45 사이면서 당첨번호가 아니여야합니다.");
    }

    private static boolean isBetween1And45(String str){
        int number = Integer.parseInt(str);
        return number>=1 && number<=45;
    }

    private static boolean notInWinNumber(String str, List<Integer> winNumber){
        return winNumber.stream().allMatch(num-> num != Integer.parseInt(str));
    }


}
