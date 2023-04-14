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

    public void run() {

        final OutputView outputView = new OutputView();
        try {
            String money = inputMoneyOutputMoney();
            List<List<Integer>> lottoTickets = inputLottoTicketsOutputLottoTickets(money);
            List<Integer> winNumber = inputWinNumOutputWinNum();
            String bonusNumber = inputBonusOutputBonus(winNumber);
            outputView.printResult(lottoTickets, winNumber,
                Integer.parseInt(bonusNumber));
            outputView.printBenefit(Integer.parseInt(money));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private String inputMoneyOutputMoney() {
        Money moneys = new Money(InputView.inputStartMoney());
        String money = moneys.getMoney();
        OutputView.printBuyingMessage(Integer.parseInt(money) / 1000);

        return money;
    }

    private List<List<Integer>> inputLottoTicketsOutputLottoTickets(String money) {
        LottoTickets lottoTickets = new LottoTickets(Integer.parseInt(money) / 1000);
        OutputView.printLottos(lottoTickets.getLottoTickets());
        return lottoTickets.getLottoTickets();
    }

    private List<Integer> inputWinNumOutputWinNum() {
        WinNumber winNumbers = new WinNumber(InputView.inputWinNumber());
        return winNumbers.getWinNumber();
    }

    private String inputBonusOutputBonus(List<Integer> winNumber) {
        BonusNumber bonusNumbers = new BonusNumber(InputView.inputBonusNumber(), winNumber);
        return bonusNumbers.getBonusNumber();
    }
}
