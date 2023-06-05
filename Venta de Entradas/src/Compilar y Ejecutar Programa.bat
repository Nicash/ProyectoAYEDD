@echo off
javac -encoding UTF-8 CompraEntradas.java
jar cvfe CompraEntradas.jar CompraEntradas CompraEntradas.class
java -Dfile.encoding=UTF-8 -jar CompraEntradas.jar
pause




