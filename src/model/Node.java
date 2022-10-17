package model;

import java.util.ArrayList;
import java.util.List;

public class Node {
  int Val;
  Node parent;
  Node lchild;
  Node rchild;


  public Node(int val) {
    Val = val;
  }

  public Node(int val, Node parent) {
    Val = val;
    this.parent = parent;
  }

  public void expand(int size) {
    if (size == 0) {
      return;
    }
    this.lchild = new Node(0, this);
    lchild.expand(size - 1);
    this.rchild = new Node(1, this);
    rchild.expand(size - 1);
  }

  public List<int[]> walkUp() {
    List<int[]> walks = new ArrayList<>();

    if (lchild != null && rchild != null) {
      lchild.walkUp(walks);
      rchild.walkUp(walks);
    }
    return walks;
  }
  public void walkUp(List<int[]> walks) {
    if (lchild == null ) {
      ArrayList<Integer> path = new ArrayList<>();
      path.add(this.Val);
      Node parent = this.parent;
      while (parent != null) {
        path.add(parent.Val);
        parent = parent.parent;
      }
      walks.add(path.stream().mapToInt(i -> i).toArray());
      return;
    }

    this.lchild.walkUp(walks);
    this.rchild.walkUp(walks);
  }
}
