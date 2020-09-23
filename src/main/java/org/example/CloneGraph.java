package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {

    public static Node cloneGraph(Node node) {

        if(node == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        Map<Node, Node> cloneRef = new HashMap<>();

        Node cloneNode = new Node(node.val, new ArrayList<Node>());
        cloneRef.put(node, cloneNode);
        queue.add(node);

        while(!queue.isEmpty()) {

            Node current = queue.poll();

            for(Node originalNodeNeighbor : current.neighbors) {
                if(!cloneRef.containsKey(originalNodeNeighbor)){
                    //Add current node neighbors to queue
                    queue.add(originalNodeNeighbor);
                    Node newCloneNode = new Node(originalNodeNeighbor.val, new ArrayList<Node>());
                    cloneRef.put(originalNodeNeighbor, newCloneNode);
                    cloneRef.get(current).neighbors.add(newCloneNode);
                }else {
                    cloneRef.get(current).neighbors.add(cloneRef.get(originalNodeNeighbor));
                }
            }


        }
        return cloneNode;
    }

    public static void main( String[] args )
    {

        /*Node noode5 = new Node(5, new ArrayList<Node>());
        Node noode4 = new Node(4, Arrays.asList(noode5));
        Node noode3 = new Node(3, Arrays.asList(noode4));
        Node noode2 = new Node(2, Arrays.asList(noode4, noode5));
        Node rootNode = new Node(1, Arrays.asList(noode2, noode3));*/

        Node node4 = new Node(4, new ArrayList<Node>());
        Node node3 = new Node(3, new ArrayList<Node>(Arrays.asList(node4)));
        Node node2 = new Node(2, new ArrayList<Node>(Arrays.asList(node4)));
        Node rootNode = new Node(1, new ArrayList<Node>(Arrays.asList(node2, node3)));

        node2.neighbors.add(rootNode);
        node3.neighbors.add(rootNode);
        node4.neighbors.add(node3);
        node4.neighbors.add(node4);
        System.out.println(cloneGraph(rootNode));

    }
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }


    }
}
