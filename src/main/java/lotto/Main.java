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
        List<Lotto> lottos = lottoCenter.generateTicket(buyCount);

        //생성된 로또 번호 표시
        resultView.issuedTicket(lottos);

        //당첨 번호 입력
        List<Integer> winningNumber = inputView.winningNumberInput();

        //당첨 여부 확인
        List<Lotto> checkedLottos = lottoCenter.matchWinningNumber(lottos, winningNumber);

        //통계 산출
        WinningResult result = lottoCenter.calcStat(checkedLottos);

        //결과 표시
        resultView.finalResult(result.getResult(), result.getRate(lottoCenter.getCash()));
    }
}
