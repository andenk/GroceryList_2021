FROM openjdk:17
COPY ./target/GroceryList-0.0.1-SNAPSHOT.jar /usr/src/grocerylist/
WORKDIR /usr/src/grocerylist
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "GroceryList-0.0.1-SNAPSHOT.jar"]