# BpTestBDD

Automated BDD test suite for the Blood Pressure Calculator site. Scenarios are written in Gherkin, executed with Cucumber on top of TestNG, and automated through Selenium WebDriver + Page Object Model abstractions.

## Table of Contents

- [Tech Stack](#tech-stack)
- [Getting Started](#getting-started)
- [Running the Suite](#running-the-suite)
- [Project Structure](#project-structure)
- [Configuration](#configuration)
- [Feature Coverage](#feature-coverage)
- [Reporting](#reporting)
- [Extending the Suite](#extending-the-suite)

---

## Tech Stack

- Java 21
- Maven 3.6+
- Selenium 4.27 (WebDriver + Selenium Manager)
- Cucumber JVM 7.15 with TestNG runner
- WebDriverManager 5.4 for ChromeDriver provisioning
- Gson/Lombok for lightweight data loading

---

## Getting Started

1. **Install prerequisites**
   - Oracle/OpenJDK 21 (`java -version`)
   - Maven (`mvn -version`)
   - Latest Chrome browser

2. **Clone the repository**
   ```bash
   git clone https://github.com/<your-org>/BpTestBDD.git
   cd BpTestBDD
   ```

3. **Download dependencies / build once**
   ```bash
   mvn clean install
   ```
   This resolves Maven dependencies and validates the project compiles.

---

## Running the Suite

Run every Gherkin scenario (default `bdd.runners.TestRunner`):

```bash
mvn test
```

Filter execution if needed:

```bash
# Run only one feature file
mvn test -Dcucumber.options="--name 'Privacy Policy'"

# Tag-based filtering (add @tag to scenarios)
mvn test -Dcucumber.filter.tags="@smoke"
```

Maven Surefire automatically launches the TestNG runner; no IDE-specific plugins are required. Reports land in `target`.

---

## Project Structure

```
src/
├── main/
│   └── resources/
│       ├── env.json          # Selects active environment (prod, etc.)
│       └── prodenv.json      # Host/protocol/wait configuration
└── test/
    └── java/bdd
        ├── features/         # Gherkin feature files
        ├── hooks/            # WebDriver lifecycle hooks
        ├── models/           # POJOs for environment data
        ├── pages/            # Page Object classes
        ├── runners/          # TestNG+Cucumber runner
        ├── steps/            # Step definitions
        └── utils/            # Helpers (settings, file utils, etc.)
```

Key classes:
- `bdd.pages.HomePage` & `PrivacyPolicyPage`: encapsulate UI actions/locators.
- `bdd.steps.*`: glue between Gherkin steps and page actions.
- `bdd.hooks.Hooks`: initializes ChromeDriver via WebDriverManager, loads the configured host, and closes the driver after each scenario.

---

## Configuration

Environment selection lives under `src/main/resources`.

`env.json`
```json
{
  "env": "prod"
}
```

`prodenv.json`
```json
{
  "protocol": "https",
  "domain": "example-bp-calculator.com",
  "wait": 10
}
```

`SettingsTestData` loads `env.json`, then the matching `<env>env.json` file into `EnvData`. `EnvData#getHost()` builds the base URL (e.g., `https://example-bp-calculator.com`). Update those files to point the tests at a different deployment.

---

## Feature Coverage

Current scenarios live in `src/test/java/bdd/features`:
- `BpCategory.feature`: verifies calculator output for Low/Ideal/Pre-High/High categories.
- `Validation.feature`: asserts validation messaging for values outside the allowed range and for mismatched systolic/diastolic inputs.
- `PrivacyPolicyPage.feature`: ensures the footer link navigates to the Privacy Policy page and that the heading matches.
- `FooterText.feature`: checks footer copy and the privacy link on both the home page and the policy page.

Add new `.feature` files here and glue them through the `bdd.steps` package.

---

## Reporting

Cucumber plugins configured in `bdd.runners.TestRunner` generate:
- `target/cucumber-report.html` – human-readable HTML summary.
- `target/cucumber.json` – machine-readable report for CI pipelines.
- Console `pretty` output.

You can feed the JSON into dashboards like Allure or publish the HTML artifact directly from CI.

---

## Extending the Suite

1. Model new UI behavior inside a Page Object (or extend `HomePage`).
2. Describe the scenario in a `.feature` file using Gherkin.
3. Implement matching step definitions under `bdd.steps`.
4. Re-run `mvn test` to validate.

Because WebDriver setup is centralized in Hooks, additional scenarios automatically reuse the same lifecycle and configuration.

Happy testing!
```

### Test Structure

```java
public class CheckBoxesTest extends BaseTest {
    protected CheckBoxesPage checkBoxesPage = new CheckBoxesPage();
    
    @Test
    public void checkBox1test() {
        homePage.clickNavigationLink(MainPageNavigation.CHECKBOXES);
        checkBoxesPage.verifyCheckBoxPage();
        checkBoxesPage.clickCheckbox1();
    }
}
```

---

## Troubleshooting

### Chrome WebDriver Version Mismatch

If you see warnings about Chrome DevTools Protocol (CDP) mismatch:

```
WARNING: Unable to find CDP implementation matching 142
```

This is non-fatal. To suppress it, add the matching selenium-devtools dependency to `pom.xml`:

```xml
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-devtools-v142</artifactId>
    <version>4.27.0</version>
</dependency>
```

Replace `v142` with your Chrome major version.

### Tests Not Discovered

Ensure test classes:
- Are in `src/test/java/framework/tests/` directory
- Extend `BaseTest` (or have TestNG annotations)
- Have method names starting with test-related keywords or `@Test` annotation

### Environment File Not Found

Verify `env.json` and `prodenv.json` exist in `src/main/resources/`:

```powershell
ls src/main/resources/
```

---

## CI/CD Integration

For GitHub Actions or other CI systems, use:

```bash
mvn clean test
```

To run headless in CI (add to your CI config):

```bash
mvn clean test -Dchrome.headless=true
```

For Maven properties override in CI, update `BaseTest` to read environment variables or system properties.

---

## Contributing

1. Create a feature branch: `git checkout -b feature/my-test`
2. Commit changes: `git commit -m "Add new test"`
3. Push to GitHub: `git push origin feature/my-test`
4. Open a Pull Request

---

## License

This project is private. Contact the repository owner for access details.

---

## Support

For issues, questions, or feature requests, please open an issue on GitHub or contact the development team.

---

**Last Updated**: November 13, 2025
