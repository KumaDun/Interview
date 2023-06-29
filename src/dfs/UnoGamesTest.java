package dfs;

import org.junit.Test;

public class UnoGamesTest {
    String[] numsOne = new String[]{"1","4","3","4","5"};
    String[] colorsOne = new String[] {"r", "y", "b", "b", "r"};

    UnoGames gameOne = new UnoGames(numsOne, colorsOne);




    @Test
    public void testPrint(){
        gameOne.printCards();
    }

    @Test
    public void testAdjacency(){
        gameOne.printAdjacencyList();
    }

    @Test
    public void testDfsSearchOne(){
        gameOne.dfsSearch(0);
        gameOne.printPathes();
    }

    @Test
    public void testDfsSearchTwo(){
        gameOne.dfsSearch(1);
        gameOne.printPathes();
    }

    @Test
    public void testDfsSearchThree(){
        String[] numsTwo = new String[]{"1","4","3","4","5","2","2","1"};
        String[] colorsTwo = new String[] {"r", "y", "b", "b", "r","y","g","r"};

        UnoGames gameTwo = new UnoGames(numsTwo, colorsTwo);
        for(int i=0; i<numsTwo.length; i++){
            gameTwo.dfsSearch(i);
        }
        gameTwo.printPathes();
    }

}