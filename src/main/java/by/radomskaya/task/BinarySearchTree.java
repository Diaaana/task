package by.radomskaya.task;

class BinarySearchTree {
    private Node root;

    static class Node {
        int key;
        int value;
        Node left;
        Node right;
        Node element;

        Node(int key, int value, Node element) {
            this.key = key;
            this.value = value;
            this.element = element;
        }
    }

    Node add(Node t, Node element, int key, int value) {
        if (t == null) {
            t = new Node(key, value, element);
        } else {
            if (key < t.key) {
                t.left = add(t.left, t, key, value);
            } else {
                t.right = add(t.right, t, key, value);
            }
        }
        return t;
    }

    void add(int key, int value) {
        root = add(root, null, key, value);
    }

    void replace(Node x, Node y) {
        if (x.element == null) {
            root = y;
        } else if (x == x.element.left) {
            x.element.left = y;
        } else {
            x.element.right = y;
        }
        if (y != null) {
            y.element = x.element;
        }
    }

    void remove(Node t, int key) {
        if (t == null) {
            return;
        }
        if (key < t.key) {
            remove(t.left, key);
        } else if (key > t.key) {
            remove(t.right, key);
        } else if(t.left != null && t.right != null) {
            Node node = t.right;
            while (node.left != null) {
                node = node.left;
            }
            t.key = node.key;
            t.value = node.value;
            replace(node, node.right);
        } else if (t.left != null) {
            replace(t, t.left);
        } else if (t.right != null) {
            replace(t, t.right);
        } else {
            replace(t, null);
        }
    }

    void remove(int key) {
        remove(root, key);
    }

    Node search(Node t, int key) {
        if (t == null || t.key  == key) {
            return t;
        }
        if (key < t.key) {
            return search(t.left, key);
        } else {
            return search(t.right, key);
        }
    }

    Node search(int key) {
        return search(root, key);
    }

    void print(Node t) {
        if (t != null) {
            print(t.left);
            System.out.println(t.key + ";" + t.value + " ");
            print(t.right);
        }
    }

    void print() {
        print(root);
    }
}
