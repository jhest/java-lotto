package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Rank.*;

public class LottoCenter {

    private static Cash cash;
    private WinningLotto winningLotto;
    private Result result;

    public LottoCenter() {
    }

    public LottoCenter(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public List<Lotto> manualBuyLotto(Cash cash, List<Lotto> manualNumbers) {
        LottoCenter.cash = cash;
        if (manualNumbers == null || manualNumbers.isEmpty()) {
            return generateTicket(cash);
        }
        Cash autoCash = cash.getAutoCash(cash, manualNumbers);
        List<Lotto> lottos = generateTicket(autoCash);
        manualNumbers.addAll(lottos);

        return manualNumbers;
    }

    public void manualBuyValidCheck(Cash cash, int manualCount) {
        if (cash.getCash() < 1000) {
            throw new IllegalArgumentException("1000원 이상의 금액을 입력하세요.");
        }
        if (manualCount > cash.getCount()) {
            throw new IllegalArgumentException("구입 가능 금액을 초과합니다.");
        }
        if (manualCount < 0) {
            throw new IllegalArgumentException("0 이상의 숫자를 입력하세요.");
        }
    }

    private List<Lotto> generateTicket(Cash cash) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < cash.getCount(); i++) {
            Lotto lotto = new Lotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    public Result matchWinningNumbers(List<Lotto> lottos) {
        Result checkedResult = new Result();
        for (Lotto lotto : lottos) {
            checkedResult.add(winningLotto.matchRank(lotto));
        }
        this.result = checkedResult;
        return this.result;
    }

    public List<Integer> checkWinningResult() {
        List<Integer> statistic = new ArrayList<>();
        for (Rank value : values()) {
            int count = (int) result.getResult().stream().filter(n -> n.equals(value)).count();
            statistic.add(count);
        }
        return statistic;
    }

    public float checkWinningRate() {
        int sum = 0;
        for (Rank value : values()) {
            int count = (int) result.getResult().stream().filter(n -> n.equals(value)).count();
            sum = sum + count * value.getWinningMoney();
        }
        return (float) sum / cash.getCash();
    }
}
