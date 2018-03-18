package by.radomskaya.task;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BinarySearchTreeTest {
    private static BinarySearchTree tree;

    @BeforeClass
    public static void addElementTree() {
        tree = new BinarySearchTree();
        tree.add(3, 1);
        tree.add(2, 2);
        tree.add(4, 5);
    }

    @Test
    public void testTree() {
        tree.print();
        Assert.assertNotNull(tree.search(4));
        tree.remove(2);
        Assert.assertNull(tree.search(2));
    }

}
