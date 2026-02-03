package mcon364.las.touro.edu;

import java.util.Optional;

public class Main {
    /**
     * Create a public static method `getUserName`
     * Takes the name of an environment variable as a parameter
     * Attempts to read the value using `System.getenv`
     * Returns the result as an `Optional<String>`
     */
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
        switch(envVarName) {
            case null:
            yield envVarName == null? sb.append("Hello" +envVarName): sb.append("Hello");
    }
}
