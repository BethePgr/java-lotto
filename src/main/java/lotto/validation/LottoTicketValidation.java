package lotto.validation;

import java.util.List;

public class LottoTicketValidation {

    public static void validate(List<Integer> numbers) {
        validateOriginalSize(numbers);
        validateDistinctSize(numbers);
        validateBetween1And45(numbers);

    }

    private static void validateOriginalSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또의 사이즈는 6이여야 합니다.");
        }
    }

    private static void validateDistinctSize(List<Integer> numbers) {
        int count = (int) numbers.stream().distinct().count();
        if (count != 6) {
            throw new IllegalArgumentException("[ERROR] 로또는 중복되지 않는 6개의 숫자입니다.");
        }
    }

    private static void validateBetween1And45(List<Integer> numbers) {
        boolean flag = numbers.stream().allMatch(num -> num >= 1 && num <= 45);
        if (flag != true) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이입니다.");
        }
    }

}
