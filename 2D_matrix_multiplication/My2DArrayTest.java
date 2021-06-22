//import jdk.incubator.vector.VectorOperators.Test;

public class My2DArrayTest{
    //之後會整合成SortAPI
	public static void main(String[] args) {
        int [][] tmp = {{1,50,66,-11,5}, {5,6,11,20,8}};
        String [] tmp2 = {"1 5 -5 66","15 66 52 88"};
        new2DArray Ra2 = new new2DArray(tmp);
        new2DArray Ra3 = new new2DArray(tmp, -12, 67);
        new2DArray Ra4 = new new2DArray(tmp2);
        System.out.println(Ra2.toString());
        System.out.println(Ra3.toString());
        System.out.println(Ra4.toString());
        generate2DExampleArray Rx = new generate2DExampleArray();
        generate2DRandomArray Ry = new generate2DRandomArray(20, 55, -200, 600);
        new2DArray Ra5 = new new2DArray(Rx.getArray());
        new2DArray Ra6 = new new2DArray(Ry.getArray());
        System.out.println(Ra5.toString());
        System.out.println(Ra6.toString());
        Mul Test1 = new StrassenMul();
        Mul Test2 = new NaiveMul();
        Mul Test3 = new SparseMul();
        int [][] testA = {{1,2,3,4},{-2,4,5,6},{5,9,8,7},{2,8,6,9}},testB = {{5,6,-1,5},{0,5,1,1},{10,7,6,3},{5,6,7,8}};
        int [][] testSA = {{1,0,0},{-1,0,3}}, testSB = {{7,0,0},{0,0,0},{0,0,1}};
        //Strassen此演算法只能接受長度相同且為2的覓次的方陣相乘(實際上可以用一些技巧解決這個問題，如果你專題有興趣做這個的話)
        Test1.MulMain(testSA, testSB);
        //Test2.MulMain(testSA, testSB);
        Test3.MulMain(testSA, testSB);
        //若不確定答案正確性可前往以下網頁
        //https://matrixcalc.org/zh/#%7B%7B1,2,3,4%7D,%7B-2,4,5,6%7D,%7B5,9,8,7%7D,%7B2,8,6,9%7D%7D%2a%7B%7B5,6,-1,5%7D,%7B0,5,1,1%7D,%7B10,7,6,3%7D,%7B5,6,7,8%7D%7D
    }
}