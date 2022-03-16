package com.company;

import java.util.*;

/**
 * 
 */
public class Des {

    private static Random r = new Random();
    public Des() {
    }

    public static int lancerDes() {
        // TODO implement here
        return r.nextInt(6)+1;
    }

}