package org.example;

import java.util.ArrayDeque;
import java.util.Deque;

public class VacumCleanerRoute {

    /**
     * Runtime : O(N)
     * Space : O(N)
     * @param path
     * @return
     */
    public static boolean isReturnToOriginalPosition(String path) {

        Deque<Character> stackDirection = new ArrayDeque<>();


        for (int i = 0; i <path.length(); i++) {

            char direction = path.charAt(i);
            char oppositeDirection = oppositeOf(direction);
            if(stackDirection.contains(oppositeDirection)) {
                stackDirection.removeFirstOccurrence(oppositeDirection);
            } else {
                stackDirection.add(direction);
            }

        }
        return stackDirection.isEmpty();
    }

    /**
     * Runtime : O(N)
     * Space : O(1)
     * @param path
     * @return
     */
    public static boolean isReturnToOriginalPositionBalance(String path) {

        int balanceRightLeft = 0;
        int balanceUpDown = 0;


        for (int i = 0; i <path.length(); i++) {

            char direction = path.charAt(i);

            if(direction == 'L') {
                balanceRightLeft++;
            } else if(direction == 'R'){
                balanceRightLeft--;
            }else if(direction == 'U') {
                balanceUpDown++;
            } else if(direction == 'D'){
                balanceUpDown--;
            }

        }
        return  balanceRightLeft == 0 && balanceUpDown == 0;
    }

    public static char oppositeOf(char direction) {
        if(direction == 'L') return 'R';
        if(direction == 'R') return 'L';
        if(direction == 'U') return 'D';
        if(direction == 'D') return 'U';

        return 'X';
    }

    public static void main( String[] args ) {

        System.out.println("Return : " + isReturnToOriginalPositionBalance("LR") + " expected : true");
        System.out.println("Return : " + isReturnToOriginalPositionBalance("URURD") + " expected : false");
        System.out.println("Return : " + isReturnToOriginalPositionBalance("RUULLDRD") + " expected : true");
        System.out.println("Return : " + isReturnToOriginalPositionBalance("ULULDLDR") + " expected : false");
        System.out.println("Return : " + isReturnToOriginalPositionBalance("ULULDLDRRR") + " expected : true");


        System.out.println("Return : " + isReturnToOriginalPosition("LR") + " expected : true");
        System.out.println("Return : " + isReturnToOriginalPosition("URURD") + " expected : false");
        System.out.println("Return : " + isReturnToOriginalPosition("RUULLDRD") + " expected : true");
        System.out.println("Return : " + isReturnToOriginalPosition("ULULDLDR") + " expected : false");
        System.out.println("Return : " + isReturnToOriginalPosition("ULULDLDRRR") + " expected : true");
    }
}
