package com.kipras;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AppTest 
{
    @Test
    public void testCompressString()
    {
        assertEquals("a3b2", StringUtils.compressString("aaabb"));
        assertEquals("a1b1c1", StringUtils.compressString("abc"));
        assertEquals("", StringUtils.compressString(""));
        assertEquals("a1", StringUtils.compressString("a"));
        assertEquals("a2b1a2", StringUtils.compressString("aabaa"));
        assertEquals("a10", StringUtils.compressString("aaaaaaaaaa"));
        assertEquals("a100", StringUtils.compressString("a".repeat(100)));
    }

    @Test
    public void testDecompressString()
    {
        assertEquals("aaabb", StringUtils.decompressString("a3b2"));
        assertEquals("abc", StringUtils.decompressString("a1b1c1"));
        assertEquals("", StringUtils.decompressString(""));
        assertEquals("a", StringUtils.decompressString("a1"));
        assertEquals("aabaa", StringUtils.decompressString("a2b1a2"));
        assertEquals("aaaaaaaaaa", StringUtils.decompressString("a10"));
        assertEquals("a".repeat(100), StringUtils.decompressString("a100"));
    }

    @Test
    public void testCompressAndDecompress()
    {
        String original = "aaabb";
        String compressed = StringUtils.compressString(original);
        String decompressed = StringUtils.decompressString(compressed);
        assertEquals(original, decompressed);

        original = "a".repeat(100);
        compressed = StringUtils.compressString(original);
        decompressed = StringUtils.decompressString(compressed);
        assertEquals(original, decompressed);

        original = "aabaa";
        compressed = StringUtils.compressString(original);
        decompressed = StringUtils.decompressString(compressed);
        assertEquals(original, decompressed);

        original = "abc";
        compressed = StringUtils.compressString(original);
        decompressed = StringUtils.decompressString(compressed);
        assertEquals(original, decompressed);

        original = "a".repeat(1000);
        compressed = StringUtils.compressString(original);
        decompressed = StringUtils.decompressString(compressed);
        assertEquals(original, decompressed);
    }
}
