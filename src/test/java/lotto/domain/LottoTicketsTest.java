package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {

    @Test
    void z() throws Exception{
        LottoTickets lottoTickets = new LottoTickets(6);
        assertEquals(6,lottoTickets.getLottoTickets().size());
    }

}