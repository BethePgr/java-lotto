package lotto.view;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import lotto.domain.LottoResult;

public class OutputView {

    private static final String BUYING_MESSAGE = "개를 구매했습니다.";
    private HashMap<String,Integer> winMap = new HashMap<>();

    public static void printBuyingMessage(int money){
        System.out.println();
        System.out.println(money + BUYING_MESSAGE);
    }

    public static void printLottos(List<List<Integer>> lottoTickets){
        for(List<Integer> lotto : lottoTickets){
            System.out.println(lotto);
        }
    }

    public void printResult(List<List<Integer>> lottoTickets,List<Integer> winNumber, int bonusNumber){
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        LottoResult lottoResult = new LottoResult(lottoTickets, winNumber, bonusNumber);
        winMap = lottoResult.getWinMap();
        System.out.println("3개 일치 (5,000원) - "+winMap.get("three")+"개");
        System.out.println("4개 일치 (50,000원) - "+winMap.get("four")+"개");
        System.out.println("5개 일치 (1,500,000원) - "+winMap.get("five")+"개");
        System.out.println("5개 일치,보너스 볼 일치 (30,000,000원) - "+winMap.get("fiveBonus")+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+winMap.get("six")+"개");
    }

    public void printBenefit(int money){
        System.out.println();
        long sum = 0;
        sum += winMap.get("six") * 2000000000;
        sum += winMap.get("fiveBonus") * 30000000;
        sum += winMap.get("five") * 1500000;
        sum += winMap.get("four") * 50000;
        sum += winMap.get("three") * 5000;
        System.out.printf("총 수익률은 %.1f %입니다",(double)sum/money * 100);
    }

}
