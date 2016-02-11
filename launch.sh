#! /bin/sh

class="Main"
if [ "$#" -ne 1 ]; then
	class="$1"
fi

shift

cd target/classes
java "$class" "$1"

if [ "$?" -ne 0 ]; then
	echo "usage : launch [MainClass] arg"
fi;
