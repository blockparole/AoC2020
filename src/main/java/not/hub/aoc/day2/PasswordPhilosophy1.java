package not.hub.aoc.day2;

import not.hub.aoc.Solver;
import org.tinylog.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordPhilosophy1 extends Solver<String, Integer> {

    protected static final Pattern pattern = Pattern.compile("^(\\d+)-(\\d+)\\s(\\w): (\\w+)$", Pattern.MULTILINE);

    @Override
    public Integer solve(String input) {

        Logger.info("Day 2: Password Philosophy - Part 1");

        var numValid = 0;

        var matcher = pattern.matcher(input);
        while (matcher.find()) {
            var pass = matcher.group(4);
            var count = pass.chars().filter(c -> c == matcher.group(3).charAt(0)).count();
            if (count >= Integer.parseInt(matcher.group(1)) && count <= Integer.parseInt(matcher.group(2))) {
                numValid++;
            }
        }

        Logger.info("Result: " + numValid);
        return numValid;

    }

}
