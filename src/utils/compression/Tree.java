package utils.compression;

public class Tree implements Comparable<Tree> {
    public final int frequency;
    public Tree(int freq) {
        frequency = freq;
    }
    public int compareTo(Tree tree) {
        return frequency - tree.frequency;
    }
}
