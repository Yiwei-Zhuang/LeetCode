/**
 * @author ZHUANG Yiwei on 2021/10/4
 */
public class SectorsMerge {
    private final static double pi = Math.PI;

    static class TSector {
        public double a0;
        public double a1;
    }

    // normalized range for angle
    private static Boolean isNormalized(double a) {
        return -pi < a && a <= pi;
    }

    // special normal form for sector
    private static Boolean isNormalized(TSector s) {
        return isNormalized(s.a0) && s.a0 <= s.a1 && s.a1 < s.a0 + pi;
    }

    // normalize a sector to the special form:
    // * -PI < a0 <= PI
    // * a0 < a1 < a0+PI
    static void normalize(TSector s) {
        assert (isNormalized(s.a0) && isNormalized(s.a1));

        // choose a representation of s.a1 s.t. s.a0 < s.a1 < s.a0+2*PI
        double a1_bigger = (s.a0 <= s.a1) ? s.a1 : s.a1 + 2 * pi;
        if (a1_bigger >= s.a0 + pi) {
            double temp = s.a0;
            s.a0 = s.a1;
            s.a1 = temp;
        }
        if (s.a1 < s.a0)
            s.a1 += 2 * pi;
        assert (isNormalized(s));
    }

    private static Boolean intersectionNormalized(TSector s0, TSector s1,
                                                  TSector intersection) {
        assert (isNormalized(s0) && isNormalized(s1) && s0.a0 <= s1.a0);

        boolean isIntersecting = false;
        if (s1.a0 <= s0.a1) // s1.a0 inside s0 ?
        {
            isIntersecting = true;
            intersection.a0 = s1.a0;
            intersection.a1 = Math.min(s0.a1, s1.a1);
        } else if (s0.a0 + 2 * pi <= s1.a1) // (s0.a0+2*PI) inside s1 ?
        {
            isIntersecting = true;
            intersection.a0 = s0.a0;
            intersection.a1 = Math.min(s0.a1, s1.a1 - 2 * pi);
        }
        assert (!isIntersecting || isNormalized(intersection));

        return isIntersecting;
    }

    public static void main(String[] args) {
        TSector s0 = new TSector(), s1 = new TSector();
        s0.a0 = -1;
        s0.a1 = 1;
        s1.a0 = 0;
        s1.a1 = pi-0.1;
        System.out.println("S0: " + Math.toDegrees(s0.a0) + " " + Math.toDegrees(s0.a1));
        System.out.println("S1: " + Math.toDegrees(s1.a0) + " " + Math.toDegrees(s1.a1));
        normalize(s0);
        normalize(s1);
        System.out.println("After normalize:");
        System.out.println("S0: " + Math.toDegrees(s0.a0) + " " + Math.toDegrees(s0.a1));
        System.out.println("S1: " + Math.toDegrees(s1.a0) + " " + Math.toDegrees(s1.a1));
        // sort by start edge
        if (s1.a0 < s0.a0) {
            TSector temp = s0;
            s0 = s1;
            s1 = temp;
        }
        TSector intersection = new TSector();
        boolean isIntersection = intersectionNormalized(s0, s1, intersection);
        System.out.println(intersection.a0);
        System.out.println(intersection.a1);
        System.out.println(isIntersection);
    }

}
