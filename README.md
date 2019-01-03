# hh-update-java
update you CV on hh.ru

for run you need Java8, Maven and Chrome

1. git clone https://github.com/hks225/hh-update-java.git

2. Set you HH.ru credetials in xml file /src/test/java/config/updateSuite.xml

3. Run by command 
mvn clean test -Dsuite=updateSuite
