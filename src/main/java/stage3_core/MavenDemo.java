package stage3_core;

import org.apache.commons.lang3.StringUtils;

public class MavenDemo {
    public static void main(String[] args) {
        String message = "  hello maven  ";
        System.out.println("Original: '" + message + "'");
        System.out.println("Trimmed: '" + StringUtils.trim(message) + "'");
        System.out.println("Reversed: '" + StringUtils.reverse(message.trim()) + "'");
        System.out.println("Is blank: " + StringUtils.isBlank(message));
    }
}
