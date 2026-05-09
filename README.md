# Daisy Blog Wicket

A small TomEE 10 Plus + Wicket 10 personal portfolio/blog scaffold.

## Run

```powershell
.\gradlew.bat FULL_BUILD_AND_RUN
```

On macOS or Linux:

```bash
./gradlew FULL_BUILD_AND_RUN
```

The task verifies the checked-in TomEE ZIP, runs tests, extracts a fresh TomEE server into `build/tomee/`, overlays `configurations/tomee/`, deploys the Wicket WAR as `ROOT.war`, and starts TomEE at:

http://localhost:8080/

Stop the server with `Ctrl+C`.

## Project Shape

- `configurations/webapp/WEB-INF/web.xml` wires Wicket into the web application.
- `configurations/tomee/` contains server configuration copied into each fresh TomEE extraction.
- `src/main/java/com/daisyblog/portfolio/` contains the Wicket application, pages, and components.
- `src/main/resources/com/daisyblog/portfolio/` contains Wicket markup and CSS next to the Java package.
- `vendor/apache-tomee-10.1.5-plus.zip` is intentionally checked in for repeatable educational builds.

