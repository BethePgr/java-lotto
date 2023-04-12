package lotto.view;

public class OutputView {

    private static final String BUYING_MESSAGE = "개를 구매했습니다.";

    public static void printBuyingMessage(int money){
        System.out.println(money + BUYING_MESSAGE);
    }

}
