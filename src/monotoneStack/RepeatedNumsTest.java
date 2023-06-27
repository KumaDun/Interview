package monotoneStack;

import org.junit.Test;

import static org.junit.Assert.*;

public class RepeatedNumsTest {
    RepeatedNums solution = new RepeatedNums();

    @Test
    public void Test1(){
        String numOne = "5445795045";
        String solutedNums = solution.sol(numOne);
        assertEquals("5479504", solutedNums);
        System.out.println(solutedNums);
    }

    @Test
    public void Test2(){
        String numTwo = "333666555444222111222999000";
        String solutedNums = solution.sol(numTwo);
//        assertEquals("5479504", solutedNums);
        System.out.println(solutedNums);
    }

    @Test
    public void Test3(){
        String numTwo = "34533";
        String solutedNums = solution.sol(numTwo);
//        assertEquals("5479504", solutedNums);
        System.out.println(solutedNums);
    }
}