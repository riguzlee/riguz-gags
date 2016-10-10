package com.riguz.gags.test.base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.riguz.gags.base.Strings;

public class UsingKits {
    @Test
    public void useStrings() {
        assertEquals("", Strings.nullToEmpty(null));
        assertEquals("123", Strings.nullToEmpty("123"));
        
        assertEquals(true, Strings.isNullOrEmpty(null));
        assertEquals(true, Strings.isNullOrEmpty(""));
        assertEquals(false, Strings.isNullOrEmpty("abc"));
        assertEquals(false, Strings.isNullOrEmpty(" "));
        assertEquals(false, Strings.isNullOrEmpty("\t"));
        
        
        assertEquals(true, Strings.isBlankOrEmpty(null));
        assertEquals(true, Strings.isBlankOrEmpty(""));
        assertEquals(true, Strings.isBlankOrEmpty(" "));
        assertEquals(true, Strings.isBlankOrEmpty("\t"));
        
        assertEquals(false, Strings.isWhitespace(null));
        assertEquals(true, Strings.isWhitespace(""));
        assertEquals(true, Strings.isWhitespace(" "));
        assertEquals(true, Strings.isWhitespace("\t"));
        
        assertEquals("00000001", Strings.padStart("1", 8, '0'));
        assertEquals("10000000", Strings.padEnd("1", 8, '0'));
        assertEquals("12345", Strings.padStart("12345", 5, '0'));
        assertEquals("12345", Strings.padEnd("12345", 5, '0'));
    }
}
