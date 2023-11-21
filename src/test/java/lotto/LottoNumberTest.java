package lotto;

import lotto.domain.LottoNo;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


class LottoNumberTest {

    @Test
    void 숫자_갯수() {
        List<LottoNo> numbers = Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(numbers));
    }

    @Test
    void 같은_숫자() {
        List<LottoNo> numbers = Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(5));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(numbers));
    }
}