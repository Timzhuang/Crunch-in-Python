#!/bin/bash

# the -cp option requires classpath to be specified as
# a colon or semi-colon-separated list

PY4J_JARFILE=env/share/py4j/py4j0.10.9.1.jar
CRUNCH_JARFILE=../crunch/crunch-core/target/crunch-core-1.1.0-SNAPSHOT.jar
JARFILES=$PY4J_JARFILE:$CRUNCH_JARFILE

MAINJAVA=StackEntryPoint

javac -cp $JARFILES *.java
java -cp .:$JARFILES $MAINJAVA
