package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNo;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    void 자동_번호_생성_확인() {
        Lotto lotto = new Lotto();
        List<LottoNo> lottoNumbers = lotto.getLottoNumbers();

        assertThat(lottoNumbers.size()).isEqualTo(6);
    }

    @Test
    void 숫자_갯수_예외() {
        List<LottoNo> numberLess = Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(numberLess));
    }

    @Test
    void 중복_숫자_예외() {
        List<LottoNo> numberDuplicated = Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(5));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(numberDuplicated));
    }
}
