package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final LottoNumber lottoNumber;
    private Rank rank;

    public Lotto() {
        List<Integer> allNumber = new ArrayList<>();
        numberBound(allNumber);
        Collections.shuffle(allNumber);
        lottoNumber = new LottoNumber(allNumber);
    }

    private static void numberBound(List<Integer> allNumber) {
        for (int i = 0; i < 46; i++) {
            allNumber.add(i + 1);
        }
    }

    public Lotto(LottoNumber lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public LottoNumber selectedNumber() {
        return lottoNumber;
    }

    public void winningCheck(int matchCount, boolean matchBonus) {
        this.rank = Rank.valueOf(matchCount, matchBonus);
    }

    public Rank getRank() {
        return rank;
    }
}
