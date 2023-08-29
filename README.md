<<<<<<< HEAD
**Run from terminal with specific test method:**
mvn test -Dtest=<ClassName>#<MethodName> -Dconfig=<PropFileName> -DBROWSERSTACK_USERNAME="<BSUsername>" -DBROWSERSTACK_ACCESS_KEY="<BSAccessKey>"

e.g.
mvn test -Dtest=ActEngagementTests#actByPhoneNumber -Dconfig=base -DBROWSERSTACK_USERNAME="krupadeshmukh_Cg30W9" -DBROWSERSTACK_ACCESS_KEY="Access_Key***"

**Run from terminal with specific group:**
mvn test -Dtestng.config=<path/to/testng.xml> -Dconfig=<PropFileName> -DBROWSERSTACK_USERNAME="<BSUsername>" -DBROWSERSTACK_ACCESS_KEY="<BSAccessKey>"

e.g:
mvn clean test -Dgroups=ICv2_EU_Desk_Regression_01 -Dconfig=base -DBROWSERSTACK_USERNAME="krupadeshmukh_Cg30W9" -DBROWSERSTACK_ACCESS_KEY="pi4fujSqPRUs1EE9KcAM"


**Run from terminal with specific testng xml:**
mvn test -Dtestng.config=<path/to/testng.xml> -Dconfig=<PropFileName> -DBROWSERSTACK_USERNAME="<BSUsername>" -DBROWSERSTACK_ACCESS_KEY="<BSAccessKey>"

e.g.
mvn test -Dtestng.config=TestngXML/ICv2MobileSuite.xml -Dconfig=base -DBROWSERSTACK_USERNAME="krupadeshmukh_Cg30W9" -DBROWSERSTACK_ACCESS_KEY="Access_Key***"

=======
# Rezolve_Automation_QK
Web, Mobile and API automation
>>>>>>> d5315046fc536967fb3e4de1cbefcd222204a633
