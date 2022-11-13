package utils;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public List<Integer> convertToLuckyNumber(String input) {
        List<Integer> luckyNumber = new ArrayList<>();

        addNumber(luckyNumber, getNumbers(input));
        return luckyNumber;
    }

    private String[] getNumbers(String input) {
        return input.split(",");
    }

    private void addNumber(List<Integer> luckyNumber, String[] numbers) {
        for (int index = 0; index < numbers.length; index++) {
            luckyNumber.add(Integer.parseInt(numbers[index]));
        }
    }
}
