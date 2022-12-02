package lotto.domain;

import lotto.dto.ResultResponse;
import java.text.DecimalFormat;

public enum NoticeMessage {
    PURCHASING_AMOUNT{
        @Override
        public String toString() {
            return "구입금액을 입력해 주세요.";
        }
    },
    LOTTO_COUNT{
        @Override
        public String toString() {
            return "개를 구매했습니다.";
        }
    },
    LUCKY_NUMBER{
        @Override
        public String toString() {
            return "당첨 번호를 입력해 주세요.";
        }
    },
    BONUS_NUMBER{
        @Override
        public String toString() {
            return "보너스 번호를 입력해 주세요.";
        }
    },
    WINNING_STATISTICS{
        @Override
        public String toString() {
            return "당첨 통계\n" +
                    "---";
        }
    },
    ADDITIONAL_SECOND{
        @Override
        public String toString() {
            return ", 보너스 볼 일치";
        }
    };

    public static String printWinningStatistics(ResultResponse result, int rank) {
        WinningNumberStatus winningNumberStatus = WinningNumberStatus.getWinningNumberStatusByOrder(rank);
        DecimalFormat decimalFormat = new DecimalFormat("###,###");

        return winningNumberStatus.getCount() + "개 일치" + getAdditionalSecondNotice(rank)
                + " (" + decimalFormat.format(winningNumberStatus.getMoney())+ "원) - "
                + result.getResult().get(rank) + "개";
    }

    private static String getAdditionalSecondNotice(int rank) {
        if (rank == WinningNumberStatus.SECOND.getOrder()) {
            return ADDITIONAL_SECOND.toString();
        }
        return "";
    }

    public static String printEarningRate(double earningRate) {
        return "총 수익률은 " + getEarningRate(earningRate) + "%입니다.";
    }

    private static String getEarningRate(double earningRate) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        String format = String.format("%.1f", earningRate);
        return getNumber(decimalFormat, format) + getDecimal(format);
    }

    private static String getDecimal(String format) {
        int length = format.length();
        return format.substring(length - 2, length);
    }

    private static String getNumber(DecimalFormat decimalFormat, String format) {
        return decimalFormat.format(Long.parseLong(format.substring(0, format.length() - 2)));
    }
}
