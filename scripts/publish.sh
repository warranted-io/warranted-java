#!/bin/bash

# Build the project
mvn clean package

# Publish the artifact to Maven Central or your repository manager
mvn deploy
