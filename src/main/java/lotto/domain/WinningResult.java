package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningResult {

    private static final int THREEPRIZE = 5000;
    private static final int FOURPRIZE = 50000;
    private static final int FIVEPRIZE = 1500000;
    private static final int SIXPRIZE = 2000000000;

    private final List<Long> result;

    public WinningResult(List<Lotto> lottos) {
        List<Long> result = new ArrayList<>();
        for (int i = 3; i <= 6; i++) {
            int matchedNumber = i;
            long count = lottos.stream().filter(lotto -> lotto.isWinning() == matchedNumber).count();
            result.add(count);
        }
        this.result = result;
    }

    public float getRate(int cash) {
        return (float) ((result.get(0) * THREEPRIZE)
                + (result.get(1) * FOURPRIZE)
                + (result.get(2) * FIVEPRIZE)
                + (result.get(3) * SIXPRIZE)) / cash;
    }

    public List<Long> getResult() {
        return result;
    }
}
