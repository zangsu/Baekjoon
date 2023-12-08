import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Main {

    public static final String NO_CHILD = ".";
    private static final Map<Character, Node> nodes = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeNum = Integer.parseInt(br.readLine());
        /*Node[] nodes = new Node[nodeNum];
        Arrays.fill(nodes, new Node());*/
        char start = 'A';
        for (int i = 0; i < nodeNum; i++) {
            char name = (char) (start + i);
            nodes.put(name, new Node(name));
        }

        Node root = getNode("A");
        for (int node = 0; node < nodeNum; node++) {
            String[] input = br.readLine().split(" ");
            Node parents = getNode(input[0]);
            parents.left = getNode(input[1]);
            parents.right = getNode(input[2]);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        prefix(root, bw);
        bw.write(System.lineSeparator());
        infix(root, bw);
        bw.write(System.lineSeparator());
        postfix(root, bw);
        bw.flush();
        bw.close();

    }

    private static void postfix(Node node, BufferedWriter bw) throws IOException {
        if (node.left != Node.NO_NODE) {
            postfix(node.left, bw);
        }
        if (node.right != Node.NO_NODE) {
            postfix(node.right, bw);
        }
        bw.write(node.name);
    }

    private static void infix(Node node, BufferedWriter bw) throws IOException {
        if (node.left != Node.NO_NODE) {
            infix(node.left, bw);
        }
        bw.write(node.name);
        if (node.right != Node.NO_NODE) {
            infix(node.right, bw);
        }
    }

    private static Node getNode(String name){
        if (NO_CHILD.equals(name)) {
            return Node.NO_NODE;
        }
        return Optional.ofNullable(nodes.get(name.charAt(0)))
                .orElse(Node.NO_NODE);
    }

    private static void prefix(Node node, BufferedWriter bw) throws IOException {
        bw.write(node.name);
        if (node.left != Node.NO_NODE) {
            prefix(node.left, bw);
        }
        if (node.right != Node.NO_NODE) {
            prefix(node.right, bw);
        }
    }
}
class Node{
    public static final Node NO_NODE = new Node('.');
    String name;
    Node left;
    Node right;

    public Node(char name) {
        this.name = String.valueOf(name);
    }

    static Node getNoNode(){
        return NO_NODE;
    }

}