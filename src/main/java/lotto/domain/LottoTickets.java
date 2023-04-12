package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final int ticketCount;
    private List<List<Integer>> lottoTickets;

    public LottoTickets(int ticketCount){
        this.ticketCount = ticketCount;
        createLottoTickets();
    }

    public List<List<Integer>> createLottoTickets(){
        lottoTickets = new ArrayList<>();
        for(int i = 0;i<ticketCount;i++){
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6));
            lottoTickets.add(lotto.getNumbers());
        }
        return lottoTickets;
    }


    public List<List<Integer>> getLottoTickets(){
        return this.lottoTickets;
    }
}
