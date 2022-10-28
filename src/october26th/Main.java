package october26th;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(getALSubSeq2("123"));
    }

    public static ArrayList<String> getALSubSeq(String ip, String res) {
        if (ip.length() == 0) {
            ArrayList<String> currRes = new ArrayList<>();
            currRes.add(res);
            return currRes;
        }
        char curr = ip.charAt(0);
        ArrayList<String> ans = new ArrayList<>();
        ArrayList<String> rej =
                getALSubSeq(ip.substring(1), res);
        ArrayList<String> accept =
                getALSubSeq(ip.substring(1), res + curr);
        ans.addAll(rej);
        ans.addAll(accept);
        return ans;
    }

    public static ArrayList<String> getALSubSeq2(String ip) {
        if (ip.length() == 0) {
            ArrayList<String> currRes = new ArrayList<>();
            currRes.add("");
            return currRes;
        }
        char curr = ip.charAt(0);
        ArrayList<String> ans =
                getALSubSeq2(ip.substring(1));
        int size = ans.size();
        for (int i = 0; i <size; i++) ans.add(curr + ans.get(i));
        return ans;
    }
}
