/**
 * Created by jeanlee on 2017/10/25.
 */
public class BruteForce {
    public int serach(String text, String pattern){
        int result = -1;
        for (int i = 0 ; i < text.length() - pattern.length(); i++) {
            boolean matched = true;
            int j = 0;
            while (j < pattern.length() && matched){
                if (text.charAt(i + j) == pattern.charAt(j)){
                    j++;
                }else {
                    matched = false;
                }

            }
            if (matched){
                result  = i;
                break;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        BruteForce force = new BruteForce();
        System.out.println(force.serach("TTCCPSIVARSNFNVCRLPGTPEAICATYTGCIIIPGATCPGDYANjh","IIIC"));
    }
}
