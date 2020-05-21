package lesson2;
/*
1. Напишите метод, на вход которого подается двумерный строковый массив размером 4х4,
при подаче массива другого размера необходимо бросить исключение MySizeArrayException .

2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
 должно быть брошено исключение MyArrayDataException – с детализацией, в какой именно ячейке лежат неверные данные.

3. В методе main() вызвать полученный метод,
 обработать возможные исключения MySizeArrayException и MyArrayDataException и вывести результат расчета.
 */
public class Main {
    public static void main(String[] args) {
        String[][] arr = {
                {"1","2","3","4"},
                {"1","2","st","4"},
                {"1","2","3","4"},
                {"1","2","3","4"}
        };
        try{
            if (validArr(arr,4,4)){
                System.out.println(sumArr(arr));
            }
        }
        catch (MySizeArrayException e){
            System.out.println(e.getMessage());
        }
        catch(MyArrayDataException e){
            System.out.println(e.getMessage()+" "+e.getI()+" "+e.getJ()+" "+e.getValue());
        }

    }

    static int sumArr(String[][] arr)
    {
        int sum=0;
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                try{
                    sum+=Integer.parseInt(arr[i][j]);
                }catch (NumberFormatException e){
                    throw new MyArrayDataException("Не корректные данные",i,j,arr[i][j]);
                }
            }
        }
        return sum;
    }

    static boolean validArr(String[][] arr, int row, int coll) throws MySizeArrayException {
        if (arr.length!=row) {
            throw new MySizeArrayException("Неверное количество строк");
        }
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i].length!=coll) {
                throw new MySizeArrayException("Неверное количество столбцов в "+i+" строке");
            }
        }
        return true;
    }

}
