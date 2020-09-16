package com.devon;

public class MaskUtil {

    public String maskCustomerContactString(String strContact) {
        int maskStart;
        int maskEnd;
        String maskedString;

        if(strContact == null || strContact.equals("") || strContact.length() > 80)
            return null;

        String[] portions = strContact.split("@");
        if (portions.length == 2 && portions[0].length() > 0) { // Contact is assumed as email address.
            if(portions[0].length() < 3) {
                maskStart = 0;
                maskEnd = portions[0].length();
            } else {
                maskStart = 1;
                maskEnd = portions[0].length() - 1;
            }
        } else if (portions.length == 1) { // Contact is assumed phone number.
            portions[0] = portions[0].replaceAll("\\D+","");
            if (portions[0].length() != 10)
                return null;
            maskStart = 3;
            maskEnd = 6;
        } else
            return null;

        maskedString = maskContactString(portions[0], maskStart, maskEnd);
        if (portions.length == 2)
            maskedString = maskedString  + "@" + portions[1];

        return maskedString;
    }

    private static String maskContactString(String strToMask, int maskStart, int maskEnd) {
        int maskLength = maskEnd - maskStart;

        if(maskLength == 0)
            return strToMask;

        String sbMaskString = "*".repeat(maskLength);

        return strToMask.substring(0, maskStart)
                + sbMaskString
                + strToMask.substring(maskStart + maskLength);
    }
}
