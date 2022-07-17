public class Yatzy {

    public static int chance(Roll roll) {
        return roll.sum();
    }

    public static int yatzy(Roll roll) {
        if (roll.isYatzy()) {
            return 50;
        }
        return 0;
    }

    public static int ones(Roll roll) {
        return roll.countDiceByNumber(1);
    }

    public static int twos(Roll roll) {
        return roll.countDiceByNumber(2);
    }

    public static int threes(Roll roll) {
        return roll.countDiceByNumber(3);
    }

    public static int fours(Roll roll) {
        return roll.countDiceByNumber(4);
    }

    public static int fives(Roll roll) {
        return roll.countDiceByNumber(5);
    }

    public static int sixes(Roll roll) {
        return roll.countDiceByNumber(6);
    }

    public static int pair(Roll roll) {
        int number = 2;
        return roll
                .getDiceWithCountGreaterThan(number)
                .max()
                .orElse(0) * number;
    }

    public static int twoPairs(Roll roll) {
        int number = 2;
        return roll
                .getDiceWithCountGreaterThan(number)
                .sum() * number;
    }

    public static int fourOfAKind(Roll roll) {
        int number = 4;
        return roll
                .getDiceWithCountGreaterThan(number)
                .findFirst()
                .orElse(0) * number;
    }

    public static int threeOfAKind(Roll roll) {
        int number = 3;
        return roll
                .getDiceWithCountGreaterThan(number)
                .findFirst()
                .orElse(0) * number;
    }

    public static int smallStraight(Roll roll) {
        if (roll.isSmallStraight()) {
            return 15;
        }
        return 0;
    }

    public static int largeStraight(Roll roll) {
        if (roll.isLargeStraight()) {
            return 20;
        }
        return 0;
    }

    public static int fullHouse(Roll roll) {
        if (roll.isFullHouse()) {
            return roll.sum();
        }
        return 0;
    }
}


