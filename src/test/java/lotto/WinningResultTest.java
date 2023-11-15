package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoCenter;
import lotto.domain.WinningResult;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class WinningResultTest {

    @Test
    void 통계_계산() {
        LottoCenter lottoCenter = new LottoCenter();
        int cash = 10000;
        List<Lotto> lottos = lottoCenter.generateTicket(lottoCenter.buyLotto(cash));

        WinningResult winningResult = new WinningResult(lottos);
        List<Long> result = winningResult.getResult();
        float rate = winningResult.getRate(cash);

        assertThat(result).hasSize(4);
        assertThat(result.get(0)).isLessThanOrEqualTo(10);
        assertThat(result.get(1)).isLessThanOrEqualTo(10);
        assertThat(result.get(2)).isLessThanOrEqualTo(10);
        assertThat(result.get(3)).isLessThanOrEqualTo(10);
        assertThat(rate).isLessThanOrEqualTo(1);
    }
}