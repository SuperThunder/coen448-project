# Setup
- Install Intellij
- Clone repo
- mvn install (maven menu in intellij) to run tests
- run code in intellij for manual testing
- Jar can be found at src/target/coen448-robotgrid.jar

# Setting up intellij jacoco coverage
- Setup a 'test all with coverage' JUnit test configuration (choose all in package)
- Edit Configurations -> JUnit configurations -> modify options -> specify alternative coverage runner -> choose jacoco
- In modify options, choose 'specify classes and packages' then add package. Add the entire com.coen448 package.
- Run your 'All in coen448-project' test suite
- Coverage data can be found in run -> show coverage data
- Coverage report in run -> generate coverage report