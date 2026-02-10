package mcon364.las.touro.edu;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        /**
         * ### 4. In the `main` method
         * - Call `getGreeting` twice:
         *   - Once with `"USERNAME"`
         *   - Once with `"NO_SUCH_VAR"`
         * - Call `processValues` with sample data to demonstrate labeled control flow
         */
        getGreeting("USERNAME");
        getGreeting("NO_SUCH_VAR");
        List<List<Integer>> list = List.of(
                List.of(11, 22, 33),    // Processes completely
                List.of(44, 55, 66),    // Processes completely
                List.of(77, 99, 88),    // Finds 99, terminates ALL processing
                List.of(111, 222, 333)  // Never reached
        );
        processValues(list);
    }

    public static Optional<String> getUserName(String envVarName) {
        return Optional.ofNullable(System.getenv(envVarName));
    }

    /**
     * Create a public static method `getGreeting`
     * - Calls `getUserName`
     * - Uses `var` for local variables where the type is obvious
     * - Constructs the greeting using `StringBuilder`
     * public static String getGreeting(String envVarName);
     */
    public static String getGreeting(String envVarName) {
        var name = getUserName(envVarName);
        String greeting;
        StringBuilder sb = new StringBuilder();
        sb.append("Hello ");
        if (name.isEmpty()) {
            sb.append("Guest");
        } else {
            sb.append(name.get());
        }
        return sb.toString();
    }

    /**
     * ### 3. Create a public static method `processValues`
     * Iterates over a `List<List<Integer>>`
     * Uses a labeled `continue` to skip to the next outer list when a condition is met
     * Uses a labeled `break` to exit processing early when a terminating condition is met
     * Returns number of processed rows
     *
     * @param data
     * @return
     */
    public static int processValues(List<List<Integer>> data) {
        int numsProcessed = 0;
        outerLoop:
        for (List<Integer> datum : data) {
            for (Integer num : datum) {
                if (num == 0) {
                    continue outerLoop;
                }
                if (num == 99) {
                    break outerLoop;
                }
                numsProcessed++;
            }
        }
        return numsProcessed;
    }
}





