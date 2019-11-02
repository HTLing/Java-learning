package BinPackingUsingFirstFit;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// @Package : BinPackingUsingFirstFit
// @Time    : 2019/11/2 17:50
// @Author  : 星空糖
// @File    : Packing.java
public class Packing {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Double> packs = new ArrayList<>();
        System.out.print("您的容器能容纳多少质量的物品？");
        final double MAX_MASS = input.nextDouble();

        System.out.print("请分别输入所有包裹的质量，输入非正数结束：");
        while(true) {
            try{
                double temp = input.nextDouble();
                if(temp <= 0) {
                    System.out.println("检测到非正数，之后输入全部舍弃。");
                    input.nextLine();
                    break;
                }
                packs.add(temp);
            } catch (InputMismatchException e) {
                System.out.println("检测到非法输入，后续输入全部舍弃。");
                input.nextLine();
                break;
            }
        }

        packs.sort(Double::compareTo);
        System.out.printf("移除超重（%.2f）的物品...\n", MAX_MASS);
        while(packs.get(packs.size() - 1) > MAX_MASS) {
            packs.remove(packs.size() - 1);
        }

        int num = 0;                    //num用于跟踪目前"容器"的数量
        while(!packs.isEmpty()) {
            ArrayList<Double> answer = new ArrayList<>();
            double tempMax = packs.get(packs.size() - 1);
            double sum = tempMax;       //sum变量用于跟踪目前包裹的质量
            answer.add(tempMax);
            packs.remove(packs.size() - 1);

            for(int i = packs.size() - 1; i > -1; i--){
                if(packs.get(i) + sum == MAX_MASS) {
                    //已经到达上限，提前结束
                    answer.add(packs.get(i));
                    packs.remove(i);
                    break;
                } else if(packs.get(i) + sum < MAX_MASS) {
                    //没有到达上限，更新变量，继续遍历
                    answer.add(packs.get(i));
                    sum += packs.get(i);
                    packs.remove(i);
                } //还有一种就是超过上限的，继续遍历
            }
            num++;
            System.out.printf("容器%d中有以下元素：%s。\n", num, answer.toString());
        }
    }
}
