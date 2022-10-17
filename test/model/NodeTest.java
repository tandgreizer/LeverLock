package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class NodeTest {

  @Test
  void testNode() {
    Node zero = new Node(0);
    Node one = new Node(1);

    zero.expand(4);
    one.expand(4);

    List<int[]> vals = zero.walkUp();
    vals.addAll(one.walkUp());
    for (int[] ary : vals) {
      System.out.println(Arrays.toString(ary));
    }

  }
}