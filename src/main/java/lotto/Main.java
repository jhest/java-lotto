package lotto;

import lotto.domain.Lottery;
import lotto.domain.LotteryCenter;
import lotto.domain.WinningResult;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LotteryCenter lotteryCenter = new LotteryCenter();

        //구입 금액 입력
        int issuedNumber = inputView.buyTicket();

        //로또 번호 생성
        List<Lottery> lotteries = lotteryCenter.generateTicket(issuedNumber);

        //생성된 로또 번호 표시
        resultView.issuedTicket(lotteries);

        //당첨 번호 & 보너스 볼 입력
        List<Integer> winningNumber = inputView.winningNumberInput();
        int bonusNumber = inputView.bonusNumberInput();

        //당첨 여부 확인
        List<Lottery> checkedLotteries = lotteryCenter.checkWinningNumber(lotteries, winningNumber, bonusNumber);

        //통계 및 결과 표시
        WinningResult winningResult = lotteryCenter.calcStat(checkedLotteries);
        resultView.finalResult(winningResult.getResult(), winningResult.getRate());
    }
}
