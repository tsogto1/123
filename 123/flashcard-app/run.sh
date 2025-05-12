#!/bin/bash

# Navigate to the directory where the script is located
cd "$(dirname "$0")"

# Clean and compile the project (this ensures everything is up to date)
mvn clean compile

# Run the FlashCardApp class using Maven's exec plugin
mvn exec:java -Dexec.mainClass="com.flashcard.FlashCardApp"
