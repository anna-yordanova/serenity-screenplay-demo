## Run the tests

To run the tests locally execute `mvn clean verify`.
#### To run the tests on Selenium grid:
Execute `docker-compose up -d` in the project directory.

To access the grid console: `http://localhost:4444/grid/console`

To check the browser container port: `docker-compose ps`

To see the test execution open VNC server on:
```
localhost:<browser container port>
Password: secret
```
To execute the tests: `mvn clean verify -Denvironment=remote`.

To stop the grid and cleanup the created containers run `docker-compose down`

## Run the tests with specific browser
Override the driver specified in **serenity.conf** file from the command line:
* local environment: `mvn clean verify -D"webdriver.driver"=chrome`
* remote environment: `mvn clean verify -Denvironment=remote -D"webdriver.remote.driver"=firefox`

## Run specific tests
To run specific tests use the available tags. For example `mvn clean verify -Dtags=remove_items`.

## Test report
Test report could be found here: `/target/site/serenity/index.html`

Go to "Test Results" tab to see the results for each scenario.

Click on specific scenario to see its execution details.
