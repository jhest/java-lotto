package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


class LottoCenterTest {

    @Test
    void 로또_구매_숫자_계산() {
        int cash = 14000;
        int number = new LottoCenter().buyCount(cash);
        assertThat(number).isEqualTo(14);
    }

    @Test
    void 자동_로또_번호_생성() {
        int issuedCount = 1;
        List<Lotto> issuedTicket = new LottoCenter().generateTicket(issuedCount);
        Lotto lotto = issuedTicket.get(0);
        LottoNumber number = lotto.selectedNumber();
        assertThat(number.getLottoNumbers().size()).isEqualTo(6);
    }
    @Test
    void 당첨_여부_확인_보너스() {
        Lotto lotto = new Lotto(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 7)));
        List<Lotto> lotteries = List.of(lotto);
        List<Integer> winning = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        List<Lotto> checkedLotteries = new LottoCenter().checkWinningNumber(lotteries, winning, bonus);
        assertThat(checkedLotteries.get(0).getRank()).isEqualTo(Rank.SECOND);
    }

    @Test
    void 통계_추출() {
        Lotto lotto_second = new Lotto(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 7)));
        Lotto lotto_fourth = new Lotto(new LottoNumber(Arrays.asList(1, 2, 3, 4, 7, 8)));
        Lotto lotto_fifth = new Lotto(new LottoNumber(Arrays.asList(1, 2, 3, 7, 8, 9)));
        List<Lotto> lotteries = Arrays.asList(lotto_fifth, lotto_fourth, lotto_second);

        List<Integer> winning = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonus = 7;
        new LottoCenter().checkWinningNumber(lotteries, winning, bonus);

        WinningResult winningResult = new LottoCenter().calcStat(lotteries);
        List<Long> result = winningResult.getResult();
        assertThat(result.get(1)).isEqualTo(1); //2nd
        assertThat(result.get(3)).isEqualTo(1); //4th
        assertThat(result.get(4)).isEqualTo(1); //5th
    }
}