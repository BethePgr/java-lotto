package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinNumberTest {

    @Test
    void 예외_없음() throws Exception{
        assertDoesNotThrow(() -> {
            WinNumber winNumber = new WinNumber("1,2,3,4,5,6");
        });
    }

    @Test
    void 예외_5자리라서_발생() throws Exception{
        assertThrows(IllegalArgumentException.class,()->{
            WinNumber winNumber = new WinNumber("1,2,3,4,5");
        });
    }

    @Test
    void 예외_중복_때문에_발생() throws Exception{
        assertThrows(IllegalArgumentException.class,()->{
            WinNumber winNumber = new WinNumber("1,2,3,4,5,5");
        });
    }

    @Test
    void 예외_중복_때문에_발생1() throws Exception{
        assertThrows(IllegalArgumentException.class,()->{
            WinNumber winNumber = new WinNumber("1,2,3,4,5,5,6");
        });
    }
}