## Run the tests

To run the tests locally execute `mvn clean verify`.
#### To run the tests on Selenium grid:
Execute `docker-compose up` in the project directory.

To access the grid console: `http://localhost:4444/grid/console`

To check the browser container port: `docker ps`

To see the test execution open VNC server on:
```
localhost:<browser container port>
Password: secret
```
To execute the tests: `mvn clean verify -Denvironment=remote`.

## Run the tests with specific browser
* Override the driver specified in the configuration file **serenity.conf** from the command line `mvn clean verify 
  -Dwebdriver.driver=firefox`.

## Tests report
Tests report could be found here: `/target/site/serenity/index.html`

Go to "Test Results" tab to see the results for each scenario.

Click on specific scenario to see its execution details.
