FROM maven:3-jdk-12

COPY ./ /chat

RUN cd /chat && mvn compile -Djar.finalName=chat.jar

CMD java -jar /chat.jar
