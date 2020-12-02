package not.hub.aoc.day2;

import not.hub.aoc.Solver;
import org.tinylog.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordPhilosophy1 extends Solver<StringBuffer, Integer> {

    protected static final Pattern pattern = Pattern.compile("^(\\d+)-(\\d+)\\s(\\w): (\\w+)$", Pattern.MULTILINE);

    @Override
    public Integer solve(StringBuffer input) {

        Logger.info("Day 2: Password Philosophy - Part 1");

        int numValid = 0;

        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            String pass = matcher.group(4);
            long count = pass.chars().filter(c -> c == matcher.group(3).charAt(0)).count();
            if (count >= Integer.parseInt(matcher.group(1)) && count <= Integer.parseInt(matcher.group(2))) {
                numValid++;
            }
        }

        Logger.info("Result: " + numValid);
        return numValid;

    }

}