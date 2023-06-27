package binarySearch;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindMininRotatedArrayTest {

    @Test
    public void FindMinTest(){
        FindMininRotatedArray sol = new FindMininRotatedArray();
        assertEquals(11,sol.findMin(new int[]{11,13,15,17}));
    }

}