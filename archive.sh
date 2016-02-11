#! /bin/sh
zip -r --verbose rendu.zip pom.xml src/main/java/* 
tar -czvf rendu.tgz pom.xml src/main/java/*
