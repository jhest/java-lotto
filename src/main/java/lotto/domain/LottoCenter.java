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

    public int buyLotto(int cash) {
        LottoCenter.cash = cash;
        return cash / PRICE;
    }

    public List<Lotto> generateTicket(int number) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            Lotto lotto = new Lotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    public List<Lotto> matchWinningNumber(List<Lotto> lottos, List<Integer> winningNumber) {
        for (Lotto lotto : lottos) {
            List<Integer> matchedList = lotto.selectedNumber().stream()
                    .filter(n -> winningNumber.stream().anyMatch(Predicate.isEqual(n)))
                    .collect(Collectors.toList());
            lotto.matchResult(matchedList.size());
        }
        return lottos;
    }

    public WinningResult calcStat(List<Lotto> checkedLottos) {
        return new WinningResult(checkedLottos);
    }
}
