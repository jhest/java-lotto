package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


class LotteryCenterTest {

    @Test
    void 로또_구매_숫자() {
        int cash = 14000;
        int number = new LotteryCenter().issuedNumber(cash);
        assertThat(number).isEqualTo(14);
    }

    @Test
    void 로또_번호_생성() {
        int issuedNumber = 1;
        List<Lottery> issuedTicket = new LotteryCenter().generateTicket(issuedNumber);
        Lottery lottery = issuedTicket.get(0);
        List<Integer> number = lottery.selectedNumber();
        assertThat(number.size()).isEqualTo(6);
    }

    @Test
    void 당첨_여부_확인() {
        Lottery lottery = new Lottery();
        List<Lottery> lotteries = new ArrayList<>();
        lotteries.add(lottery);
        List<Integer> winning = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Lottery> checkedLotteries = new LotteryCenter().checkWinningNumber(lotteries, winning);
        int result = checkedLotteries.get(0).isWinning();

        assertThat(result).isLessThanOrEqualTo(6);
    }

    @Test
    void 통계_추출() {
        LotteryCenter lotteryCenter = new LotteryCenter();

        int cash = 1000;
        int issuedNumber = lotteryCenter.issuedNumber(cash);
        List<Lottery> lotteries = lotteryCenter.generateTicket(issuedNumber);

        List<Integer> winning = Arrays.asList(1, 2, 3, 4, 5, 6);
        new LotteryCenter().checkWinningNumber(lotteries, winning);

        WinningResult winningResult = new LotteryCenter().calcStat(lotteries);
        List<String> result = winningResult.toList();
        assertThat(Float.parseFloat(result.get(4))).isLessThanOrEqualTo(1);
    }
}