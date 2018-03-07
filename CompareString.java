/**
 * Created by jeanlee on 2017/10/27.
 */
public class CompareString {
    public static boolean isMatched(String text, String pattern){
        boolean result = false;
        if (text == null || pattern == null){
            return false;
        }
        int size = comparedLength(text, pattern);
        // ABCD
        // ABCE

        // ABCD
        // ABCDE

        // ABCDE
        // ABCD

        for (int i = size; i >= 0 ; i--) {
             if (text.substring(0,i).equals(pattern.substring(0,i))){
                 result = true;
                 break;
             }
             if (i == 1 && !result){
                 break;

             }
        }
        return result;
    }

    public static int comparedLength(String text, String pattern){
        return Math.min(text.length(),pattern.length());
    }

    public static boolean completedMatched(String text, String pattern){
        boolean result = false;
        if (text == null || pattern == null){
            return false;
        }
        int size = comparedLength(text, pattern);
        if (text.substring(0, size).equals(pattern.substring(0,size))){
            result = true;
        }

        return result;
    }

    public static int locationOfSplit(String text, String pattern) {
        int indexToSplit = -1;
        if (isMatched(text, pattern)) {
            int size = comparedLength(text, pattern);
            for (int i = size; i >= 0; i--) {
                if (text.substring(0, i).equals(pattern.substring(0, i))) {
                    indexToSplit = i;
                    break;
                }
            }
        }
        return indexToSplit;
    }

    public static String[] ToSplit(String text, String pattern){
        int indexToSplit = -1;
        if (isMatched(text,pattern)){
            int size = comparedLength(text, pattern);
            for (int i = size; i >= 0; i--) {
                if (text.substring(0,i).equals(pattern.substring(0,i))){
                    indexToSplit = i;
                    break;
                }
            }
            String[] groups = new String[2];

            if (indexToSplit < text.length()  && indexToSplit < pattern.length()){
                groups[0] = text.substring(indexToSplit,text.length());
                groups[1] = pattern.substring(indexToSplit,pattern.length());
            }else {
                if (indexToSplit == text.length() && indexToSplit < pattern.length()){
                    groups[0] = null;
                    groups[1] = pattern.substring(indexToSplit,pattern.length());
                }
                if (indexToSplit == pattern.length() && indexToSplit < text.length()){
                    groups[1] = null;
                    groups[0] = pattern.substring(indexToSplit,pattern.length());
                }
            }

            return groups;
        }
        return null;

    }



    public static void main(String[] args) {
        String a = "nabc";
        String b = "nana";
        String[ ] groups = CompareString.ToSplit(a,b);
        System.out.println(groups[0] + " " + groups[1]);
    }
}
