mvn -Dbrowser=firefox -Dfile="src/test/resources/testing-smoke.xml"  clean test  
mvn -Dbrowser=chrome -Dfile="src/test/resources/testing-all.xml" -Denvironment=frameworkTask clean test 
