package lotto.controller;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.BonusNumber;
import lotto.domain.LottoRanking;
import lotto.domain.LottoResult;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.domain.WinNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LottoTickets lottoTickets;
    Money moneys;
    String money;

    public void run(){
        try {
            moneys = new Money(inputView.inputStartMoney());
            money = moneys.getMoney();
            OutputView.printBuyingMessage(Integer.parseInt(money)/1000);
            lottoTickets = new LottoTickets(Integer.parseInt(money)/1000);
            OutputView.printLottos(lottoTickets.getLottoTickets());
            WinNumber winNumbers = new WinNumber(inputView.inputWinNumber());
            List<Integer> winNumber = winNumbers.getWinNumber();
            BonusNumber bonusNumbers = new BonusNumber(inputView.inputBonusNumber(),winNumber);
            String bonusNumber = bonusNumbers.getBonusNumber();
            outputView.printResult(lottoTickets.getLottoTickets(),winNumber,Integer.parseInt(bonusNumber));
            outputView.printBenefit(Integer.parseInt(money));
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage()+"zzzzz");
        }

    }

}
