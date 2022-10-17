package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LockTest {
  Lock l1;

  @BeforeEach
  void setUp() {
    l1 = new Lock(4, 12);
  }

  @Test
  void checkLights() {
    assertArrayEquals(new int[]{0, 0, 0, 0},l1.checkLights() );
    System.out.println(Arrays.deepToString(l1.leverkey));
    assertFalse(l1.isSolvable());
  }

  @Test
  void findSolvable() {
    boolean solvable = false;
    int seed = 0;
    while (!solvable) {
      seed = new Random().nextInt();
      Lock l = new Lock(8, seed);
      solvable = l.isSolvable();
    }
    Lock l = new Lock(8, seed);
    System.out.println(seed);
    System.out.println(Arrays.deepToString(l.leverkey));
  }
}