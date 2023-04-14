package lotto.validation;

public class StartMoneyValidation {



    public static void checkMoneyAllValid (String money) throws IllegalArgumentException{
        if(onlyNumber(money) && divide1000NoRemains(money) && doNotStartWithZero(money) && overThan1000(money) ){
            return;
        }
        throw new IllegalArgumentException();
    }


    //1000으로 나눌시 나머지가 0이 맞다면 true
    private static boolean divide1000NoRemains(String money){
        return Integer.parseInt(money) % 1000 == 0;
    }

    //0으로 시작하지 않는게 맞다면 true
    private static boolean doNotStartWithZero(String money){
        return money.charAt(0) - '0' != 0;
    }

    //1000보다 큰게 맞다면 true
    private static boolean overThan1000(String money){
        return Integer.parseInt(money)>=1000;
    }

    //숫자만 있는게 맞다면 true
    private static boolean onlyNumber(String money){
        String regExp = "^[0-9]+$";
        return money.matches(regExp);
    }

}
