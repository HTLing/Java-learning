// @Package : ch03
// @Time    : 2019/10/12 16:27
// @Author  : 星空糖
// @File    : GuessGame.java
import java.util.Arrays;
import java.util.Scanner;

public class GuessGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char ans;
        //循环
        do {
            GameBody();
            do {
                System.out.print("好玩吗？要不要再来一遍？（y/n）");
                ans = input.next().charAt(0);
            } while (ans != 'y' && ans != 'n');
        } while (ans == 'y');
    }

    //循环体内容
    private static void GameBody() {
        Scanner input = new Scanner(System.in);
        String[] WordToGuess = {"guess", "word", "java", "woman", "program", "trivial", "opposite"};
        String GuessWord = WordToGuess[(int) (Math.random() * 7)];

        int error_time = 0;
        char[] word = new char[GuessWord.length()];
        Arrays.fill(word, '*');
        while (Arrays.toString(word).indexOf('*') > -1) {
            System.out.print("请输入单词中的一个字母 ");
            for (char ch : word)
                System.out.print(ch);
            System.out.print(" > ");

            char letter = input.next().charAt(0);
            int result = GuessWord.indexOf(letter);
            if (result == -1) {
                error_time += 1;
                System.out.println(String.format("%c不在该单词里！", letter));
            } else if (word[result] != '*') {
                System.out.println(String.format("%c已经在该单词里！", letter));
            } else {
                while (result != -1) {
                    word[result] = letter;
                    result = GuessWord.indexOf(letter, result + 1);
                }
            }
        }
        System.out.println(String.format("这个单词是%s。你一共猜错了%d次", GuessWord, error_time));
    }
}
