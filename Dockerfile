# Step 1: Use an official OpenJDK image as the base image
FROM openjdk:17-jdk-alpine

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the JAR file into the Docker container
COPY target/dealerdata-0.0.1-SNAPSHOT.jar /app/dealerdata-0.0.1-SNAPSHOT.jar

# Step 4: Expose the port that the application will run on
EXPOSE 8088

# Step 5: Specify the command to run the JAR file when the container starts
ENTRYPOINT ["java", "-jar", "dealerdata-0.0.1-SNAPSHOT.jar"]