FROM bellsoft/liberica-openjdk-alpine:11.0.16
COPY ./java ./src 
RUN mkdir ./out
RUN javac -sourcepath ./src -d out src/ru/geekbrains/sample/Main.java
CMD java -classpath ./out ru.geekbrains.sample.Main