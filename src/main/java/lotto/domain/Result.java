package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private final List<Rank> result = new ArrayList<>();

    public Result() {
    }

    public void add(Rank rank) {
        result.add(rank);
    }

    public List<Rank> getResult() {
        return result;
    }
}