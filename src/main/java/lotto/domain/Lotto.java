package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import lotto.validation.LottoTicketValidation;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoTicketValidation.validate(numbers);
        this.numbers = numbers;
    }

    // TODO: 추가 기능 구현
}
