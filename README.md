Automation Assurance Specialist Test
===================

This is an automated test pack to interact with the [sauce labs demo app](https://www.saucedemo.com/). Please take time
to familiarise yourself with the demo application. Different users for testing scenarios can be found on the demo app
homepage.

## Prerequisites:

To run the tests in this pack, you will need to install Java (at least version 11) and Maven. Instructions on how to do
so are below:

### Java:

You can download java for Windows, Mac OS or Linux
from [here](https://www.java.com/en/download/help/download_options.html).

Alternatively you can use [SDKMan](https://sdkman.io/) to download and manage your versions of java

This test pack has been confirmed to work with versions 11 and 21 of Java

### Maven:

Instructions for installing Maven on Windows can be found [here](https://maven.apache.org/install.html)

Alternatively on Mac OS you can install Maven using [homebrew](https://brew.sh/) and running the following command:

```brew install maven```

For Ubuntu Linux you can install maven using the following command:

```sudo apt-get install maven```

### Running the tests

You can run the tests using the following command

```mvn clean test```

## Config

Test config is set in resources/config/webdriver.yml

| config         | action                                           |
|----------------|--------------------------------------------------|
| url            | sets the default url                             |
| seleniumHubUrl | sets the url when using the remote driver        |
| browser        | sets the browser to run                          |
| remote         | whether to run the tests using the remote driver |
| headless       | whether to run the tests in headless mode        |
| waitTime       | how long to wait until a test times out          |