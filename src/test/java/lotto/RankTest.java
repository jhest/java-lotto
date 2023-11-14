package lotto;

import lotto.domain.Rank;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RankTest {

    @Test
    void 등수_확인() {
        Rank rank = Rank.valueOf(3, false);
        int winningMoney = rank.getWinningMoney();
        assertThat(winningMoney).isEqualTo(5000);
    }
}