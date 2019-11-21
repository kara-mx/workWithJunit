package home2111;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        double[] y = m.fillY(m.fillX(0, 3, 0.004));
        System.out.printf("Максимальное значение функции %2.4f%n",m.maxValue(y));
        System.out.printf("Минимальное значение функции %2.4f%n",m.minValue(y));
        System.out.printf("Среднее значение %2.4f ; сумма элементов %4.4f%n",m.average(y),m.sum(y));
        System.out.printf("Значения функций для аргумента под номером 175 :%2.4f|350 :%2.4f|750 :%2.4f",y[174],y[349],y[749]);

    }

    double calcY(double x) {
        double a = -0.5;
        double b = 2;
        double y;
        if (x <= 0.7) {
            y = 1;
        } else if (x > 0.7 && x <= 1.4) {
            y = a * Math.pow(x, 2) * Math.log(x);
        } else {
            y = Math.pow(Math.E, a * x) * Math.cos(b * x);

        }
        return y;
    }

    int nSteps(double first, double finish, double step) {
        return (int) Math.round(((finish - first) / step) + 1);
    }

    double[] fillX(double first, double finish, double step) {
        double[] arrX = new double[nSteps(first, finish, step)];
        for (int i = 0; i < arrX.length; i++) {
            arrX[i] = first + i * step;
        }
        return arrX;
    }


    double[] fillY(double[] x) {
        double[] arrY = new double[x.length];
        for (int i = 0; i < arrY.length; i++) {
            arrY[i] = calcY(x[i]);
        }
        return arrY;
    }

    int numMax(double[] array) {
        int max = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[max] < array[i]) {
                max = i;
            }
        }

        return max;
    }

    int numMin(double[] array) {
        int min = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[min] > array[i]) {
                min = i;
            }
        }
        return min;
    }

     double sum(double[] array) {
        double sum=0;
         for (double v : array) {
             sum+=v;
         }
         return sum;
    }

     double average(double[] array) {
        return sum(array)/array.length;
    }

    double maxValue (double [] y){
        return y[numMax(y)];
    }

    double minValue (double [] y) {
        return y[numMin(y)];
    }

}
