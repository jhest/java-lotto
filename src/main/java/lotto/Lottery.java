package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottery {

    private final List<Integer> lotteryNumber;
    private int matchCount;

    public Lottery() {
        List<Integer> allNumber = new ArrayList<>();
        for (int i = 0; i < 46; i++) {
            allNumber.add(i + 1);
        }
        Collections.shuffle(allNumber);

        List<Integer> selectedNumber = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            selectedNumber.add(allNumber.get(i));
        }
        Collections.sort(selectedNumber);
        lotteryNumber = selectedNumber;
    }

    public List<Integer> selectedNumber() {
        return lotteryNumber;
    }

    public void winningCheck(int matchCount) {
        this.matchCount = matchCount;
    }

    public int isWinning() {
        return matchCount;
    }
}
