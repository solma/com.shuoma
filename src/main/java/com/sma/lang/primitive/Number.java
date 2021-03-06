package com.sma.lang.primitive;

import static com.sma.annotation.Tag.Reference.StackOverview;

import com.sma.annotation.Tag;

@Tag(references = StackOverview)
//http://stackoverflow.com/questions/4266756/can-we-make-unsigned-byte-in-java
// primitives are signed in Java
public class Number {
  public static void main(String[] args) {
    new Number().main();
  }

  void main() {
    //signedPrimitive();
    integerParse();
  }

  void integerParse() {
    // unchecked error
    System.out.println(Integer.parseInt(""));

    System.out.println(Integer.SIZE + " " + java.lang.Byte.SIZE);
  }

  void signedPrimitive() {
    // not compilable since hex or binary literals are int by default
    // byte b = 0xA1;
    // byte b = 0b10000001;

    // unsign a byte
    int ub = ((byte) -1 & 0xFF);
    System.out.println(ub);

    System.out.println("-1 is " + (byte)-1 + " in byte");
    System.out.println("255 is " + (byte)255 + " in byte");
  }
}
