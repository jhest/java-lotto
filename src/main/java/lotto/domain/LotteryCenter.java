package lotto.domain;

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

    public List<Lottery> checkWinningNumber(List<Lottery> lotteries, List<Integer> winningNumber, int bonusNumber) {
        for (Lottery lottery : lotteries) {
            List<Integer> matchedList = matchngNumber(winningNumber, lottery);
            lottery.winningCheck(matchedList.size(), lottery.selectedNumber().getLottoNumbers().contains(bonusNumber));
        }
        return lotteries;
    }

    private static List<Integer> matchngNumber(List<Integer> winningNumber, Lottery lottery) {
        return lottery.selectedNumber().getLottoNumbers().stream()
                .filter(n -> winningNumber.stream().anyMatch(Predicate.isEqual(n)))
                .collect(Collectors.toList());
    }

    public WinningResult calcStat(List<Lottery> checkedLotteries) {
        return new WinningResult(checkedLotteries, LotteryCenter.cash);
    }
}
