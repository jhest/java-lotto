package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class LottoTest {

    @Test
    void 자동_번호_생성() {
        Lotto lotto = new Lotto();
        LottoNumber selectedNumber = lotto.selectedNumber();
        List<Integer> numbers = selectedNumber.getLottoNumbers();

        Assertions.assertThat(numbers.size()).isEqualTo(6);
    }
}