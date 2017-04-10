echo "Build inputGen.cpp"
g++ inputGen.cpp
echo "Generate Input"
./a.out > data.in
echo "Build Solution.cpp"
g++ solution.cpp
echo "Generate Output"
./a.out < data.in > data.out
