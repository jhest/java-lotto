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

        List<LottoNo> lottoNos = lottos.get(0).getLottoNumbers();
        assertThat(lottoNos.size()).isEqualTo(6);
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

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        LottoCenter lottoCenter = new LottoCenter(winningLotto);
        Result result = lottoCenter.matchWinningNumbers(lottos);

        assertThat(result.getResult().get(0)).isEqualTo(Rank.FIFTH);
    }

    @Test
    void 당첨_여부_확인_2등() {
        Lotto lotto = new Lotto(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(9)));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto);

        Lotto winningNumbers = new Lotto(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(6)));
        LottoNo bonusNumber = new LottoNo(9);

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        LottoCenter lottoCenter = new LottoCenter(winningLotto);
        Result result = lottoCenter.matchWinningNumbers(lottos);

        assertThat(result.getResult().get(0)).isEqualTo(Rank.SECOND);
    }

    @Test
    void 통계_당첨_결과() {
        Lotto lotto = new Lotto(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(9)));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto);

        Lotto winningNumber = new Lotto(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(6)));
        LottoNo bonusNumber = new LottoNo(10);
        WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNumber);

        LottoCenter lottoCenter = new LottoCenter(winningLotto);
        lottoCenter.matchWinningNumbers(lottos);

        List<Integer> result = lottoCenter.checkWinningResult();

        assertThat(result.get(0)).isEqualTo(0); //1st
        assertThat(result.get(2)).isEqualTo(1); //3rd
    }

    @Test
    void 통계_당첨_수익률() {
        Lotto winningNumber = new Lotto(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(6)));
        LottoNo bonusNumber = new LottoNo(7);
        WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNumber);
        LottoCenter lottoCenter = new LottoCenter(winningLotto);

        Cash cash = new Cash(1000);
        List<Lotto> lottos = lottoCenter.manualBuyLotto(cash, null);

        lottoCenter.matchWinningNumbers(lottos);
        lottoCenter.checkWinningResult();

        float rate = lottoCenter.checkWinningRate();

        assertThat(rate).isLessThanOrEqualTo(1);
    }
}