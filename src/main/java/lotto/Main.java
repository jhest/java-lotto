package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoCenter;
import lotto.domain.WinningResult;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoCenter lottoCenter = new LottoCenter();

        //구입 금액 입력
        int buyCount = inputView.buyTicket();

        //로또 번호 생성
        List<Lotto> lotteries = lottoCenter.generateTicket(buyCount);

        //생성된 로또 번호 표시
        resultView.issuedTicket(lotteries);

        //당첨 번호 & 보너스 볼 입력
        List<Integer> winningNumber = inputView.winningNumberInput();
        int bonusNumber = inputView.bonusNumberInput();

        //당첨 여부 확인
        List<Lotto> checkedLotteries = lottoCenter.checkWinningNumber(lotteries, winningNumber, bonusNumber);

        //통계 및 결과 표시
        WinningResult result = lottoCenter.calcStat(checkedLotteries);
        resultView.finalResult(result.getResult(), result.getRate(lottoCenter.getCash()));
    }
}
