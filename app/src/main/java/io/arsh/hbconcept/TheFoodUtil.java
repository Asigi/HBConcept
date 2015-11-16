package io.arsh.hbconcept;

/**
 * Created by arshdeep on 11/16/15.
 */
public class TheFoodUtil {


    private static String myCuisine;
    private static int myZip;



    public static void setTheCuisine(String theCuisine) {
        myCuisine = theCuisine;
    }

    public static String getTheCuisine() {
        return myCuisine;
    }

    public static void setTheZip(int theZip) {
        myZip = theZip;
    }

    public static int getTheZip() {
        return myZip;
    }


}
