package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class UnoGames {

    // Move Card class definition before UnoGames constructor
    class Card{
        String num;
        String color;
        String id;


        public Card(String id, String num, String color){
            this.id = id;
            this.num = num;
            this.color = color;
        }

        public boolean isNext(Card otherCard){
            if(this.id.equals(otherCard.id)){
                return false;
            }
            else{
                return this.num.equals(otherCard.num) || this.color.equals(otherCard.color);
            }
        }

        @Override
        public boolean equals(Object other){
            if(!(other instanceof Card)){
                return false;
            }
            else{
                Card otherCard = (Card)other;
                return otherCard.id.equals(this.id);
            }
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.id);
        }

        @Override
        public String toString(){
            return "Card ID " + this.id + ": mum:" + this.num + ", color: " + this.color;
        }
    }

    String[] nums;
    String[] colors;

    List<Card> initialCards = new ArrayList<Card>();

    List<List<Card>> adjancencyList = new ArrayList<>();

    List<List<Card>> pathes = new ArrayList<>();


    public UnoGames(String[] nums, String[] colors){
        this.nums = nums;
        this.colors = colors;
        for(int i = 0;i<nums.length; i++){
            Card c = new Card(Integer.toString(i), nums[i], colors[i]);
            initialCards.add(c);
        }
        buildAdjacencyList();
    }

    public void printCards(){
        System.out.println(this.initialCards);
    }

    public void printAdjacencyList(){
        for(List<Card> adjacency: this.adjancencyList){
            System.out.println(adjacency);
        }
    }

    public void printPathes(){
        for(List<Card> path:pathes){
            System.out.println(path);
        }
    }

    private void buildAdjacencyList(){
        int len = this.initialCards.size();
        for(int i=0;i<len; i++ ){
            Card curr = initialCards.get(i);
            ArrayList<Card> adjancency = new ArrayList<Card>();
            adjancency.add(curr);
            for (int j=0; j<len; j++){
                Card otherCard = initialCards.get(j);
                if(j == i){
                    continue;
                }
                else{
                    if (curr.isNext(otherCard)) {
                        adjancency.add(otherCard);
                    }
                }
            }
            this.adjancencyList.add(adjancency);
        }
    }

    public void dfsSearch(int id){
        Card c = initialCards.get(id);
        List<Card> initialList = new ArrayList<>();
        initialList.add(c);
        dfsSearch(c, initialList);
    }

    private void dfsSearch(Card currCard, List<Card> path){
        String idStr = currCard.id;
        int idInt = Integer.parseInt(idStr);
        List<Card> adjacencies = adjancencyList.get(idInt);
        List<Card> adjacenciesCopy = new ArrayList<Card>(adjacencies);
        adjacenciesCopy.removeAll(path);
        if(adjacencies.size()<=1 || adjacenciesCopy.size()==0){
            this.pathes.add(path);
        }
        for (Card nextCard : adjancencyList.get(idInt)){
            if (!nextCard.id.equals(currCard.id) && !path.contains(nextCard)){
                path.add(nextCard);
                dfsSearch(nextCard, path);
            }
        }
    }

    public List<Card> longestPath(){
        int max = -1;
        List<Card> longestPath = new ArrayList<>();
        for (List<Card> path: pathes){
            if (path.size()>max){
                max = path.size();
                longestPath = path;
            }
        }
        return longestPath;
    }
}

