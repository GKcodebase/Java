package datastructure.stackandqueue.stack;

public class TwoStackUsingArray<V> {
    private int maxSize;
    private V[] array;

    private int last1;
    private int last2;

    private int first1;

    private int first2;
    private int index1;
    private int index2;


    public TwoStackUsingArray(int maxSize){
        this.maxSize=maxSize;
        array = (V[]) new Object[maxSize+1];
        last1=maxSize/2;
        last2=maxSize;
        first1=0;
        first2=last1+1;
        index1=first1;
        index2=first2;
    }

    public boolean isEmpty1(){
        return index1==first1;
    }

    public boolean isEmpty2(){
        return index2==first2;
    }

    public boolean isFull1(){
        return index1==last1;
    }

    public boolean isFull2(){
        return index2==last2;
    }

    public void push1(V value){
        if(isFull1())
            return;
        array[index1++]=value;
    }
    public void push2(V value){
        if(isFull2())
            return;
        array[index2++]=value;
    }
    public V pop1(){
        if(isEmpty1())
            return null;
        return array[index1--];
    }
    public V pop2(){
        if(isEmpty2())
            return null;
        return array[index2--];
    }
    public void print1(){
        System.out.print("First stack :: ");
        for(int i = first1;i<index1;i++){
            System.out.print(array[i]+" ");
        }
    }
    public void print2(){
        System.out.print("\nSecond stack :: ");
        for(int i = first2;i<index2;i++){
            System.out.print(array[i]+" ");
        }
    }
    public static void main(String[] args){
        TwoStackUsingArray stack = new TwoStackUsingArray(12);
        stack.push1(1);
        stack.push1(10);
        stack.push1(20);
        stack.push1(30);
        stack.push1(40);
        stack.pop1();
        stack.print1();

        stack.push2(18);
        stack.push2(16);
        stack.push2(25);
        stack.push2(34);
        stack.push2(40);
        stack.pop2();
        stack.print2();


    }
}
