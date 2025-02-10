package baekjoon.b_1991;

import java.util.Scanner;

public class Main {

    static int n;
    static class Node {
        char data;
        Node left, right;

        public Node(char data) {
            this.data = data;
        }
    }
    static Node root;

    public static void createNode(char data, char left, char right) {
        if (root == null) {
            root = new Node(data);
            root.left = left != '.' ? new Node(left) : null;
            root.right = right != '.' ? new Node(right) : null;
        } else {
            addNode(root, data, left, right);
        }
    }

    public static void addNode(Node node, char data, char left, char right) {
        if (node == null) {
            return;
        } else if (node.data == data) {
            node.left = left != '.' ? new Node(left) : null;
            node.right = right != '.' ? new Node(right) : null;
        } else {
            addNode(node.left, data, left, right);
            addNode(node.right, data, left, right);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            createNode(sc.next().charAt(0), sc.next().charAt(0), sc.next().charAt(0));
        }

        front(root);
        System.out.println();
        middle(root);
        System.out.println();
        back(root);
    }

    static void front(Node node) {
        if (node == null) {return;}
        System.out.print(node.data);
        if(node.left != null) front(node.left);
        if(node.right != null) front(node.right);
    }

    static void middle(Node node) {
        if (node == null) {return;}
        if(node.left != null) middle(node.left);
        System.out.print(node.data);
        if(node.right != null) middle(node.right);
    }

    static void back(Node node) {
        if (node == null) {return;}
        if(node.left != null) back(node.left);
        if(node.right != null) back(node.right);
        System.out.print(node.data);
    }

}
