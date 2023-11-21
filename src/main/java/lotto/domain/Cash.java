package lotto.domain;

import java.util.List;

public class Cash {

    public static final int PRICE = 1000;

    private final int cash;

    public Cash(int cash) {
        this.cash = cash;
    }

    public int getCash() {
        return cash;
    }

    public int getCount() {
        return cash / PRICE;
    }

    public Cash getAutoCash(Cash cash, List<Lotto> manualNumbers) {
        int autoCash = cash.getCash() - manualNumbers.size() * PRICE;
        return new Cash(autoCash);
    }
}
