package com.kipras;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Compression:");
        System.out.println("\"aaabb\" -> " + "\"" + StringUtils.compressString("aaabb") + "\"");
        System.out.println("\"abc\" -> " + "\"" + StringUtils.compressString("abc") + "\"");
        System.out.println("\"\" -> " + "\"" + StringUtils.compressString("") + "\"");

        System.out.println("Decompression:");
        System.out.println("\"a3b2\" -> " + "\"" + StringUtils.decompressString("a3b2") + "\"");
        System.out.println("\"a1b1c1\" -> " + "\"" + StringUtils.decompressString("a1b1c1") + "\"");
        System.out.println("\"\" -> " + "\"" + StringUtils.decompressString("") + "\"");
    }
}
