package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.validation.LottoTicketValidation;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoTicketValidation.validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }
}
