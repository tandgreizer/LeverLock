package model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Lock {

  int[][] leverkey;
  int[] levers;
  int[] lights;


  public Lock(int size) {
    this(size, new Random().nextInt());
  }

  public Lock(int size, int seed) {
    leverkey = new int[size][size];
    lights = new int[size];
    levers = new int[size];
    Random r = new Random(seed);

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        int val = r.nextInt(2);
        leverkey[i][j] = (val < 1) ? 0 : 1;
      }
    }

  }

  public int[] checkLights() {
    int[] newLights = new int[lights.length];
    for (int i = 0; i < newLights.length; i++) {
      newLights[i] = lights[i] % 2;
    }
    return newLights;
  }

  private List<int[]> getPermutations() {
    Node zero = new Node(0);
    Node one = new Node(1);

    zero.expand(levers.length - 1);
    one.expand(levers.length - 1);

    List<int[]> vals = zero.walkUp();
    vals.addAll(one.walkUp());
    return vals;
  }



  public boolean isSolvable() {

    List<int[]> perms = this.getPermutations();

    for (int[] perm : perms) {
      int[] newLights = new int[lights.length];
      for (int i = 0; i < perm.length; i++) {
        if (perm[i] == 1) {
          for (int j = 0; j < perm.length; j++) {
            newLights[j] += leverkey[i][j];
          }
        }
      }
      boolean allOne = true;
      for (int i = 0; i < perm.length; i++) {
        if (newLights[i] % 2 != 1) {
          allOne = false;
          break;
        }
      }
      if (allOne) {
        System.out.println(Arrays.toString(perm));
        return true;
      }
    }


    return false;

  }
}
