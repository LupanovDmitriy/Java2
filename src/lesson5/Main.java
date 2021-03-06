package lesson5;
/*
1. Необходимо написать два метода, которые делают следующее:
1) Создают одномерный длинный массив, например:
static final int size = 10000000;
static final int h = size / 2;
float[] arr = new float[size];
2) Заполняют этот массив единицами;
3) Засекают время выполнения: long a = System.currentTimeMillis();
4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
5) Проверяется время окончания метода System.currentTimeMillis();
6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
Отличие первого метода от второго:
Первый просто бежит по массиву и вычисляет значения.
Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.

Пример деления одного массива на два:
System.arraycopy(arr, 0, a1, 0, h);
System.arraycopy(arr, h, a2, 0, h);

Пример обратной склейки:
System.arraycopy(a1, 0, arr, 0, h);
System.arraycopy(a2, 0, arr, h, h);

Примечание:
System.arraycopy() копирует данные из одного массива в другой:
System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника, массив-назначение, откуда начинаем записывать данные в массив-назначение, сколько ячеек копируем)
По замерам времени:
Для первого метода надо считать время только на цикл расчета:
for (int i = 0; i < size; i++) {
arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
}
Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.
 */
public class Main {
    static final int size = 10000000;
    static final int h = size / 2;


    public static void main(String[] args) {
        float[] arr1 = new float[size];
        float[] arr2 = new float[size];

        for (int i = 0; i <size ; i++) {
            arr1[i]=1;
            arr2[i]=1;
        }


        long a = System.currentTimeMillis();
        simple(arr1,0);
        System.out.println("simple "+(System.currentTimeMillis() - a)+" ms");

        a = System.currentTimeMillis();
        thread(arr2);
        System.out.println("thread "+(System.currentTimeMillis() - a)+" ms");

        for (int i = 0; i <size ; i++) {
            if (arr1[i]!=arr2[i]){
                System.out.println(i);
                break;
            }
        }
        System.out.println("массивы одинаковые");

    }

    static void simple(float[] arr, int from){
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + (from+i) / 5) * Math.cos(0.2f + (from+i) / 5) * Math.cos(0.4f + (from+i) / 2));
        }
    }

    static void thread(float[] arr) {
        float[] a1=new float[h];
        float[] a2=new float[h];

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread t1= new Thread(new Runnable() {
            @Override
            public void run() {
                simple(a1,0);
            }
        });
        Thread t2= new Thread(new Runnable() {
            @Override
            public void run() {
                simple(a2,h);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
    }


}
