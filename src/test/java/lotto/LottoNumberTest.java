package lotto;

import lotto.domain.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class LottoNumberTest {

    @Test
    void 번호_추출_6개() {
        LottoNumber lottoNumber = new LottoNumber(List.of(3, 5, 7, 11, 35, 12, 43, 10));
        Assertions.assertThat(lottoNumber.getLottoNumbers()).hasSize(6);
    }
}