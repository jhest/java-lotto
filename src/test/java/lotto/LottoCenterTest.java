package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class LottoCenterTest {

    @Test
    void 로또_구매() {
        Cash cash = new Cash(14000);
        List<Lotto> manualLottos = new ArrayList<>();
        List<Lotto> lottos = new LottoCenter().manualBuyLotto(cash, manualLottos);

        assertThat(lottos.size()).isEqualTo(14);
    }

    @Test
    void 로또_생성() {
        Cash cash = new Cash(14000);
        List<Lotto> manualLottos = new ArrayList<>();
        List<Lotto> lottos = new LottoCenter().manualBuyLotto(cash, manualLottos);
        List<LottoNo> numbers = lottos.get(0).getLottoNumbers().getLottoNos();

        assertThat(numbers.size()).isEqualTo(6);
    }

    @Test
    void 수동_생성() {
        Cash cash = new Cash(10000);
        Lotto manual = new Lotto(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(6)));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(manual);

        LottoCenter lottoCenter = new LottoCenter();
        List<Lotto> lottosResult = lottoCenter.manualBuyLotto(cash, lottos);

        assertThat(lottosResult.size()).isEqualTo(10);
        assertThat(lottosResult.get(0)).isEqualTo(manual);
    }

    @Test
    void 당첨_여부_확인_5등() {
        Lotto lotto = new Lotto(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(7), new LottoNo(8), new LottoNo(9)));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto);

        Lotto winningNumbers = new Lotto(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(6)));
        LottoNo bonusNumber = new LottoNo(7);

        new LottoCenter().matchWinningNumbers(lottos, winningNumbers, bonusNumber);
        Rank rank = lottos.get(0).getRank();

        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @Test
    void 당첨_여부_확인_2등() {
        Lotto lotto = new Lotto(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(9)));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto);

        Lotto winningNumbers = new Lotto(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(6)));
        LottoNo bonusNumber = new LottoNo(9);

        new LottoCenter().matchWinningNumbers(lottos, winningNumbers, bonusNumber);
        Rank rank = lottos.get(0).getRank();

        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    void 통계_당첨_결과() {
        Lotto lotto = new Lotto(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(9)));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto);

        Lotto winningNumber = new Lotto(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(6)));
        LottoNo bonusNumber = new LottoNo(9);
        LottoCenter lottoCenter = new LottoCenter();
        lottoCenter.matchWinningNumbers(lottos, winningNumber, bonusNumber);

        Result result = lottoCenter.checkWinningResult(lottos);

        assertThat(result.get(0)).isEqualTo(0);
        assertThat(result.get(1)).isEqualTo(1);
    }

    @Test
    void 통계_당첨_수익률() {
        Cash cash = new Cash(1000);
        LottoCenter lottoCenter = new LottoCenter(new Result());
        List<Lotto> manualLottos = new ArrayList<>();
        Lotto lotto = new Lotto(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(7), new LottoNo(8), new LottoNo(9)));
        manualLottos.add(lotto);
        List<Lotto> lottos = lottoCenter.manualBuyLotto(cash, manualLottos);

        Lotto winningNumber = new Lotto(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(6)));
        LottoNo bonusNumber = new LottoNo(7);
        lottoCenter.matchWinningNumbers(lottos, winningNumber, bonusNumber);
        lottoCenter.checkWinningResult(lottos);

        float rate = lottoCenter.checkWinningRate();

        assertThat(rate).isLessThanOrEqualTo(5.0F);
    }
}