package com.javaxpert.demos.adapters;

import com.javaxpert.demos.HashGenerator;
import org.apache.commons.codec.digest.MurmurHash3;

/**
 * adapter class for Apache Commons Codec library
 * @author deadbrain
 */
public class CommonsCodecsAdapter implements HashGenerator {
    @Override
    public int generate32BitsHash(String input) {
        return MurmurHash3.hash32x86(input.getBytes());
    }

    @Override
    public long generate128BitsHash(String input) {
        return MurmurHash3.hash128(input.getBytes())[0];
    }
}
