package lotto.validation;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class BonusNumberValidationTest {

    @Test
    void 에러_안뜸() throws Exception {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        assertDoesNotThrow(() -> BonusNumberValidation.validate("44", list));
    }

    @Test
    void 에러_뜸() throws Exception {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        assertThrows(IllegalArgumentException.class,
            () -> BonusNumberValidation.validate("46", list));
    }

    @Test
    void 에러_뜸1() throws Exception {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        assertThrows(IllegalArgumentException.class,
            () -> BonusNumberValidation.validate("4", list));
    }

}