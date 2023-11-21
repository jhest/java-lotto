package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNo;
import lotto.domain.Rank;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    void 번호_생성_확인() {
        Lotto lotto = new Lotto();
        List<LottoNo> numbers = lotto.getLottoNumbers().getLottoNos();

        assertThat(numbers.size()).isEqualTo(6);
    }

    @Test
    void 당첨_번호_갯수_확인_5등() {
        Lotto lotto = new Lotto(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(6)));
        Lotto winningNumber = new Lotto(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(8), new LottoNo(9), new LottoNo(10)));
        lotto.matchCount(winningNumber, new LottoNo(7));

        assertThat(lotto.getRank()).isEqualTo(Rank.FIFTH);
    }

    @Test
    void 당첨_번호_갯수_확인_2등() {
        Lotto lotto = new Lotto(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(6)));
        Lotto winningNumber = new Lotto(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(9)));
        lotto.matchCount(winningNumber, new LottoNo(6));

        assertThat(lotto.getRank()).isEqualTo(Rank.SECOND);
    }
}
