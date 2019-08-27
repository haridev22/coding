package DailyCoding;

public class StringifyBinaryTree {

    static class Node {
        String val;
        Node left;
        Node right;

        public Node(String val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        public Node(String val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static String serialize(Node root) {
        if (null == root)
            return "_null_";
        StringBuilder leftTree = new StringBuilder(serialize(root.left));
        StringBuilder rightTree = new StringBuilder(serialize(root.right));
        return new StringBuilder(root.val).append(';').append(leftTree).append(';').append(rightTree).toString();
    }

    public static Node deserialize(String tree) {
        int delimiterIndex = tree.indexOf(';');
        if (delimiterIndex == -1) {
            return new Node(tree);
        }
        String val = tree.substring(0, delimiterIndex);
        tree = tree.substring(delimiterIndex + 1);
        if(val.equals("_null_")){
            return null;
        }
        Node left = deserialize(tree);
        Node right =deserialize(tree);
        Node treeNode = new Node(val,left,right);
        return treeNode;
    }

    public static void main(String[] args) {
        Node root = new Node("root", new Node("left", new Node("left.left"), null), new Node("right"));
        System.out.println(deserialize(serialize(root)).val.equals(root.val));
    }
}
