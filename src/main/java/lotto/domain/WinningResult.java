package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Rank.*;

public class WinningResult {

    private final List<Long> result;

    public WinningResult(List<Lotto> lotteries, int cash) {
        List<Long> result = new ArrayList<>();
        for (Rank value : values()) {
            long count = lotteries.stream().filter(lotto -> lotto.getRank().equals(value)).count();
            result.add(count);
        }
        this.result = result;
        getRate(cash);
    }

    public float getRate(int cash) {
        return (float) ((result.get(0) * FIRST.getWinningMoney())
                + (result.get(1) * SECOND.getWinningMoney())
                + (result.get(2) * THIRD.getWinningMoney())
                + (result.get(3) * FOURTH.getWinningMoney())
                + (result.get(4) * FIFTH.getWinningMoney())) / cash;
    }

    public List<Long> getResult() {
        return result;
    }
}
