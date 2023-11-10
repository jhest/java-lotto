package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LotteryCenter {

    private static final int PRICE = 1000;
    private static int cash;

    public LotteryCenter() {
    }

    public int issuedNumber(int cash) {
        LotteryCenter.cash = cash;
        return cash / PRICE;
    }

    public List<Lottery> generateTicket(int number) {
        List<Lottery> lotteries = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            Lottery lottery = new Lottery();
            lotteries.add(lottery);
        }
        return lotteries;
    }

    public List<Lottery> checkWinningNumber(List<Lottery> lotteries, List<Integer> winningNumber) {
        for (Lottery lottery : lotteries) {
            List<Integer> matchedList = lottery.selectedNumber().stream()
                    .filter(n -> winningNumber.stream().anyMatch(Predicate.isEqual(n)))
                    .collect(Collectors.toList());
            lottery.winningCheck(matchedList.size());
        }

        return lotteries;
    }

    public WinningResult calcStat(List<Lottery> checkedLotteries) {
        return new WinningResult(checkedLotteries, LotteryCenter.cash);
    }
}
