package Stack;
// @Package : Stack
// @Time    : 2019/11/17 23:34
// @Author  : 星空糖
// @File    : TestMyStack.java

public class TestMyStack {
    public static void main(String[] args) {
        MyStack a = new MyStack();
        a.push(100);
        a.push(-0.11);
        a.push(1);
        a.push(0);

        System.out.println("最小元素是：" + a.MinNumber());
        System.out.println("栈顶元素是：" + a.peak());
        a.pop();
        System.out.println("最小元素是：" + a.MinNumber() + '\n');

        a = new MyStack(0.001);
        a.push(100);
        a.push(-0.11);
        a.push(1);
        a.push(0);

        System.out.println("最小元素是：" + a.MinNumber());
        System.out.println("栈顶元素是：" + a.peak());
        a.pop();
        System.out.println("最小元素是：" + a.MinNumber() + '\n');
    }
}
