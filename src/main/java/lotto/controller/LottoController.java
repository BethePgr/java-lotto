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

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static LottoTickets lottoTickets;
    private static List<Integer> winNumber;
    private static String bonusNumber;
    private static String money;


    public void run() {
        try {
            inputMoneyOutputLottoTickets();
            inputWinNumOutputWinNum();
            inputBonusOutputBonus();
            outputView.printResult(lottoTickets.getLottoTickets(), winNumber,
                Integer.parseInt(bonusNumber));
            outputView.printBenefit(Integer.parseInt(money));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String inputMoneyOutputLottoTickets() {
        Money moneys = new Money(inputView.inputStartMoney());
        money = moneys.getMoney();
        OutputView.printBuyingMessage(Integer.parseInt(money) / 1000);
        lottoTickets = new LottoTickets(Integer.parseInt(money) / 1000);
        OutputView.printLottos(lottoTickets.getLottoTickets());
        return money;
    }

    private static void inputWinNumOutputWinNum() {
        WinNumber winNumbers = new WinNumber(inputView.inputWinNumber());
        winNumber = winNumbers.getWinNumber();
    }

    private static void inputBonusOutputBonus() {
        BonusNumber bonusNumbers = new BonusNumber(inputView.inputBonusNumber(), winNumber);
        bonusNumber = bonusNumbers.getBonusNumber();
    }
}
