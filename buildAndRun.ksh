#! /bin/ksh
#

export CLASSPATH=$PWD:$PWD/junit-4.10.jar
javac -d . *.java; java com/hps/luhn/TestRunner
