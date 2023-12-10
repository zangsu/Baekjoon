import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeSize = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[nodeSize + 1];
        for (int i = 1; i <= nodeSize; i++) {
            nodes[i] = new Node(i);
        }

        for(int i = 0; i < nodeSize - 1; i++){
            String[] input = br.readLine().split(" ");
            int node1 = Integer.parseInt(input[0]);
            int node2 = Integer.parseInt(input[1]);
            nodes[node1].addLink(nodes[node2]);
            nodes[node2].addLink(nodes[node1]);
        }

        boolean[] visited = new boolean[nodeSize + 1];
        visited[1] = true;
        nodes[1].findChild(visited);

        for(int i = 2; i <= nodeSize; i++){
            System.out.println(nodes[i].parents.nodeNum);
        }

    }
}

class Node {
    final int nodeNum;
    private List<Node> links = new ArrayList<>();
    Node parents;

    public Node(int nodeNum){
        this.nodeNum = nodeNum;
    }

    public void addLink(Node node){
        links.add(node);
    }

    public void removeLink(Node node){
        links.remove(node);
    }

    public void findChild(boolean[] visited){
        visited[nodeNum] = true;
        links.stream()
                .filter(node -> !visited[node.nodeNum])
                .forEach(node -> {
                    node.removeLink(this);
                    node.parents = this;
                    node.findChild(visited);
                });
    }
}