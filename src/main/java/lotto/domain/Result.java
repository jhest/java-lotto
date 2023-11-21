package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {
    
    private final List<Long> result = new ArrayList<>();

    public Result() {
    }

    public void add(long count) {
        result.add(count);
    }

    public int get(int index) {
        return Math.toIntExact(result.get(index));
    }
}
