package model;

public class Calculator {
    public static float calculator(float stn, float sth, char operator) {
        switch (operator) {
            case '+':
                return stn + sth;
            case '-':
                return stn - sth;
            case '*':
                return stn * sth;
            case '/':
                if (sth != 0)
                    return stn / sth;
                else
                    throw new RuntimeException("không thể chia cho số 0");
            default:
                throw new RuntimeException("hoạt động không hợp lệ");
        }
    }
}
