package lotto.domain;

import java.util.HashMap;
import java.util.List;

import static lotto.domain.ErrorMessage.*;
import static lotto.domain.LottoStatus.SIZE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != SIZE.getValue()) {
            throw new IllegalArgumentException(LOTTO_INCORRECT_SIZE.toString());
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.forEach(this::isOutOfRange);
    }

    private Integer getNumber(List<Integer> numbers, int index) {
        return numbers.get(index);
    }

    private void isOutOfRange(int number) {
        if (number < LottoStatus.START.getValue() || number > LottoStatus.END.getValue()) {
            throw new IllegalArgumentException(LOTTO_OUT_OF_RANGE.toString());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        HashMap<Integer, Integer> exist = new HashMap<>();
        addExist(numbers, exist);
        if (exist.size() != SIZE.getValue()) {
            throw new IllegalArgumentException(LOTTO_DUPLICATION.toString());
        }
    }

    private void addExist(List<Integer> numbers, HashMap<Integer, Integer> exist) {
        for (int index = 0; index < numbers.size(); index++) {
            Integer number = getNumber(numbers, index);
            exist.put(number, exist.getOrDefault(number, 0) + 1);
        }
    }
}
