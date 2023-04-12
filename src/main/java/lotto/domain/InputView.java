package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String START_MESSAGE = "구입 금액을 입력해 주세요.";

    public String inputStartMessage(){
        System.out.println(START_MESSAGE);
        String money =  Console.readLine();
        return money;
    }

    public void checkMoneyAllValid(String money){
        if(divide1000NoRemains(money) && doNotStartWithZero(money) && overThan1000(money) && onlyNumber(money)){
            return;
        }
        throw new IllegalArgumentException("[ERROR] 1000의 배수인 숫자만 입력 가능합니다.");
    }


    //1000으로 나눌시 나머지가 0이 맞다면 true
    private boolean divide1000NoRemains(String money){
        return Integer.parseInt(money) % 1000 == 0;
    }

    //0으로 시작하지 않는게 맞다면 true
    private boolean doNotStartWithZero(String money){
        return money.charAt(0) - '0' != 0;
    }

    //1000보다 큰게 맞다면 true
    private boolean overThan1000(String money){
        return Integer.parseInt(money)>=1000;
    }

    //숫자만 있는게 맞다면 true
    private boolean onlyNumber(String money){
        String regExp = "^[0-9]+$";
        return money.matches(regExp);
    }



}
