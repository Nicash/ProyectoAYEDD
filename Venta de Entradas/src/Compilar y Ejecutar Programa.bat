@echo off
javac CompraEntradas.java
jar cvfe CompraEntradas.jar CompraEntradas CompraEntradas.class
java -jar CompraEntradas.jar
pause




