
CPATH='.:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar'

rm -rf student-submission
rm -rf grading-area

mkdir grading-area

git clone $1 student-submission
echo 'Finished cloning'

file='student-submission/ListExamples.java'

if [[ -f $file ]]
then
    echo 'Correct File'
else
    echo 'Wrong File'
fi

cp $file grading-area
cp TestListExamples.java grading-area

cd grading-area

#Compile and run
javac -cp .:../lib/hamcrest-core-1.3.jar:../lib/junit-4.13.2.jar ListExamples.java TestListExamples.java
java -cp .:../lib/hamcrest-core-1.3.jar:../lib/junit-4.13.2.jar org.junit.runner.JUnitCore TestListExamples > test_output_file




# Draw a picture/take notes on the directory structure that's set up after
# getting to this point

# Then, add here code to compile and run, and do any post-processing of the
# tests
