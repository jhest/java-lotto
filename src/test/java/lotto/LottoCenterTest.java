package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoCenter;
import lotto.domain.WinningResult;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


class LottoCenterTest {

    @Test
    void 로또_구매_숫자() {
        int cash = 14000;
        int number = new LottoCenter().buyLotto(cash);

        assertThat(number).isEqualTo(14);
    }

    @Test
    void 로또_번호_생성() {
        int buyCount = 1;
        List<Lotto> issuedTicket = new LottoCenter().generateTicket(buyCount);
        List<Integer> number = issuedTicket.get(0).selectedNumber();

        assertThat(number.size()).isEqualTo(6);
    }

    @Test
    void 당첨_여부_확인() {
        int buyCount = 1;
        List<Lotto> lottos = new LottoCenter().generateTicket(buyCount);
        List<Integer> winningNumber = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Lotto> checkedLotteries = new LottoCenter().matchWinningNumber(lottos, winningNumber);
        int result = checkedLotteries.get(0).isWinning();

        assertThat(result).isLessThanOrEqualTo(6);
    }

    @Test
    void 통계_추출() {
        LottoCenter lottoCenter = new LottoCenter();
        int cash = 1000;
        int buyCount = lottoCenter.buyLotto(cash);
        List<Lotto> lottos = lottoCenter.generateTicket(buyCount);

        List<Integer> winning = Arrays.asList(1, 2, 3, 4, 5, 6);
        new LottoCenter().matchWinningNumber(lottos, winning);

        WinningResult winningResult = new LottoCenter().calcStat(lottos);
        assertThat(winningResult.getResult().get(0)).isLessThanOrEqualTo(1);
        assertThat(winningResult.getRate(cash)).isLessThanOrEqualTo(1);
    }
}