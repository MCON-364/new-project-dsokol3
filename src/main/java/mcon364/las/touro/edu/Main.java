package mcon364.las.touro.edu;

import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        System.out.println(getGreeting("USERNAME"));
        System.out.println(getGreeting("NO_SUCH_VAR"));
        processValues(List.of(
                List.of(5, 10, 15),     // Processes completely
                List.of(20, 0, 25),     // Finds 0, skips to next list
                List.of(30, 35, 40),    // Processes completely
                List.of(45, 99, 50),    // Finds 99, terminates everything
                List.of(55, 60, 65)     // Never reached
        ));
    }

    public static Optional<String> getUserName(String envVarName) {
        return Optional.ofNullable(System.getenv(envVarName));
    }

    /**
     * Create a public static method `getGreeting`
     * Calls `getUserName`
     * Uses `var` for local variables where the type is obvious
     * Uses a switch expression with `yield` to decide how to build the greeting based on whether the username is present
     * Constructs the greeting using `StringBuilder`
     *
     * @param envVarName
     * @return
     */
    public static String getGreeting(String envVarName) {
        getUserName(envVarName);
        String greeting;
        StringBuilder sb = new StringBuilder();
        switch (envVarName) {
            case null:
                //yield envVarName == null ? sb.append("Hello" + envVarName) : sb.append("Hello");
        }
    }

    public static int processValues(List<List<Integer>> data) {
        int numsProcessed = 0;
        outerLoop:
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < data.get(i).size(); j++) {
                if (data.get(i).get(j) == 0) {
                    continue outerLoop;
                }
                if (data.get(i).get(j) == 99) {
                    break outerLoop;
                }
                numsProcessed++;
            }
        }
        return numsProcessed;
    }
}





