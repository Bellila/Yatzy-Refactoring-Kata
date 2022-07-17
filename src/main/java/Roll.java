import java.util.*;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

public class Roll {

    private final List<Integer> dices;

    public Roll(int d1, int d2, int d3, int d4, int d5) {
        this.dices = asList(d1, d2, d3, d4, d5);
    }

    public boolean isYatzy() {
        if (this.dices.stream().distinct().count() == 1) {
            return true;
        }
        return false;
    }

    public boolean isSmallStraight() {
        return this.dices
                .stream()
                .sorted()
                .collect(toList())
                .equals(asList(1, 2, 3, 4, 5));
    }

    public boolean isLargeStraight() {
        return this.dices
                .stream()
                .sorted()
                .collect(toList())
                .equals(asList(2, 3, 4, 5, 6));
    }

    public int countDiceByNumber(int diceNumber) {
        return this.dices
                .stream()
                .filter(dice -> dice == diceNumber)
                .reduce(0, (sum, die) -> sum + die);
    }

    public int sum() {
        return this.dices
                .stream()
                .reduce(0, (sum, die) -> sum + die);
    }

    public IntStream getDiceWithCountGreaterThan(int number) {
        return this.dices
                .stream()
                .collect(groupingBy(identity(), counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() >= number)
                .mapToInt(Map.Entry::getKey);
    }

    public boolean isFullHouse() {
        List<Long> expectedResult = Arrays.asList(2L, 3L);
        List<Long> result = this.dices
                .stream()
                .collect(groupingBy(identity(), counting()))
                .values()
                .stream()
                .sorted()
                .collect(toList());
        return expectedResult.equals(result);
    }

}
