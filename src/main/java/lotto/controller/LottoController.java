package lotto.controller;

import java.util.List;
import lotto.domain.LottoTickets;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LottoTickets lottoTickets;
    public void run(){
        String money = inputView.inputStartMoney();
        OutputView.printBuyingMessage(Integer.parseInt(money)/1000);
        lottoTickets = new LottoTickets(Integer.parseInt(money)/1000);
        OutputView.printLottos(lottoTickets.getLottoTickets());
        List<Integer> winNumber = inputView.inputWinNumber();
        String bonusNumber = inputView.inputBonusNumber(winNumber);
        outputView.printResult(lottoTickets.getLottoTickets(),winNumber,Integer.parseInt(bonusNumber));
        outputView.printBenefit(Integer.parseInt(money));
    }

}
