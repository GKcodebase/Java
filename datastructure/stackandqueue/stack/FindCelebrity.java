package datastructure.stackandqueue.stack;

/**
 * The type Find celebrity.
 */
public class FindCelebrity {
    private static boolean aqStatus(int[][] party, int x, int y) {
        if (party[x][y] == 1) return true;
        return false;
    }

    /**
     * Find int.
     *
     * @param party  the party
     * @param people the people
     * @return the int
     */
    public static int find(int[][] party, int people){
        Stack<Integer> stack = new Stack<>(people);
        int celeb = -1;
        for(int i=0;i<people;i++){
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int x = stack.pop();
            if(stack.isEmpty()){
                celeb=x;
                break;
            }
            int y = stack.pop();
            if(aqStatus(party,x,y)){
                //x knows y , discard x and push y in stack
                stack.push(y);
            }else
                stack.push(x);
        }
        //At this point we will have last element of stack as celebrity
        //Check it to make sure it's the right celebrity
        for (int j = 0; j < people; j++) {

            //Celebrity knows no one while everyone knows celebrity
            if (celeb != j && (aqStatus(party, celeb, j) || !(aqStatus(party, j, celeb)))) return -1;
        }
        return celeb;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {

        int [][] party1 = {
                {0,1,1,0},
                {1,0,1,1},
                {0,0,0,0},
                {0,1,1,0},
        };

        int [][] party2 = {
                {0,1,1,0},
                {1,0,1,1},
                {0,0,0,1},
                {0,1,1,0},
        };

        int [][] party3 = {
                {0,0,0,0},
                {1,0,0,1},
                {1,0,0,1},
                {1,1,1,0},
        };

        System.out.println(find(party1,4));
        System.out.println(find(party2,4));
        System.out.println(find(party3,4));
    }

}
