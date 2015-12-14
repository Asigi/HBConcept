package io.arsh.hbconcept;

import java.util.ArrayList;

/**
 * Created by arshdeep on 12/9/15.
 */
public class TheCookUtil {

    private static Cook currentChef;

    public static ArrayList<Cook> favCookList = new ArrayList<>();

    public static void setTheCook(Cook theChef) {

        currentChef = theChef;
    }

    public static Cook getTheCook() {

        return currentChef;
    }




}
