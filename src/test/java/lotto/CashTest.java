package lotto;

import lotto.domain.Cash;
import lotto.domain.Lotto;
import lotto.domain.LottoNo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class CashTest {

    @Test
    void 자동구매금액() {
        Cash cash = new Cash(1000);
        List<Lotto> manualLottos = new ArrayList<>();
        Lotto manualNumber = new Lotto(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(6)));
        manualLottos.add(manualNumber);
        Cash autoCash = cash.getAutoCash(cash, manualLottos);

        Assertions.assertThat(autoCash.getCash()).isEqualTo(0);
    }
}