package utilities;

import java.util.regex.Pattern;

public class ValidationUtils {


    public static boolean isValidCode(String code) {
        return Pattern.matches("CPT-\\d{5}", code);
    }

    public static boolean isValidMontant(double montant) {
        return montant > 0;
    }
}
