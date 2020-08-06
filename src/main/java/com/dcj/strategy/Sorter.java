package com.dcj.strategy;
//泛型 泛型不能用static
public class Sorter<T> {
  //由小到大排序
    public void sort(T[] arr,Comparetor<T> comparetor){
        for(int i=0;i<arr.length;i++){
            int pos = i;
            for(int j=i+1;j<arr.length;j++){
                //pos 用于i元素交换位置变化的记录,当i>j时，返回j的位置 否则不进行交换返回当前pos位置
                pos = comparetor.compare(arr[pos],arr[j])>0? j: pos;
            }
            //交换位置
            swap(arr,pos,i);
        }
    }

    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
