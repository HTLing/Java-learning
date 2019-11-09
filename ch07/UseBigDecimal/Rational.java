package UseBigDecimal;

import java.math.BigInteger;

// @Package : UseBigDecimal
// @Time    : 2019/11/9 16:35
// @Author  : 星空糖
// @File    : Rational.java
public class Rational {
    private BigInteger numerator;   //分子
    private BigInteger denominator; //分母

    /**
     * 其实就是懒得在那边转换<br>
     *  并且将分母中可能出现的负号挪到分子中
     * @param num 分子
     * @param den 分母
     */
    Rational(int num, int den) {
        if(den > 0) {
            numerator = BigInteger.valueOf(num);
            denominator = BigInteger.valueOf(den);
        } else if(den == 0) {
            throw new DenominatorIsZeroException("分母为0");
        } else {
            numerator = BigInteger.valueOf(-num);
            denominator = BigInteger.valueOf(-den);
        }
        Reduction();
    }

    /**
     * 这个不解释
     * @param num 分子
     * @param den 分母
     */
    private Rational(BigInteger num, BigInteger den) {
        numerator = num;
        denominator = den;
        Reduction();
    }

    /**
     * 约分<br>
     * 最简化
     */
    private void Reduction() {
        BigInteger gcd = numerator.gcd(denominator);
        //是1就不用管了
        if(!gcd.equals(BigInteger.valueOf(1))) {
            numerator = numerator.divide(gcd);
            denominator = denominator.divide(gcd);
        }
    }

    /**
     * 取相反数<br>
     * 把分子变成负的就好了
     * @return Rational
     */
    private Rational getOpposite() {
        return new Rational(this.numerator.multiply(BigInteger.valueOf(-1)), this.denominator);
    }

    /**
     * 取倒数<br>
     * 分子分母换一换就好了
     * @return Rational
     */
    private Rational getReciprocal() {
        return new Rational(this.denominator, this.numerator);
    }

    /**
     * 做加法
     *  a/b + c/d = (ad+bc)/bd
     *  暴力分母相乘，最后约分就是了
     * @param other 加数
     * @return Raational
     */
    Rational add(final Rational other) {
        BigInteger LCM = this.denominator.multiply(other.denominator);
        BigInteger num = this.numerator.multiply(other.denominator).add(other.numerator.multiply(this.denominator));
        return new Rational(num,LCM);
    }

    /**
     *  做减法<br />
     *  加上一个负的<br />
     * @param other 减数
     * @return Rational
     */
    Rational minus(final Rational other) {
        return this.add(other.getOpposite());
    }

    /**
     * 乘法就是暴力乘就是了
     * @param other 乘数
     * @return Rational
     */
    Rational multiply(final Rational other) {
        //乘法简单
        return new Rational(this.numerator.multiply(other.numerator), this.denominator.multiply(other.denominator));
    }

    /**
     * 除法等价于乘以倒数<br />
     * @param other 除数
     * @return Rational
     */
    Rational divide(final Rational other) {
        //除法更简单，乘上倒数
        return this.multiply(other.getReciprocal());
    }

    /**
     * 字面意思不解释<br>
     * 返回好看的分式<br>
     * (<i> 至少我认为好看 </i>)
     * @return String
     */
    @Override
    public String toString() {
        if(denominator.equals(BigInteger.valueOf(1)))
            if(numerator.compareTo(BigInteger.valueOf(0)) >= 0)
                return numerator.toString();
            else
                return "(" + numerator.toString() + ")";
        else
            if(numerator.compareTo(BigInteger.valueOf(0)) >= 0)
                return numerator.toString() + "/" + denominator.toString() ;
            else
                return "(" + numerator.toString() + "/" + denominator.toString() + ")";
    }
}

/**异常类 <br />
 * 分母是0哦~~<br />
 * 这样子怎么做计算嘛~~
 * */
class DenominatorIsZeroException extends RuntimeException {
    /**
     * 一个就够了<br>
     *  我觉得我可以写一个在无参构造函数中传递消息参数的构造函数
     * @param s String 消息参数，在上面写了
     */
    DenominatorIsZeroException(String s) {
        super(s);
    }
}