package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private InputView inputView;

    @BeforeEach
    void setUp(){
        inputView = new InputView();
    }

    @Test
    void 천으로_나눌시_나머지_존재하므로_에러발생() throws Exception {
        String money = "1001";
        assertThrows(IllegalArgumentException.class,()->inputView.checkMoneyAllValid(money));
    }

    @Test
    void 영으로_시작하므로_에러발생() throws Exception {
        String money = "01000";
        assertThrows(IllegalArgumentException.class,()->inputView.checkMoneyAllValid(money));
    }
    @Test
    void 숫자이외가_존재하므로_에러발생() throws Exception {
        String money = "e1000b";
        assertThrows(IllegalArgumentException.class,()->inputView.checkMoneyAllValid(money));
    }

    @Test
    void 에러발생하면_안됨() throws Exception {
        String money = "1000";
        assertDoesNotThrow(()->inputView.checkMoneyAllValid(money));
    }

    @Test
    void 에러발생하면_안됨1() throws Exception {
        String money = "10000";
        assertDoesNotThrow(()->inputView.checkMoneyAllValid(money));
    }

    @Test
    void 에러발생하면_안됨2() throws Exception {
        String money = "2000";
        assertDoesNotThrow(()->inputView.checkMoneyAllValid(money));
    }
}