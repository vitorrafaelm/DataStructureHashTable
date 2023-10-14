package utils.compression;

public class Leaf extends Tree {
    public final char value;

    public Leaf(int freq, char val) {
        super(freq);
        value = val;
    }
}
