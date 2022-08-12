#!/bin/bash
if [ ! -f ./pom.xml ]
then
    echo "No pom file: ./pom.xml"
    exit 1
fi
if [ ! -f ./target/iso8601z-normalizer.jar ]
then
    echo "No jar file: ./target/iso8601z-normalizer.jar"
    exit 2
fi
if [ ! -d ./artifacts ]
then
    mkdir artifacts
fi
cp target/iso8601z-normalizer.jar artifacts/iso8601z-normalizer.jar
cp pom.xml artifacts/pom.xml