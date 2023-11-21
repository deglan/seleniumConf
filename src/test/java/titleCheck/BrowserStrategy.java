package titleCheck;

import lombok.AllArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@AllArgsConstructor
public enum BrowserStrategy {

    CHROME("CHROME") {
        @Override
        public WebDriver getDriver() {
            return new ChromeDriver();
        }
    },
    FIREFOX("FIREFOX") {
        @Override
        public WebDriver getDriver() {
            return new FirefoxDriver();
        }
    },
    IE("IE") {
        @Override
        public WebDriver getDriver() {
            return new InternetExplorerDriver();
        }
    },
    EDGE("EDGE") {
        @Override
        public WebDriver getDriver() {
            return new EdgeDriver();
        }
    };

    private static final Map<String, BrowserStrategy> BY_NAME = Arrays.asList(values()).stream()
            .collect(Collectors.toMap(value -> value.name, Function.identity()));
    private final String name;

    public abstract WebDriver getDriver();

    public static BrowserStrategy from(String name) {
        return BY_NAME.getOrDefault(name.toUpperCase(), CHROME);
    }
}
