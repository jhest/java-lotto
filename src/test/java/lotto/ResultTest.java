package lotto;

import lotto.domain.Rank;
import lotto.domain.Result;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class ResultTest {

    @Test
    void Rank_add_확인() {
        Result result = new Result();
        result.add(Rank.FIFTH);
        Rank addedRank = result.getResult().get(0);

        Assertions.assertThat(addedRank).isEqualTo(Rank.FIFTH);
    }
}