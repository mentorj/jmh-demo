package com.javaxpert.demos.adapters;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.javaxpert.demos.HashGenerator;

import java.nio.charset.Charset;

public class GuavaCodecAdapter implements HashGenerator {
    private HashFunction codec;
    public GuavaCodecAdapter() {

    }

    @Override
    public int generate32BitsHash(String input) {
        codec = Hashing.murmur3_32_fixed();
        return codec.hashString(input, Charset.defaultCharset()).asInt();
    }

    @Override
    public long generate128BitsHash(String input) {
        codec=Hashing.murmur3_128();
        return codec.hashString(input,Charset.defaultCharset()).asLong();
    }
}
