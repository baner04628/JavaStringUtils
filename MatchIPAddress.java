import java.util.*;

public class MatchIPAddress {
    public static String solve (String IP) {
        if(IP == null || IP.length() == 0) {
            return "Neither";
        }

        HashSet<Character> set = new HashSet<>();
        for(char c = 'a'; c <= 'f'; c++)
            set.add(c);
        for(char c = '0'; c <= '9'; c++)
            set.add(c);
        for(char c = 'A'; c <= 'F'; c++)
            set.add(c);

        if(!set.contains(IP.charAt(0)) || !set.contains(IP.charAt(IP.length()-1))) {
            return "Neither";
        }

        int strLen = -1;
        String[] strs = IP.split("\\.");
        if(strs.length == 4) {
            for(int i = 0; i < strs.length; i++) {
                strLen = strs[i].length();
                if(strLen < 1 || strLen > 4 || strs[i].charAt(0) == '0') {
                    return "Neither";
                }
                for(int j = 0; j < strLen; j++) {
                    if(!Character.isDigit(strs[i].charAt(j))) {
                        return "Neither";
                    }
                }
                int curInt = Integer.parseInt(strs[i]);
                if(curInt < 0 || curInt > 255) {
                    return "Neither";
                }
            }
            return "IPv4";
        }
        strs = IP.split(":");
        if(strs.length == 8) {
            for(int i = 0; i < strs.length; i++) {
                strLen = strs[i].length();
                if(strLen < 1 || strLen > 4) {
                    return "Neither";
                }
                for(int j = 0; j < strLen; j++) {
                    if(!set.contains(strs[i].charAt(j))) {
                        return "Neither";
                    }
                }
            }
            return "IPv6";
        }

        return "Neither";
    }

    public static void main(String[] args) {
        System.out.println(MatchIPAddress.solve("192.168.4.1"));
        System.out.println(MatchIPAddress.solve("192A:C16D:D1:AC12:0:0:12E:12"));
        System.out.println(MatchIPAddress.solve("192.168.4.1.aed"));
    }

}
