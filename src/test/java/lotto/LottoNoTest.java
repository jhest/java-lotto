package lotto;

import lotto.domain.LottoNo;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoNoTest {

    @Test
    void 숫자_범위() {
        int numberZero = 0;
        int numberOver = 46;

        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNo(numberZero));
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNo(numberOver));
    }
}