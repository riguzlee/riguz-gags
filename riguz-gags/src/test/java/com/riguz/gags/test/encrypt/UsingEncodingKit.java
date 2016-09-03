package com.riguz.gags.test.encrypt;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.riguz.gags.encrypt.Encoding;

public class UsingEncodingKit {
    @Test
    public void testBase64(){
        String p = "hello", e = "aGVsbG8=";
        assertEquals(e, Encoding.toBase64(p));
        assertEquals(p, Encoding.fromBase64(e));
        
        p = "你好おはようございますприветHello01010101";
        e = "5L2g5aW944GK44Gv44KI44GG44GU44GW44GE44G+44GZ0L/RgNC40LLQtdGCSGVsbG8wMTAxMDEwMQ==";
        assertEquals(e, Encoding.toBase64(p).replaceAll("\\r\\n", ""));
        assertEquals(p, Encoding.fromBase64(e));
    }
}
