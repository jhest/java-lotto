package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class WinningResultTest {

    @Test
    void 통계_계산() {
        LotteryCenter lotteryCenter = new LotteryCenter();
        List<Lottery> lotteries = lotteryCenter.generateTicket(lotteryCenter.issuedNumber(10000));

        WinningResult winningResult = new WinningResult(lotteries, 10000);
        List<String> list = winningResult.toList();

        assertThat(list).hasSize(5);
        assertThat(Integer.parseInt(list.get(0))).isLessThanOrEqualTo(10);
        assertThat(Integer.parseInt(list.get(1))).isLessThanOrEqualTo(10);
        assertThat(Integer.parseInt(list.get(2))).isLessThanOrEqualTo(10);
        assertThat(Integer.parseInt(list.get(3))).isLessThanOrEqualTo(10);
        assertThat(Float.parseFloat(list.get(4))).isLessThanOrEqualTo(1);
    }
}