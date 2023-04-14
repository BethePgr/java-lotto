package lotto.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WinNumberValidationTest {

    @Test
    void 에러_발생하면_안됨() throws Exception {
        String str = "1,2,3,4,5,6";
        assertDoesNotThrow(() -> WinNumberValidation.validate(str));
    }

    @Test
    void 숫자범위_때문에_에러_발생() throws Exception {
        String str = "1,2,3,4,55,6";
        assertThrows(IllegalArgumentException.class, () -> WinNumberValidation.validate(str));
    }

    @Test
    void 자리개수_6개_아니여서_에러_발생() throws Exception {
        String str = "1,2,3,43,4,5,6";
        assertThrows(IllegalArgumentException.class, () -> WinNumberValidation.validate(str));
    }

    @Test
    void 자리개수_6개_아니여서_에러_발생1() throws Exception {
        String str = "1,2,3,4,5";
        assertThrows(IllegalArgumentException.class, () -> WinNumberValidation.validate(str));
    }

    @Test
    void 겹쳐서_에러_발생() throws Exception {
        String str = "1,2,3,4,5,5";
        assertThrows(IllegalArgumentException.class, () -> WinNumberValidation.validate(str));
    }

    @Test
    void 겹쳐서_에러_발생1() throws Exception {
        String str = "1,2,3,4,5,5,6";
        assertThrows(IllegalArgumentException.class, () -> WinNumberValidation.validate(str));
    }
}