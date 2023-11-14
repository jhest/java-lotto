package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LottoCenter {

    private static final int PRICE = 1000;

    private static int cash;

    public LottoCenter() {
    }

    public int getCash() {
        return cash;
    }

    public int buyCount(int cash) {
        LottoCenter.cash = cash;
        return cash / PRICE;
    }

    public List<Lotto> generateTicket(int count) {
        List<Lotto> lotteries = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto();
            lotteries.add(lotto);
        }
        return lotteries;
    }

    public List<Lotto> checkWinningNumber(List<Lotto> lotteries, List<Integer> winningNumber, int bonusNumber) {
        for (Lotto lotto : lotteries) {
            List<Integer> matchedList = matchNumber(winningNumber, lotto);
            lotto.winningCheck(matchedList.size(), lotto.selectedNumber().getLottoNumbers().contains(bonusNumber));
        }
        return lotteries;
    }

    private static List<Integer> matchNumber(List<Integer> winningNumber, Lotto lotto) {
        return lotto.selectedNumber().getLottoNumbers().stream()
                .filter(n -> winningNumber.stream().anyMatch(Predicate.isEqual(n)))
                .collect(Collectors.toList());
    }

    public WinningResult calcStat(List<Lotto> checkedLotteries) {
        return new WinningResult(checkedLotteries, LottoCenter.cash);
    }
}
