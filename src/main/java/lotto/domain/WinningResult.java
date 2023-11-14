package lotto.domain;

import java.util.List;

import static lotto.domain.Rank.*;

public class WinningResult {

    private final long[] result;
    private float rate;

    public WinningResult(List<Lottery> lotteries, int cash) {
        long first = lotteries.stream().filter(x -> x.getRank().equals(FIRST)).count();
        long second = lotteries.stream().filter(x -> x.getRank().equals(SECOND)).count();
        long third = lotteries.stream().filter(x -> x.getRank().equals(THIRD)).count();
        long fourth = lotteries.stream().filter(x -> x.getRank().equals(FOURTH)).count();
        long fifth = lotteries.stream().filter(x -> x.getRank().equals(FIFTH)).count();
        result = new long[]{first, second, third, fourth, fifth};
        rate(cash);
    }

    private void rate(int cash) {
        rate = (float) ((result[0] * FIRST.getWinningMoney())
                + (result[1] * SECOND.getWinningMoney())
                + (result[2] * THIRD.getWinningMoney())
                + (result[3] * FOURTH.getWinningMoney())
                + (result[4] * FIFTH.getWinningMoney())) / cash;
    }

    public long[] getResult() {
        return result;
    }

    public float getRate() {
        return rate;
    }
}
