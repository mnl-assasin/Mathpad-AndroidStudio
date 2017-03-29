package com.bulsu.mathpad.activity.solver;

import android.util.Log;

/**
 * Created by mykelneds on 17/03/2017.
 */

public class Fractions {
    static String TAG = "Utils";

    public static String convertDecimalToFraction(double x) {
        double y = x;
        String word = String.valueOf(x);
        String splitted[] = word.split("\\.");

        Log.d(TAG, "Length: " + splitted.length);
        if (splitted.length > 1) {
            Log.d(TAG, splitted[0]);
            Log.d(TAG, splitted[1]);

            if (splitted[1].equals("0"))
                return splitted[0];
            else {
                y = Double.parseDouble("0." + splitted[1]);
                Log.d(TAG, "new value " + y);
            }

        }


        if (x < 0) {
            return "-" + convertDecimalToFraction(-y);
        }
        double tolerance = 1.0E-6;
        double h1 = 1;
        double h2 = 0;
        double k1 = 0;
        double k2 = 1;
        double b = y;
        do {
            double a = Math.floor(b);
            double aux = h1;
            h1 = a * h1 + h2;
            h2 = aux;
            aux = k1;
            k1 = a * k1 + k2;
            k2 = aux;
            b = 1 / (b - a);
        } while (Math.abs(y - h1 / k1) > y * tolerance);


        if (splitted[0].equals("0"))
            return (int) h1 + "/" + (int) k1;
        else
            return splitted[0] + " " + (int) h1 + "/" + (int) k1;
    }

}
