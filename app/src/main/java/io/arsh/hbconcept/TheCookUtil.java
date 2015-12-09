package io.arsh.hbconcept;

/**
 * Created by arshdeep on 12/9/15.
 */
public class TheCookUtil {

    private static Cook currentChef;


    public static void setTheCook(Cook theChef) {

        currentChef = theChef;
    }

    public static Cook getTheCook() {

        return currentChef;
    }

}
