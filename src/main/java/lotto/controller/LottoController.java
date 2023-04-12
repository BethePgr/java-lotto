package lotto.controller;

import lotto.validation.StartMoneyValidation;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    InputView inputView = new InputView();

    public void run(){
        String money = inputView.inputStartMoney();
        StartMoneyValidation.checkMoneyAllValid(money);
        OutputView.printBuyingMessage(Integer.parseInt(money)/1000);
    }

    public static void main(String[] args) {
        LottoController lo = new LottoController();
        lo.run();
    }
}
