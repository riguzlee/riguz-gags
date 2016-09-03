package com.riguz.gags.test.encrypt;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.riguz.gags.encrypt.Hashs;
import com.riguz.gags.encrypt.Hex;

public class UsingHashsKit {
    @Test
    public void useMd5() {
        assertEquals("5eb63bbbe01eeed093cb22bb8f5acdc3", Hashs.md5("hello world"));
        assertEquals("e01eeed093cb22bb", Hashs.md5_16("hello world"));
        assertEquals("66f561bb6b68372213dd9768e55e1002", Hashs.md5("123456çñ"));
        assertEquals("6b68372213dd9768", Hashs.md5_16("123456çñ"));

        String cjk = "你好おはようございますприветHello01010101";
        assertEquals("35412c617c0ee40e8654f011ce2eb82e", Hashs.md5(cjk));
    }

    @Test
    public void useHashs() {
        String plain = "你好おはようございますприветHello01010101";
        String md5 = "35412c617c0ee40e8654f011ce2eb82e";
        String sha1 = "309b4c3fd96ca11bd9553b4c0eba9f542bce9dfa";
        String sha224 = "36ce99d16f49e9326bf36c6fc86963986372c44fddf7145eda951fca";
        String sha384 = "9ec3f116ed90e5955c79fa2214939878eaf7e3e8afe063e2cdee17d3457ccc419946159671631cf128d435004e73885f";
        String sha256 = "9bab64f4511ffc049096727f5ed7b47ec938a7afc4435c0b8168bf592953b6af";
        String sha512 = "89db3848740a52938037cf476df2cde8b2a2d9cb1739a8275791a6aca739161a0b46bd44fa7638d9fbc62b955d70f0b9cb263186608cc5b57da78462b93e76a3";

        assertEquals(md5, Hashs.md5(plain));
        assertEquals(sha1, Hashs.sha1(plain));
        assertEquals(sha224, Hashs.sha224(plain));
        assertEquals(sha384, Hashs.sha384(plain));
        assertEquals(sha256, Hashs.sha256(plain));
        assertEquals(sha512, Hashs.sha512(plain));
    }

    @Test
    public void useHashViewer() {
        String t = "123456çñ123456çñ123456çñ123456çñ123456ab";
        String s = Hex.hexViewer(t.getBytes());
        System.out.println(s);
        System.out.println();
        assertEquals(true, s.endsWith("ab"));
        String s1 = Hex
                .hexViewer(new byte[] { (byte) 0x80, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00 });
        System.out.println(s1);
    }
}
