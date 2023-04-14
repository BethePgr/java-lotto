package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    void 나머지가_있으므로_오류를_던진다() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> {
            Money money = new Money("4001");
        });
    }

    @Test
    void 문자가_있으므로_오류를_던진다() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> {
            Money money = new Money("a4000");
        });
    }

    @Test
    void 오류_없음() throws Exception {
        assertDoesNotThrow(() -> {
            Money money = new Money("4000");
        });

        assertDoesNotThrow(() -> {
            Money money = new Money("41000");
        });
    }

}