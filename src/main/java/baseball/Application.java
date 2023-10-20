package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        List<Integer> computerNumbers;
        List<Integer> playerNumbers;

        displayGameStartMessage();
        computerNumbers = generateComputerNumbers();
        playerNumbers = inputPlayerNumbers();
    }

    public static void displayGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static List<Integer> generateComputerNumbers() {
        List<Integer> computerNumbers;

        computerNumbers = new ArrayList<>();

        while (computerNumbers.size() < 3) {
            int randomNumber;

            randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }

    public static List<Integer> inputPlayerNumbers() {
        String inputNumbers;
        List<Integer> playerNumbers;
        Set<Integer> playerNumbersSet;

        System.out.print("숫자를 입력해주세요 : ");
        inputNumbers = Console.readLine();

        if (!isThreeLength(inputNumbers)) {
            throw new IllegalArgumentException("3자리의 수를 입력해주세요.");
        }

        for (int i = 0; i < inputNumbers.length(); i++) {
            if (!isBetween1and9(inputNumbers.charAt(i))) {
                throw new IllegalArgumentException("1~9로 이루어진 3자리의 수를 입력해주세요.");
            }
        }

        playerNumbers = convertStringToIntList(inputNumbers);
        playerNumbersSet = new HashSet<>(playerNumbers);

        if (playerNumbersSet.size() != 3) {
            throw new IllegalArgumentException("서로 다른 3개의 숫자로 이루어진 수를 입력해주세요.");
        }
        return playerNumbers;
    }

    public static boolean isThreeLength(final String inputNumbers) {
        return inputNumbers.length() == 3;
    }

    public static boolean isBetween1and9(final char inputNumber) {
        return inputNumber >= '1' && inputNumber <= '9';
    }

    public static List<Integer> convertStringToIntList(final String inputString) {
        List<Integer> outputList = new ArrayList<>();

        for (int i = 0; i < inputString.length(); i++) {
            outputList.add(inputString.charAt(i) - '0');
        }
        return outputList;
    }
}
