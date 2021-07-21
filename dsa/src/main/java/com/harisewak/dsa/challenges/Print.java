package com.harisewak.dsa.challenges;

public class Print {

    public static void ln(String variableNames, int... values) {
        String[] variables = variableNames.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            if (i == 0) {
                builder.append(variables[i] + ": ");
            } else {
                builder.append(", " + variables[i] + ": ");
            }
            builder.append(value);
        }
        System.out.println(builder);
    }

}
