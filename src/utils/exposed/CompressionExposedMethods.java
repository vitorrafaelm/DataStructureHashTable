package utils.exposed;

import utils.implementation.CompressionImplementation;

public class CompressionExposedMethods {
    CompressionImplementation compressionImplementation = CompressionImplementation.getInstance();

    public String encode(String valueToEncode) {
        return compressionImplementation.getEncodedCharacter(valueToEncode);
    }

    public String decode(String valueToDecode) {
        return compressionImplementation.getDecodedValue(valueToDecode);
    }

    public void printCodesAndBits() {
        compressionImplementation.getPrintFunction();
    }
}
