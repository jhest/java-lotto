package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Rank.*;

public class LottoCenter {

    private Result result;
    private static Cash cash;

    public LottoCenter() {
    }

    public LottoCenter(Result result) {
        this.result = result;
    }

    private List<Lotto> generateTicket(Cash cash) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < cash.getCount(); i++) {
            Lotto lotto = new Lotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    public void matchWinningNumbers(List<Lotto> lottos, Lotto winningNumbers, LottoNo bonusNumber) {
        for (Lotto lotto : lottos) {
            lotto.matchCount(winningNumbers, bonusNumber);
        }
    }

    public Result checkWinningResult(List<Lotto> lottos) {
        Result result = new Result();
        for (Rank rank : values()) {
            result.add(lottos.stream()
                    .filter(lotto -> Rank.valueOf(lotto).equals(rank)).count());
        }
        this.result = result;
        return this.result;
    }

    public float checkWinningRate() {
        return (float) ((result.get(0) * FIRST.getWinningMoney())
                + (result.get(1) * SECOND.getWinningMoney())
                + (result.get(2) * THIRD.getWinningMoney())
                + (result.get(3) * FOURTH.getWinningMoney())
                + (result.get(4) * FIFTH.getWinningMoney())) / cash.getCash();
    }

    public List<Lotto> manualBuyLotto(Cash cash, List<Lotto> manualNumbers) {
        LottoCenter.cash = cash;
        Cash autoCash = cash.getAutoCash(cash, manualNumbers);
        List<Lotto> lottos = generateTicket(autoCash);
        manualNumbers.addAll(lottos);
        return manualNumbers;
    }

    public void manualBuyValidCheck(Cash cash, int manualCount) {
        if (manualCount > cash.getCount()) {
            throw new IllegalArgumentException("구입 금액을 초과합니다.");
        }
    }
}
