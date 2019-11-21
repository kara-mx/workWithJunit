package home2111;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

     private Main main;
     private double eps = 1e-4;

    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @Test
    void calcY() {
        assertEquals(1,main.calcY(0.6),eps);
        assertEquals(1,main.calcY(-235),eps);
        assertEquals(0.0809,main.calcY(0.75),eps);
        assertEquals(-0.3297,main.calcY(1.4),eps);
        assertEquals(-0.4687,main.calcY(1.41),eps);
        assertEquals(0.2142,main.calcY(3),eps);
    }

    @Test
    void nSteps() {
        assertEquals(11,main.nSteps(0,1,0.1));
        assertEquals(6,main.nSteps(2.4,4.4,0.4));
        assertEquals(10,main.nSteps(0.2,0.236,0.004));
    }

    @Test
    void fillX() {
        double[] x = main.fillX(0.2,0.236,0.004);
        double [] expected = {0.2,0.204,0.208,0.212,0.216,0.22,0.224,0.228,0.232,0.236};
        assertArrayEquals(expected,x,eps);
        x = main.fillX(0,1000,0.002);
        assertEquals(500001,x.length);
    }

    @Test
    void fillY() {
        double [] x = {0.6,0.32,0.85,1.94,0,3.26};
        double [] expected = {1,1,0.0587,-0.2803,1,0.1904};
        assertArrayEquals(expected,main.fillY(x),eps);
    }

    @Test
    void numMax() {
        double [] arr = {1,0.7,9.34,-0.98,2.44};
        assertEquals(2,main.numMax(arr));
    }

    @Test
    void numMin() {
      double [] arr = {2.4,-6.36,0.23,0.69,0,-8.96};
      assertEquals(5,main.numMin(arr));
    }

    @Test
    void sum() {
        double [] arr = {1,1.2,1.39,0.26,38.922};
        assertEquals(42.772,main.sum(arr),eps);
    }

    @Test
    void average() {
        double [] arr = {1.26,0.298,2.2,8.6,-2.34};
        assertEquals(2.0036,main.average(arr),eps);

    }

    @Test
    void maxValue() {
        double [] arr = {1.89,5.23,-0.36,2.65,8.3,11.03};
        assertEquals(11.03,main.maxValue(arr),eps);
    }


    @Test
    void minValue() {
        double [] arr = {0.26,2.38,-23.56,-17.2,0.23,-14.3};
        assertEquals(-23.56,main.minValue(arr),eps);
    }
}