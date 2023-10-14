package utils.implementation;

import utils.compression.Leaf;
import utils.compression.Node;
import utils.compression.Tree;

import java.util.PriorityQueue;

public class CompressionImplementation {
    Tree tree = null;
    private static CompressionImplementation instance;

    private CompressionImplementation() {
        // Initiate the tree with all possible characters
        String allPossibleValues = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        int[] calculatedFrequency = this.calculateFrequency(allPossibleValues);
        tree = buildTree(calculatedFrequency);
    }

    public static CompressionImplementation getInstance() {
        if (instance == null) {
            instance = new CompressionImplementation();
        }

        return instance;
    }

    public String getEncodedCharacter(String valueToEncode) {
        return this.encode(tree, valueToEncode);
    }

    public String getDecodedValue(String valueToDecode) {
        return decode(tree, valueToDecode);
    }

    public void getPrintFunction() {
        this.printCodes(tree, new StringBuffer());
    }

    public int[] calculateFrequency(String valueToCompress) {
        int[] charactersFrequency = new int[256];
        for (char c : valueToCompress.toCharArray()) {
            charactersFrequency[c]++;
        }

        return charactersFrequency;
    }

    public Tree buildTree(int[] charactersFrequency) {
        PriorityQueue<Tree> priorityTrees = new PriorityQueue<>();

        for (int i = 0; i < charactersFrequency.length; i++){
            if (charactersFrequency[i] > 0) {
                priorityTrees.offer(new Leaf(charactersFrequency[i], (char)i));
            }
        }

        while (priorityTrees.size() > 1) {
            Tree firstTree = priorityTrees.poll();
            Tree secondTree = priorityTrees.poll();
            assert secondTree != null;
            priorityTrees.offer(new Node(firstTree, secondTree));
        }

        return priorityTrees.poll();
    }

    public String encode(Tree tree, String encode){
        assert tree != null;

        String encodeText = "";
        for (char c : encode.toCharArray()){
            encodeText = encodeText + (getCodes(tree, new StringBuffer(),c));
        }
        return encodeText;
    }

    public String decode(Tree tree, String encode) {
        assert tree != null;

        String decodeText="";
        Node node = (Node) tree;
        for (char code : encode.toCharArray()){
            if (code == '0'){
                if (node.left instanceof Leaf) {
                    decodeText = decodeText + ((Leaf)node.left).value;
                    node = (Node) tree;
                }else{
                    node = (Node) node.left;
                }
            }else if (code == '1'){
                if (node.right instanceof Leaf) {
                    decodeText = decodeText + ((Leaf)node.right).value;
                    node = (Node)tree;
                }else{
                    node = (Node) node.right;
                }
            }
        }
        return decodeText;
    }

    public void printCodes(Tree tree, StringBuffer prefix) {
        assert tree != null;

        if (tree instanceof Leaf leaf) {
            System.out.println(leaf.value + "\t" + leaf.frequency + "\t\t" + prefix);
        } else if (tree instanceof Node node) {

            prefix.append('0');
            printCodes(node.left, prefix);
            prefix.deleteCharAt(prefix.length()-1);

            prefix.append('1');
            printCodes(node.right, prefix);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }

    public String getCodes(Tree tree, StringBuffer valuePrefix, char character) {
        assert tree != null;

        if (tree instanceof Leaf leaf) {
            if (leaf.value == character ){
                return valuePrefix.toString();
            }

        } else if (tree instanceof Node nodeTree) {
            valuePrefix.append('0');
            String leftCodes = getCodes(nodeTree.left, valuePrefix, character);
            valuePrefix.deleteCharAt(valuePrefix.length()-1);

            valuePrefix.append('1');
            String rightCodes = getCodes(nodeTree.right, valuePrefix,character);
            valuePrefix.deleteCharAt(valuePrefix.length()-1);

            if (leftCodes == null) {
                return rightCodes;
            } else {
                return leftCodes;
            }
        }
        return null;
    }


}
