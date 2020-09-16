package com.devon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class MaskUtilTest {

    @Test
    void testForNullResponse() {
        MaskUtil mu = new MaskUtil();
        assertNull(mu.maskCustomerContactString(""));
        assertNull(mu.maskCustomerContactString("@"));
        assertNull(mu.maskCustomerContactString("@none.com"));
        assertNull(mu.maskCustomerContactString("abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.1234567890@never.net"));
        assertNull(mu.maskCustomerContactString("123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890"));
        assertNull(mu.maskCustomerContactString("1-800-555-1234"));
        assertNull(mu.maskCustomerContactString("123"));
        assertNull(mu.maskCustomerContactString("**********"));
    }

    @Test
    void testEmailContactMask() {
        MaskUtil mu = new MaskUtil();
        assertEquals("*@one.com", mu.maskCustomerContactString("i@one.com"));
        assertEquals("**@two.net", mu.maskCustomerContactString("tu@two.net"));
        assertEquals("a*c@thd.org", mu.maskCustomerContactString("abc@thd.org"));
        assertEquals("D*********h@thd.org", mu.maskCustomerContactString("DevonPSmith@thd.org"));
        assertEquals("m*******************l@gmail.com", mu.maskCustomerContactString("many.characters.email@gmail.com"));
        assertEquals("D*********h@thd.org", mu.maskCustomerContactString("DevonPSmith@thd.org"));
    }

    @Test
    void testPhoneContactMask() {
        MaskUtil mu = new MaskUtil();
        assertEquals("404***1234", mu.maskCustomerContactString("(404) 555-1234"));
        assertEquals("800***4444", mu.maskCustomerContactString("8001234444"));
        assertEquals("555***5555", mu.maskCustomerContactString("555.123.5555"));
        assertEquals("222***2222", mu.maskCustomerContactString("222 222 2222"));
        assertEquals("123***7890", mu.maskCustomerContactString("1234567890    "));
    }
}