package com.myapplication.quizapp;


import java.util.ArrayList;

public class QuestionData {
    public  static  String[] questions= {
            "Number of primitive data types in Java are?",
            "What is the size of float and double in java?",
            "Find the output of the following code:\n" + "int Integer = 24;\n" + "char String  = ‘I’;\n" + "System.out.print(Integer);\n" + "System.out.print(String);",
            "Select the valid statement.",
            "Find the value of A[1] after execution of the following program:\n" +
                    "int[] A = {0,2,4,1,3};\n" +
                    "for(int i = 0; i < a.length; i++){\n" +
                    "    a[i] = a[(a[i] + 3) % a.length];\n" +
                    "}",
            "Identify the keyword among the following that makes a variable belong to a class,rather than being defined for each instance of the class.",
            "In which of the following is toString() method defined?",
            "What does the following string do to given string str1.\n" + "String str1 = “Interviewbit”.replace(‘e’,’s’);",
            "What is Runnable?",
            "Identify the incorrect Java feature."
    };
    public  static  String[][] questionsOptions= {
            {"6","7","8","9"},
            {"32 and 64"," 32 and 32"," 64 and 64","64 and 28"},
            {"Compile Error", "Throw Exception" , "I ", "24 I"},
            { "char [] ch=new char(5)" , "char [] ch=new char[5]" , "char [] ch=new char()" , "char [] ch=new char[][]" , "char [] ch=new char[5]"},
            {"0", "1" , "2 " , "3"},
            {"final" , "static" , "volatile" , "abstract"},
            {"java.lang.Object", "java.lang.String" , "java.lang.util" , "None"},
            {"Replaces single occurrence of 'e' to 's'" , "Replaces all occurrences of 'e' to 's'" , "Replaces single occurrence of 's' to 'e'" , "None"},
            {"Abstract class" , "Interface" , "Class" , "Method"},
            {"Object Oriented", "Use of Pointers", "Dynamic", "Architectural neural"}


    };
    public static String answers[]={
            "8",
            "32 and 64",
            "24 I",
            "char [] ch=new char[5]",
            "1",
            "static",
            "java.lang.Object",
            "Replaces all occurrences of 'e' to 's'",
            "Interface",
            "Use of Pointers"





    };


    }
