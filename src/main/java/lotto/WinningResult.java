package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningResult {

    public static final int THREEPRIZE = 5000;
    public static final int FOURPRIZE = 50000;
    public static final int FIVEPRIZE = 1500000;
    public static final int SIXPRIZE = 2000000000;

    private int threeMatched = 0;
    private int fourMatched = 0;
    private int fiveMatched = 0;
    private int sixMatched = 0;
    private float rate;

    public WinningResult(List<Lottery> lotteries, int cash) {

        for (Lottery lottery : lotteries) {
            if (lottery.isWinning() == 3) {
                threeMatched();
            }
            if (lottery.isWinning() == 4) {
                fourMatched();
            }
            if (lottery.isWinning() == 5) {
                fiveMatched();
            }
            if (lottery.isWinning() == 6) {
                sixMatched();
            }
        }
        rate(cash);
    }

    private void threeMatched() {
        this.threeMatched++;
    }

    private void fourMatched() {
        this.fourMatched++;
    }

    private void fiveMatched() {
        this.fiveMatched++;
    }

    private void sixMatched() {
        this.sixMatched++;
    }

    private void rate(int cash) {
        rate = (float) ((threeMatched * THREEPRIZE)
                + (fourMatched * FOURPRIZE)
                + (fiveMatched * FIVEPRIZE)
                + (sixMatched * SIXPRIZE)) / cash;
    }

    public List<String> toList() {
        List<String> result = new ArrayList<>();
        result.add(String.valueOf(threeMatched));
        result.add(String.valueOf(fourMatched));
        result.add(String.valueOf(fiveMatched));
        result.add(String.valueOf(sixMatched));
        result.add(String.valueOf(rate));

        return result;
    }
}
