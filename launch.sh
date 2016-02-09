#! /bin/sh
mvn exec:java -Dexec.mainClass="Main" -Dexec.args="$1"
