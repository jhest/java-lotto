package lotto;

import lotto.domain.Lottery;
import lotto.domain.LotteryCenter;
import lotto.domain.LottoNumber;
import lotto.domain.WinningResult;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


class WinningResultTest {

    @Test
    void 통계_계산() {
        List<Lottery> lotteries = getLotteries();
        List<Integer> winning = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonus = 7;
        new LotteryCenter().checkWinningNumber(lotteries, winning, bonus);

        WinningResult winningResult = new WinningResult(lotteries, 10000);
        long[] result = winningResult.getResult();
        float rate = winningResult.getRate();

        assertThat(result[0]).isEqualTo(1); //1st
        assertThat(result[1]).isEqualTo(1); //2nd
        assertThat(result[2]).isEqualTo(1); //3rd
        assertThat(result[3]).isEqualTo(1); //4th
        assertThat(result[4]).isEqualTo(1); //5th
        assertThat(rate).isEqualTo((float) 2031555000 /10000);
    }

    private static List<Lottery> getLotteries() {
        Lottery lottery_first = new Lottery(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Lottery lottery_second = new Lottery(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 7)));
        Lottery lottery_third = new Lottery(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 8)));
        Lottery lottery_fourth = new Lottery(new LottoNumber(Arrays.asList(1, 2, 3, 4, 7, 8)));
        Lottery lottery_fifth = new Lottery(new LottoNumber(Arrays.asList(1, 2, 3, 7, 8, 9)));
        return Arrays.asList(lottery_fifth, lottery_fourth, lottery_third, lottery_second, lottery_first);
    }
}