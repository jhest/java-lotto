package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class LotteryTest {

    @Test
    void 번호_생성() {
        Lottery lottery = new Lottery();
        List<Integer> selectedNumber = lottery.selectedNumber();

        Assertions.assertThat(selectedNumber).hasSize(6);
    }

    @Test
    void 당첨_번호_갯수_확인() {
        Lottery lottery = new Lottery();
        lottery.winningCheck(3);

        Assertions.assertThat(lottery.isWinning()).isEqualTo(3);
    }
}