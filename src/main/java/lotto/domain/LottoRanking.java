package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoRanking {

    Three(5000, 3, false),
    Four(50000, 4, false),
    Five(1500000, 5, false),
    FiveBonus(30000000, 5, true),
    Six(2000000000, 6, false);

    private final int prizeMoney;
    private final int winNumber;
    private final boolean matchBonus;

    LottoRanking(int prizeMoney, int winNumber, boolean matchBonus) {
        this.prizeMoney = prizeMoney;
        this.winNumber = winNumber;
        this.matchBonus = matchBonus;
    }

    public static List<LottoRanking> findLottoRank(int winCount, boolean matchBonusNumber) {
        return Arrays.stream(LottoRanking.values())
            .filter(lottoRanking -> checkLottoRank(lottoRanking, winCount, matchBonusNumber))
            .collect(
                Collectors.toList());
    }

    private static boolean checkLottoRank(LottoRanking lottoRanking, int winCount,
        boolean matchBonusNumber) {
        if (lottoRanking.winNumber != winCount) {
            return false;
        }
        if (Five.winNumber == winCount) {
            return lottoRanking.matchBonus == matchBonusNumber;
        }
        return true;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getWinNumber() {
        return winNumber;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

}

