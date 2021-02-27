package com.mycompany.app;

public class ArrayBubble {
    private long[] mas; //ссылка на массив
    private int elems; //количество элементов в массиве

    public ArrayBubble(int count){
        mas = new long[count];
        elems =0;
    }

    public ArrayBubble(long[] mas_){ // дополнительный констркутор, чтобы массив не заполнять
        mas = mas_;
        elems = mas.length;
    }
    public long[] getMas(){
        return mas;
    }

    public void into(long val){
        mas[elems] = val;
        elems++;
    }
    public void printer(){
        for(int i=0; i< elems;i++)
            System.out.print(mas[i]+" ");

        System.out.println("\n----Окончание вывода массива----");
    }

    public void swap(int a,int b){ //метод меняет местами пару чисел массива
        long temp = mas[a];
        mas[a] = mas[b];
        mas[b] = temp;
    }

    public void bubbleSorter(){
        for (int out = elems-1;out>=1;out--){
            for(int in=0;in<out;in++){
                if(mas[in]>mas[in+1])
                    swap(in,in+1);
            }
        }
    }

}
