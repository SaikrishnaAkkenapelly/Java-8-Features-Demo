/*declaration and imports*/
var StringBuilder = Java.type('java.lang.StringBuilder');

/*functions*/
function reverseString(input)
{
   var builder = new StringBuilder(input);
   return builder.reverse().toString();
}

/*calling function*/
print(reverseString("sai"));

/*jjs command line tool introduced in the nashorn java script engine*/
/*To run this file use open a cmd in this file location and enter jjs filename*/