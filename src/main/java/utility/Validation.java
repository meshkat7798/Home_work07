package utility;

import java.util.regex.Pattern;

public class Validation {
    public static boolean isValidPassword(String password) {
        Pattern pattern =
                Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
        return password.matches(pattern.pattern());
    }
    public static boolean isValidEmail (String email) {
        Pattern pattern =
                Pattern.compile("^[\\w-.]+@([\\w-]+.)+[\\w-]{2,4}$");
        return email.matches(pattern.pattern());

    }
    public static boolean isValidWebsite (String website) {
        Pattern pattern =
                Pattern.compile("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~|!:,.;]*[-a-zA-Z0-9+&@#/%=~|]");
        return website.matches(pattern.pattern());
    }
    public static boolean isValidPhoneNumber (String phoneNumber) {
        Pattern pattern =
                Pattern.compile("^\\d{11}$");
        return phoneNumber.matches(pattern.pattern());
    }
    public static boolean isValidNationalityCode (String nationalityCode) {
        Pattern pattern =
                Pattern.compile("^\\d{10}$");
        return nationalityCode.matches(pattern.pattern());
    }
}
