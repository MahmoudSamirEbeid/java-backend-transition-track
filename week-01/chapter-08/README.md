Lab Exercise-1

.Your goal is to make a method called betterString that takes
two Strings and a lambda that says whether the first of the
two is "better".
. The method should return that better String; i.e., if the function
given by the lambda returns true, the betterString method
should return the first String, otherwiseetterString should
return the second String.
- String string1 = ...;
- String string2 = ...;
- String longer = StringUtils.betterString(string1, string2, (s1, s2) -> s1.length() > s2.length());
- String first = StringUtils.betterString(string1, string2, (s1, s2) -> true);


Lab Exercise-2

O Given a String, the task is to check whether a string
contains only alphabets or not.
· Use isLetter() method of Character class.