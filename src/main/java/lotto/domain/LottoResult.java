package lotto.domain;

import java.util.HashMap;
import java.util.List;

public class LottoResult {

    private final List<List<Integer>> lottoTickets;
    private final List<Integer> winNumber;
    private final Integer bonusNumber;

    private HashMap<String,Integer> winMap = new HashMap<>(){{
        put("six",0);
        put("fiveBonus",0);
        put("five",0);
        put("four",0);
        put("three",0);
    }};

    public LottoResult(List<List<Integer>> lottoTickets,List<Integer> winNumber,int bonusNumber){
        this.lottoTickets = lottoTickets;
        this.winNumber = winNumber;
        this.bonusNumber = bonusNumber;
        finishWinMap();
    }

    private void finishWinMap(){
        for(List<Integer> lottoTicket : lottoTickets){
            int count = 0;
            for(Integer winNum : winNumber){
                if(lottoTicket.contains(winNum)){
                    count++;
                }
            }
            if(count == 6){
                winMap.put("six",winMap.getOrDefault("six",0)+1);
            }if(count == 5 && lottoTicket.contains(bonusNumber)){
                winMap.put("fiveBonus",winMap.getOrDefault("fiveBonus",0)+1);
            }if(count == 5 && !lottoTicket.contains(bonusNumber)){
                winMap.put("five",winMap.getOrDefault("five",0)+1);
            }if(count == 4){
                winMap.put("four",winMap.getOrDefault("four",0)+1);
            }if(count == 3){
                winMap.put("three",winMap.getOrDefault("three",0)+1);
            }
        }
    }

    public HashMap<String,Integer> getWinMap(){
        return winMap;
    }


}
