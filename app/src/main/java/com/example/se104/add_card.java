package com.example.se104;
import android.text.Editable;
import android.text.TextWatcher;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Scanner;
import java.util.Locale;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class add_card {
    private String cardOwner;
    private String cardNumber;
    private String expDate;
    private String cvv;

    public add_card(String cardOwner, String cardNumber, String expDate, String cvv) {
        this.cardOwner = cardOwner;
        this.cardNumber = cardNumber;
        this.expDate = expDate;
        this.cvv = cvv;

        if (check_name(cardOwner) == false)
            System.out.println("Tên chủ thẻ sai");
        else if (check_number(cardNumber) == false)
            System.out.println("Số thẻ phải có 16 chữ số theo quy định");
        else if (check_exp(expDate) == false)
            System.out.println("Ngày hết hạn không hợp lệ");
        else if (check_cvv(cvv) == false)
            System.out.println("CVV không hợp lệ");
        else if (check_first_digit() == false)
            System.out.println("Loại thẻ không hợp lệ");
        else
            System.out.println("Thẻ hợp lệ");


    }



    public boolean check_name(String cardOwner) { // Kiểm tra tên chủ thẻ
        if (cardOwner.length()  == 0) {
            return false; // Tên chủ thẻ không được bằng 0
        } else if (isAlphabetString(cardOwner) == false) {
            return false; // Tên chủ thẻ không được chứa số, ký tự đặc biệt
        }
        return true;
    }

    public static boolean isAlphabetString(String input) { //Kiểm tra tên chủ thẻ có phải là chữ cái (alphabet) không
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    public boolean check_number(String cardNumber) { // Kiểm tra số thẻ
        if (cardNumber.length() != 16) {
            return false; // Số thẻ phải có 16 chữ số theo quy định
        }
        return true;
    }

    public boolean check_exp(String expDate) { // Kiểm tra ngày hết hạn
        if (expDate.length() != 5) {
            return false; // Ngày hết hạn không hợp lệ
        } else {
            int month = (int) Double.parseDouble(expDate.substring(0, 2));
            int year = (int) Double.parseDouble(expDate.substring(3, 5));
            if (isValidExpirationDate(month, year) == false) {
                return false; // Ngày hết hạn không hợp lệ
            }
            return true; // Ngày hết hạn hợp lệ
        }
    }

    public boolean check_cvv(String cvv) { // Kiểm tra CVV
        if (cvv.length() != 3 && cvv.length() != 4) {
            return false; // CVV không hợp lệ
        } else if (isNumericString(cvv) == false) {
            return false; // CVV không được chứa chữ cái, ký tự đặc biệt
        }
        return true; // Thẻ hợp lệ
    }

    public boolean isNumericString(String input) { // Kiểm tra chuỗi có phải là số không
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean check_first_digit() { // Kiểm tra số đầu tiên của thẻ
        String firstDigit = cardNumber.substring(0, 1);
        if (firstDigit.equals("4")) {
            // Visa card
            return true;
        } else if (firstDigit.equals("5")) {
            // MasterCard
            return true;
        }
        return false; // Loại thẻ không hợp lệ
    }

    public boolean isValidExpirationDate(int month, int year) {
        // Kiểm tra xem tháng và năm có hợp lệ không
        if (month < 1 || month > 12) {
            return false;
        }

        int currentYear = LocalDate.now().getYear() % 100 ;
        int currentMonth = LocalDate.now().getMonthValue();

        // Kiểm tra xem ngày hết hạn đã qua hay chưa
        if (year < currentYear || (year == currentYear && month < currentMonth)) {
            return false;
        }

        return true;
    }


}


