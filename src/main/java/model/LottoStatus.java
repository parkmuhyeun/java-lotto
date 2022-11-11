package model;

public enum LottoStatus {
    SIZE(6);

    private final int value;

    LottoStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
