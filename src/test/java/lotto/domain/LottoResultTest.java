package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    void z() throws Exception {
        List<List<Integer>> lists = List.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 7),
            List.of(1, 2, 3, 8, 10, 11));
        List<Integer> win = List.of(1,2,3,4,5,6);
        int bonus = 7;
        LottoResult lottoResult = new LottoResult(lists, win, bonus);
        System.out.println(lottoResult.getWinMap());
    }
}