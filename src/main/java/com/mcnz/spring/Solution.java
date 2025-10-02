package com.mcnz.spring;

public class Solution {
    public String whoWin(double x1, double v1, double x2, double v2, double x3, double v3) {
        if (x1 < 0.0 || x1 > 100.0 || v1 < 0.0 || v1 > 15.0
                || x2 < 0.0 || x2 > 100.0 || v2 < 0.0 || v2 > 15.0
                || x3 < 0.0 || x3 > 50.0 || v3 < 0.0 || v3 > 20.0) {
            return "Invalid Input";
        }

        double t1 = (x1 - 5.0) / v1;
        double t2 = (x2 - 5.0) / v2;
        double t_trigger = Math.min(t1, t2);

        double d1 = x1 - v1 * t_trigger;
        double d2 = x2 - v2 * t_trigger;

        double t_tom = Double.POSITIVE_INFINITY;
        if (2 * v1 > v3) {
            t_tom = d1 / (2 * v1 - v3);
        }

        double t_butch = Double.POSITIVE_INFINITY;
        if (2 * v2 > v3) {
            t_butch = d2 / (2 * v2 - v3);
        }

        double t_hole = x3 / v3;

        boolean tomCanCatch = t_tom < t_hole;
        boolean butchCanCatch = t_butch < t_hole;

        if (tomCanCatch && butchCanCatch) {
            if (t_tom < t_butch) {
                return "Tom";
            } else if (t_butch < t_tom) {
                return "Butch";
            } else {
                return "Jerry";
            }
        } else if (tomCanCatch) {
            return "Tom";
        } else if (butchCanCatch) {
            return "Butch";
        } else {
            return "Jerry";
        }
    }
}
