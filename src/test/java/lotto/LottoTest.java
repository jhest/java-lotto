package lotto;

import lotto.domain.Lotto;
import lotto.domain.Match;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    void 번호_생성_확인() {
        Lotto lotto = new Lotto();
        List<Integer> numbers = lotto.getNumbers();

        assertThat(numbers.size()).isEqualTo(6);
    }

    @Test
    void 당첨_번호_갯수_확인() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto winningNumber = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));
        lotto.matchCount(winningNumber);

        assertThat(lotto.getMatch()).isEqualTo(Match.THREEMATCH);
    }

}
