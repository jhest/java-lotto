package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottery {

    private final LottoNumber lotteryNumber;
    private Rank rank;

    public Lottery() {
        List<Integer> allNumber = new ArrayList<>();
        numberBound(allNumber);
        Collections.shuffle(allNumber);
        lotteryNumber = new LottoNumber(allNumber);
    }

    private static void numberBound(List<Integer> allNumber) {
        for (int i = 0; i < 46; i++) {
            allNumber.add(i + 1);
        }
    }

    public Lottery(LottoNumber lottoNumber) {
        lotteryNumber = lottoNumber;
    }

    public LottoNumber selectedNumber() {
        return lotteryNumber;
    }

    public void winningCheck(int matchCount, boolean matchBonus) {
        this.rank = Rank.valueOf(matchCount, matchBonus);
    }

    public Rank getRank() {
        return rank;
    }
}
