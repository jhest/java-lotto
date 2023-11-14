package lotto;

import lotto.domain.Lottery;
import lotto.domain.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class LotteryTest {

    @Test
    void 자동_번호_생성() {
        Lottery lottery = new Lottery();
        LottoNumber selectedNumber = lottery.selectedNumber();
        List<Integer> numbers = selectedNumber.getLottoNumbers();

        Assertions.assertThat(numbers.size()).isEqualTo(6);
    }
}