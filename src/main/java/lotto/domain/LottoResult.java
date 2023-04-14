package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LottoResult {

    private final List<List<Integer>> lottoTickets;
    private final List<Integer> winNumber;
    private final Integer bonusNumber;

    private final Map<LottoRanking, Integer> winMap = new EnumMap<>(LottoRanking.class);

    public LottoResult(List<List<Integer>> lottoTickets, List<Integer> winNumber, int bonusNumber) {
        settingWinMap();
        this.lottoTickets = lottoTickets;
        this.winNumber = winNumber;
        this.bonusNumber = bonusNumber;
        createLottoResult();
    }

    private void settingWinMap() {
        List<LottoRanking> rank = Arrays.stream(LottoRanking.values())
            .collect(Collectors.toList());
        for (LottoRanking lottoRank : rank) {
            winMap.put(lottoRank, 0);
        }
    }

    private void createLottoResult() {
        for (List<Integer> lottoTicket : lottoTickets) {
            int count = (int) lottoTicket.stream()
                .filter(num -> winNumber.stream().anyMatch(Predicate.isEqual(num))).count();
            boolean flag = lottoTicket.contains(bonusNumber);
            List<LottoRanking> lottoRank = LottoRanking.findLottoRank(count, flag);
            for (LottoRanking lotto : lottoRank) {
                winMap.put(lotto, winMap.get(lotto) + 1);
            }
        }
    }

    public Map<LottoRanking, Integer> getWinMap() {
        return winMap;
    }

}
