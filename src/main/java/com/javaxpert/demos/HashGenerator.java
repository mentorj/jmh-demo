package com.javaxpert.demos;

/**
 * very simple abstraction for Codecs  computing  hashes
 */
public interface HashGenerator {

    int generate32BitsHash(String input);

    long generate128BitsHash(String  input);
}
