import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyTest {

    @Test
    public void chance() {
        assertEquals(15, Yatzy.chance(new Roll(2, 3, 4, 5, 1)));
        assertEquals(16, Yatzy.chance(new Roll(3, 3, 4, 5, 1)));
    }

    @Test
    public void yatzy() {
        assertEquals(50, Yatzy.yatzy(new Roll(4, 4, 4, 4, 4)));
        assertEquals(50, Yatzy.yatzy(new Roll(6, 6, 6, 6, 6)));
        assertEquals(0, Yatzy.yatzy(new Roll(6, 6, 6, 6, 3)));
        assertEquals(0, Yatzy.yatzy(new Roll(1, 6, 4, 6, 3)));
    }

    @Test
    public void ones() {
        assertEquals(1, Yatzy.ones(new Roll(1, 2, 3, 4, 5)));
        assertEquals(2, Yatzy.ones(new Roll(1, 2, 1, 4, 5)));
        assertEquals(0, Yatzy.ones(new Roll(6, 2, 2, 4, 5)));
        assertEquals(4, Yatzy.ones(new Roll(1, 2, 1, 1, 1)));
        assertEquals(5, Yatzy.ones(new Roll(1, 1, 1, 1, 1)));
        assertEquals(3, Yatzy.ones(new Roll(1, 1, 2, 5, 1)));
    }

    @Test
    public void twos() {
        assertEquals(4, Yatzy.twos(new Roll(1, 2, 3, 2, 6)));
        assertEquals(10, Yatzy.twos(new Roll(2, 2, 2, 2, 2)));
        assertEquals(8, Yatzy.twos(new Roll(1, 2, 2, 2, 2)));
        assertEquals(2, Yatzy.twos(new Roll(2, 5, 5, 5, 4)));
        assertEquals(0, Yatzy.twos(new Roll(3, 5, 5, 5, 4)));
        assertEquals(10, Yatzy.twos(new Roll(2, 2, 2, 2, 2)));
    }

    @Test
    public void threes() {
        assertEquals(6, Yatzy.threes(new Roll(1, 2, 3, 2, 3)));
        assertEquals(12, Yatzy.threes(new Roll(2, 3, 3, 3, 3)));
        assertEquals(0, Yatzy.threes(new Roll(4, 5, 5, 5, 4)));
    }

    @Test
    public void fours() {
        assertEquals(12, Yatzy.fours(new Roll(4, 4, 4, 5, 5)));
        assertEquals(8, Yatzy.fours(new Roll(4, 4, 5, 5, 5)));
        assertEquals(4, Yatzy.fours(new Roll(4, 5, 5, 5, 5)));
        assertEquals(0, Yatzy.fours(new Roll(5, 5, 5, 5, 5)));
    }

    @Test
    public void fives() {
        assertEquals(10, Yatzy.fives(new Roll(4, 4, 4, 5, 5)));
        assertEquals(15, Yatzy.fives(new Roll(4, 4, 5, 5, 5)));
        assertEquals(20, Yatzy.fives(new Roll(4, 5, 5, 5, 5)));
        assertEquals(0, Yatzy.fives(new Roll(4, 3, 3, 3, 3)));
    }

    @Test
    public void sixes() {
        assertEquals(0, Yatzy.sixes(new Roll(4, 4, 4, 5, 5)));
        assertEquals(6, Yatzy.sixes(new Roll(4, 4, 6, 5, 5)));
        assertEquals(18, Yatzy.sixes(new Roll(6, 5, 6, 6, 5)));
    }

    @Test
    public void pair() {
        assertEquals(6, Yatzy.pair(new Roll(3, 4, 3, 5, 6)));
        assertEquals(10, Yatzy.pair(new Roll(5, 3, 3, 3, 5)));
        assertEquals(12, Yatzy.pair(new Roll(5, 3, 6, 6, 5)));
        assertEquals(0, Yatzy.pair(new Roll(5, 3, 2, 4, 1)));
        assertEquals(12, Yatzy.pair(new Roll(1, 1, 6, 2, 6)));
        assertEquals(6, Yatzy.pair(new Roll(1, 3, 3, 3, 5)));
        assertEquals(6, Yatzy.pair(new Roll(3, 3, 3, 3, 1)));
    }

    @Test
    public void twoPairs() {
        assertEquals(16, Yatzy.twoPairs(new Roll(3, 3, 5, 4, 5)));
        assertEquals(16, Yatzy.twoPairs(new Roll(3, 3, 5, 5, 5)));
        assertEquals(6, Yatzy.twoPairs(new Roll(1, 1, 2, 2, 4)));
        assertEquals(6, Yatzy.twoPairs(new Roll(3, 3, 3, 3, 5)));
        assertEquals(8, Yatzy.twoPairs(new Roll(4, 4, 4, 4, 5)));
    }

    @Test
    public void threeOfAKind() {
        assertEquals(9, Yatzy.threeOfAKind(new Roll(3, 3, 3, 4, 5)));
        assertEquals(15, Yatzy.threeOfAKind(new Roll(5, 3, 5, 4, 5)));
        assertEquals(9, Yatzy.threeOfAKind(new Roll(3, 3, 3, 3, 5)));
        assertEquals(0, Yatzy.threeOfAKind(new Roll(3, 2, 4, 3, 5)));
        assertEquals(0, Yatzy.threeOfAKind(new Roll(3, 3, 4, 6, 5)));
        assertEquals(9, Yatzy.threeOfAKind(new Roll(3, 3, 3, 5, 5)));
    }

    @Test
    public void fourOfAKind() {
        assertEquals(12, Yatzy.fourOfAKind(new Roll(3, 3, 3, 3, 5)));
        assertEquals(20, Yatzy.fourOfAKind(new Roll(5, 5, 5, 4, 5)));
        assertEquals(12, Yatzy.fourOfAKind(new Roll(3, 3, 3, 3, 3)));
        assertEquals(0, Yatzy.fourOfAKind(new Roll(3, 1, 4, 4, 5)));
        assertEquals(0, Yatzy.fourOfAKind(new Roll(3, 4, 4, 4, 5)));
    }

    @Test
    public void smallStraight() {
        assertEquals(15, Yatzy.smallStraight(new Roll(1, 2, 3, 4, 5)));
        assertEquals(15, Yatzy.smallStraight(new Roll(2, 3, 4, 5, 1)));
        assertEquals(0, Yatzy.smallStraight(new Roll(1, 2, 2, 4, 5)));
    }

    @Test
    public void largeStraight() {
        assertEquals(20, Yatzy.largeStraight(new Roll(6, 2, 3, 4, 5)));
        assertEquals(20, Yatzy.largeStraight(new Roll(2, 3, 4, 5, 6)));
        assertEquals(0, Yatzy.largeStraight(new Roll(1, 2, 2, 4, 5)));
    }

    @Test
    public void fullHouse() {
        assertEquals(18, Yatzy.fullHouse(new Roll(6, 2, 2, 2, 6)));
        assertEquals(0, Yatzy.fullHouse(new Roll(2, 3, 4, 5, 6)));
        assertEquals(7, Yatzy.fullHouse(new Roll(2, 2, 1, 1, 1)));
        assertEquals(0, Yatzy.fullHouse(new Roll(5, 5, 5, 4, 5)));
        assertEquals(0, Yatzy.fullHouse(new Roll(5, 2, 5, 4, 5)));
        assertEquals(0, Yatzy.fullHouse(new Roll(5, 4, 5, 4, 3)));
    }
}