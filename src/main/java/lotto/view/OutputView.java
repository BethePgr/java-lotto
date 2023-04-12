package lotto.view;

import java.util.Arrays;
import java.util.List;

public class OutputView {

    private static final String BUYING_MESSAGE = "개를 구매했습니다.";

    public static void printBuyingMessage(int money){
        System.out.println();
        System.out.println(money + BUYING_MESSAGE);
    }

    public static void printLottos(List<List<Integer>> lottoTickets){
        for(List<Integer> lotto : lottoTickets){
            System.out.println(lotto);
        }
    }

}
