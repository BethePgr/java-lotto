package lotto.view;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.LottoRanking;
import lotto.domain.LottoResult;

public class OutputView {

    private static final String BUYING_MESSAGE = "개를 구매했습니다.";
    private Map<LottoRanking,Integer> winMap = new EnumMap<>(LottoRanking.class);

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
        LottoResult lottoResult = new LottoResult(lottoTickets,winNumber,bonusNumber);
        winMap = lottoResult.getWinMap();
        printResultDetails();
    }

    private void printResultDetails() {
        for (Map.Entry<LottoRanking, Integer> entry : winMap.entrySet()) {
            if (entry.getKey().getWinNumber() == 0) {
                continue;
            }
            String temp = ", 보너스 볼 일치";
            if (!entry.getKey().isMatchBonus()) {
                temp = "";
            }
            System.out.println(
                entry.getKey().getWinNumber() + "개 일치" + temp + " (" + entry.getKey()
                    .getPrizeMoney() + "원) - "
                    + entry.getValue() + "개");
        }
    }

    public void printBenefit(int money){
        long sum = 0;
        sum += winMap.get("six") * 2000000000;
        sum += winMap.get("fiveBonus") * 30000000;
        sum += winMap.get("five") * 1500000;
        sum += winMap.get("four") * 50000;
        sum += winMap.get("three") * 5000;
        System.out.printf("총 수익률은 %.1f %%입니다",(double)sum/money * 100);
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>(){{
            put("one",1);
            put("two",2);
            put("three",3);
        }};

        for(Map.Entry<String,Integer> entry : map.entrySet()){
            System.out.println(entry.getValue() + entry.getKey());
        }
    }

}
