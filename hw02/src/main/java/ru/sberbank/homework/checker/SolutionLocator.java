package ru.sberbank.homework.checker;

import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import lombok.extern.slf4j.Slf4j;
import ru.sberbank.homework.common.Calculator;

@Slf4j
public class SolutionLocator {

    public static void main(String[] args) {
        SolutionChecker sc = new SolutionChecker();

        FastClasspathScanner scanner = new FastClasspathScanner();
        scanner.addClassLoader(SolutionLocator.class.getClassLoader());
        scanner.matchClassesImplementing(Calculator.class, subclass -> {
            try {
                log.debug("Checking class from package: {}", subclass.getPackage().getName());
                sc.startTesting(subclass.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                log.error("Calculator instance creation failed", e);
            }
        });
        scanner.scan();
    }


}
