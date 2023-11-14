package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoCenter;
import lotto.domain.LottoNumber;
import lotto.domain.WinningResult;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


class WinningResultTest {

    @Test
    void 통계_계산() {
        List<Lotto> lotteries = getLotteries();
        List<Integer> winning = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonus = 7;
        new LottoCenter().checkWinningNumber(lotteries, winning, bonus);

        WinningResult winningResult = new WinningResult(lotteries, 10000);
        List<Long> result = winningResult.getResult();
        float rate = winningResult.getRate(10000);

        assertThat(result.get(0)).isEqualTo(1); //1st
        assertThat(result.get(1)).isEqualTo(1); //2nd
        assertThat(result.get(2)).isEqualTo(1); //3rd
        assertThat(result.get(3)).isEqualTo(1); //4th
        assertThat(result.get(4)).isEqualTo(1); //5th
        assertThat(rate).isEqualTo((float) 2031555000 / 10000);
    }

    private static List<Lotto> getLotteries() {
        Lotto lotto_first = new Lotto(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Lotto lotto_second = new Lotto(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 7)));
        Lotto lotto_third = new Lotto(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 8)));
        Lotto lotto_fourth = new Lotto(new LottoNumber(Arrays.asList(1, 2, 3, 4, 7, 8)));
        Lotto lotto_fifth = new Lotto(new LottoNumber(Arrays.asList(1, 2, 3, 7, 8, 9)));
        return Arrays.asList(lotto_fifth, lotto_fourth, lotto_third, lotto_second, lotto_first);
    }
}