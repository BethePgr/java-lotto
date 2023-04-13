package lotto.controller;

import lotto.domain.LottoTickets;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    InputView inputView = new InputView();
    LottoTickets lottoTickets;
    public void run(){
        String money = inputView.inputStartMoney();
        OutputView.printBuyingMessage(Integer.parseInt(money)/1000);
        lottoTickets = new LottoTickets(Integer.parseInt(money)/1000);
        OutputView.printLottos(lottoTickets.getLottoTickets());
    }

    public static void main(String[] args) {
        LottoController lo = new LottoController();
        lo.run();
    }
}
