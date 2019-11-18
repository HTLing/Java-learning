package Stack;
// @Package : Stack
// @Time    : 2019/11/17 23:08
// @Author  : 星空糖
// @File    : MyStack.java

/*
 * 用链表的思想完成栈的构建
 */
class MyStack {
    private Element top;   //指向栈顶的指针
    private MyStack MinNumber;  //保存最小元素的栈

    MyStack() {
        top = null;
        MinNumber = new MyStack(this);
    }

    MyStack(final double x) {
        top = new Element(x, null);
        MinNumber = new MyStack(x,this);
    }

    private MyStack(final MyStack stack) {
        top = null;
        MinNumber = null;
    }

    private MyStack(final double x, final MyStack stack) {
        top = new Element(x, null);
        MinNumber = null;
    }

    private boolean isEmpty() {
        return top == null;
    }

    void push(final double x) {
        this.top = new Element(x, top);

        if(MinNumber == null)
            return;

        if(MinNumber.top != null && this.top.compareTo(MinNumber.top) >= 0) {
            MinNumber.push(this.MinNumber());
        } else {
            MinNumber.push(x);
        }
    }

    void pop() {
        if(isEmpty()){
            System.out.println("空栈！");
            return;
        } else {
            top = top.getPointerToAnother();
        }

        if(MinNumber != null) {
            MinNumber.pop();
        }
    }

    double peak() {
        return top.getElementNumber();
    }

    double MinNumber() {
        return MinNumber.peak();
    }
}

class Element implements Comparable<Element> {
    private double ElementNumber;
    private Element PointerToAnother;

    Element(double x, Element pointer) {
        ElementNumber = x;
        PointerToAnother = pointer;
    }

    double getElementNumber() {
        return ElementNumber;
    }

    Element getPointerToAnother() {
        return PointerToAnother;
    }

    @Override
    public int compareTo(Element o) {
        return Double.compare(this.ElementNumber, o.ElementNumber);
    }
}