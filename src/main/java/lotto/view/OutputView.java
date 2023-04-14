package lotto.view;

import java.text.DecimalFormat;
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

    public static void printBuyingMessage(int money) {
        System.out.println();
        System.out.println(money + BUYING_MESSAGE);
    }

    public static void printLottos(List<List<Integer>> lottoTickets) {
        for (List<Integer> lotto : lottoTickets) {
            System.out.println(lotto);
        }
    }

    public static Map<LottoRanking, Integer> printResult(List<List<Integer>> lottoTickets, List<Integer> winNumber,
        int bonusNumber) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        LottoResult lottoResult = new LottoResult(lottoTickets, winNumber, bonusNumber);
        Map<LottoRanking,Integer> winMap = lottoResult.getWinMap();
        printResultDetails(winMap);
        return winMap;
    }

    private static void printResultDetails(Map<LottoRanking,Integer> winMap) {
        DecimalFormat df = new DecimalFormat("###,###");
        for (Map.Entry<LottoRanking, Integer> entry : winMap.entrySet()) {
            String temp = ", 보너스 볼 일치";
            if (!entry.getKey().isMatchBonus()) {
                temp = "";
            }
            System.out.println(
                entry.getKey().getWinNumber() + "개 일치" + temp + " (" + df.format(entry.getKey()
                    .getPrizeMoney()) + "원) - "
                    + entry.getValue() + "개");
        }
    }

    public static void printBenefit(int money, Map<LottoRanking,Integer> winMap) {
        long sum = 0;
        for (Map.Entry<LottoRanking, Integer> entry : winMap.entrySet()) {
            sum += entry.getKey().getPrizeMoney() * entry.getValue();
        }
        System.out.printf("총 수익률은 %.1f%%입니다.", (double) sum / money * 100);
    }

}
