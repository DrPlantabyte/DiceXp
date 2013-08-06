/*
This code is distributed under the LGPLv3 license, reprinted below for the sake 
of clarity. In short: use however you want and have fun!
 
GNU LESSER GENERAL PUBLIC LICENSE
                       Version 3, 29 June 2007

 Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 Everyone is permitted to copy and distribute verbatim copies
 of this license document, but changing it is not allowed.


  This version of the GNU Lesser General Public License incorporates
the terms and conditions of version 3 of the GNU General Public
License, supplemented by the additional permissions listed below.

  0. Additional Definitions.

  As used herein, "this License" refers to version 3 of the GNU Lesser
General Public License, and the "GNU GPL" refers to version 3 of the GNU
General Public License.

  "The Library" refers to a covered work governed by this License,
other than an Application or a Combined Work as defined below.

  An "Application" is any work that makes use of an interface provided
by the Library, but which is not otherwise based on the Library.
Defining a subclass of a class defined by the Library is deemed a mode
of using an interface provided by the Library.

  A "Combined Work" is a work produced by combining or linking an
Application with the Library. The particular version of the Library
with which the Combined Work was made is also called the "Linked
Version".

  The "Minimal Corresponding Source" for a Combined Work means the
Corresponding Source for the Combined Work, excluding any source code
for portions of the Combined Work that, considered in isolation, are
based on the Application, and not on the Linked Version.

  The "Corresponding Application Code" for a Combined Work means the
object code and/or source code for the Application, including any data
and utility programs needed for reproducing the Combined Work from the
Application, but excluding the System Libraries of the Combined Work.

  1. Exception to Section 3 of the GNU GPL.

  You may convey a covered work under sections 3 and 4 of this License
without being bound by section 3 of the GNU GPL.

  2. Conveying Modified Versions.

  If you modify a copy of the Library, and, in your modifications, a
facility refers to a function or data to be supplied by an Application
that uses the facility (other than as an argument passed when the
facility is invoked), then you may convey a copy of the modified
version:

   a) under this License, provided that you make a good faith effort to
   ensure that, in the event an Application does not supply the
   function or data, the facility still operates, and performs
   whatever part of its purpose remains meaningful, or

   b) under the GNU GPL, with none of the additional permissions of
   this License applicable to that copy.

  3. Object Code Incorporating Material from Library Header Files.

  The object code form of an Application may incorporate material from
a header file that is part of the Library. You may convey such object
code under terms of your choice, provided that, if the incorporated
material is not limited to numerical parameters, data structure
layouts and accessors, or small macros, inline functions and templates
(ten or fewer lines in length), you do both of the following:

   a) Give prominent notice with each copy of the object code that the
   Library is used in it and that the Library and its use are
   covered by this License.

   b) Accompany the object code with a copy of the GNU GPL and this license
   document.

  4. Combined Works.

  You may convey a Combined Work under terms of your choice that,
taken together, effectively do not restrict modification of the
portions of the Library contained in the Combined Work and reverse
engineering for debugging such modifications, if you also do each of
the following:

   a) Give prominent notice with each copy of the Combined Work that
   the Library is used in it and that the Library and its use are
   covered by this License.

   b) Accompany the Combined Work with a copy of the GNU GPL and this license
   document.

   c) For a Combined Work that displays copyright notices during
   execution, include the copyright notice for the Library among
   these notices, as well as a reference directing the user to the
   copies of the GNU GPL and this license document.

   d) Do one of the following:

       0) Convey the Minimal Corresponding Source under the terms of this
       License, and the Corresponding Application Code in a form
       suitable for, and under terms that permit, the user to
       recombine or relink the Application with a modified version of
       the Linked Version to produce a modified Combined Work, in the
       manner specified by section 6 of the GNU GPL for conveying
       Corresponding Source.

       1) Use a suitable shared library mechanism for linking with the
       Library. A suitable mechanism is one that (a) uses at run time
       a copy of the Library already present on the user's computer
       system, and (b) will operate properly with a modified version
       of the Library that is interface-compatible with the Linked
       Version.

   e) Provide Installation Information, but only if you would otherwise
   be required to provide such information under section 6 of the
   GNU GPL, and only to the extent that such information is
   necessary to install and execute a modified version of the
   Combined Work produced by recombining or relinking the
   Application with a modified version of the Linked Version. (If
   you use option 4d0, the Installation Information must accompany
   the Minimal Corresponding Source and Corresponding Application
   Code. If you use option 4d1, you must provide the Installation
   Information in the manner specified by section 6 of the GNU GPL
   for conveying Corresponding Source.)

  5. Combined Libraries.

  You may place library facilities that are a work based on the
Library side by side in a single library together with other library
facilities that are not Applications and are not covered by this
License, and convey such a combined library under terms of your
choice, if you do both of the following:

   a) Accompany the combined library with a copy of the same work based
   on the Library, uncombined with any other library facilities,
   conveyed under the terms of this License.

   b) Give prominent notice with the combined library that part of it
   is a work based on the Library, and explaining where to find the
   accompanying uncombined form of the same work.

  6. Revised Versions of the GNU Lesser General Public License.

  The Free Software Foundation may publish revised and/or new versions
of the GNU Lesser General Public License from time to time. Such new
versions will be similar in spirit to the present version, but may
differ in detail to address new problems or concerns.

  Each version is given a distinguishing version number. If the
Library as you received it specifies that a certain numbered version
of the GNU Lesser General Public License "or any later version"
applies to it, you have the option of following the terms and
conditions either of that published version or of any later version
published by the Free Software Foundation. If the Library as you
received it does not specify a version number of the GNU Lesser
General Public License, you may choose any version of the GNU Lesser
General Public License ever published by the Free Software Foundation.

  If the Library as you received it specifies that a proxy can decide
whether future versions of the GNU Lesser General Public License shall
apply, that proxy's public statement of acceptance of any version is
permanent authorization for you to choose that version for the
Library.
 */
package hall.collin.christopher.dicexp;

import java.util.Random;

/**
 * This class interprets dice expressions as used in D20 (and other) 
 * role-playing systems. All math is integer math (always rounds down) in 
 * accordance with the dice practice of Dungeons & Dragons (D&D is property of 
 * Wizards of the Coast).<p/>
 * Typical usage:<br/><code>
 * Random prng = new java.util.Random();<br/>
 * DiceXp dicex = new DiceXp(prng);<br/>
 * ...<br/>
 * String userInput = ...<br/>
 * int rolledValue = dicex.eval(userInput);<br/>
 * </code><p/>
 * Order of operations:<br/><ol>
 * <li>Parentheses: ()</li>
 * <li>dice: d</li>
 * <li>Multiplication and division: /*</li>
 * <li>Addition and subtraction: +-</li>
 * </ol>
 * @author Christopher Collin Hall (GitHub id Cyanobacteruim)
 */
public class DiceXp {
	
	final Random prng;
	/**
	 * Standard constructor for the DiceX class. You need to supply a psuedo-
	 * random number generator to act as the digital dice.
	 * @param rand 
	 */
	public DiceXp(Random rand){
		prng = rand;
	}
	/**
	 * Computes the given dice expression and returns the result. If 
	 * <code>averageValue</code> is <code>true</code>, then no dice are rolled 
	 * and the returned value is the average result. Otherwise, a random number 
	 * generator is used to simulate dice rolling. Note that 'X' and 'x' may be 
	 * used for multiplication in the place of '*' and the '%' symbol will be 
	 * expanded to 100 (e.g. "1d%" is same as "1d100").
	 * @param diceExpression A RPG style dice expression (e.g. "(2d6+3)*2-5")
	 * @param averageValue If <code>true</code>, return the average result; if 
	 * <code>false</code>, roll dice and return the random result.
	 * @return The value of the expression.
	 */
	public int eval(String diceExpression, boolean averageValue){
		
		StringBuffer x = new StringBuffer(diceExpression);
		// need to remove all whitespace, also using this opportunity to throw common exceptions
		for(int i = x.length() - 1; i >= 0; i-- ){
			if(Character.isWhitespace(x.charAt(i))){
				x.deleteCharAt(i);
			} else if(x.charAt(i) == '.'){
				throw new NumberFormatException("Found '.', but decimal numbers are not supported (integer math only)");
			} else if(x.charAt(i) == '%'){// d% means d100
				x.replace(i, i+1, "100");
			} else if(x.charAt(i) == 'x' || x.charAt(i) == 'X'){// multiplication old-school notation
				x.replace(i, i+1, "*");
			} 
		}
		
		
		// Parentheses
		while(x.indexOf("(") >= 0){
			int open = x.indexOf("(");
			int close = x.lastIndexOf(")");
			if(open > 0 && Character.isDigit(x.charAt(open-1))){// handle implied multiplication (e.g. "2(1d6+1)" == "2*(1d6)+1" )
				x.insert(open, '*');
				continue;
			}
			if(close < 0){throw new NumberFormatException("Found '(' without matching ')'");}
			x.replace(open, close+1, (new Integer(eval(x.substring(open+1,close),averageValue))).toString());
		}
		
		// Dice
		while(x.indexOf("d") > 0 ){
			int opIndex = x.indexOf("d");
			
			int left = opIndex - 1;
			while(left >= 0 && Character.isDigit(x.charAt(left))){
				left--;
			}
			int right = opIndex+1;
			while(right < x.length() && Character.isDigit(x.charAt(right))){
				right++;
			}
			String leftOperand = x.substring(left+1, opIndex);
			String rightOperand = x.substring(opIndex+1, right);
			int L = Integer.parseInt(leftOperand);
			int R = Integer.parseInt(rightOperand);
			Integer value;
			if(averageValue){
				value = averagedRoll(L,R);
			} else {
				value = roll(L,R);
			}
			x.replace(left+1, right, value.toString());
		}
		
		// multiply and divide
		while(x.indexOf("*") > 0 || x.indexOf("/") > 0){ // why doesn't StringBuffer have a "contains" method?
			int a = x.indexOf("*");
			int b = x.indexOf("/");
			int opIndex;
			if(a < 0){
				opIndex = b;
			} else if(b < 0) {
				opIndex = a;
			} else if(a < b){
				opIndex = a;
			} else {
				opIndex = b;
			}
			int left = opIndex - 1;
			while(left >= 0 &&Character.isDigit(x.charAt(left))){
				left--;
			}
			int right = opIndex+1;
			while(right < x.length() && Character.isDigit(x.charAt(right))){
				right++;
			}
			char operator = x.charAt(opIndex);
			String leftOperand = x.substring(left+1, opIndex);
			String rightOperand = x.substring(opIndex+1, right);
			int L = Integer.parseInt(leftOperand);
			int R = Integer.parseInt(rightOperand);
			Integer value;
			if(operator == '*') {
				value = L * R;
			} else {
				value = L / R;
			}
			x.replace(left+1, right, value.toString());
		}
		
		// add and subtract
		// replace all - with +- (but not the leading - if the first number is negative)
		for(int i = 1; i < x.length(); i++){
			if(x.charAt(i) == '-'){
				x.insert(i, '+');
				i++;
			}
		}
		while(x.indexOf("+") > 0 ){
			int opIndex = x.indexOf("+");
			
			int left = opIndex - 1;
			while(left >= 0 && (Character.isDigit(x.charAt(left)) || x.charAt(left) == '-')){
				left--;
			}
			int right = opIndex+1;
			while(right < x.length() && (Character.isDigit(x.charAt(right)) || x.charAt(right) == '-')){
				right++;
			}
			String leftOperand = x.substring(left+1, opIndex);
			String rightOperand = x.substring(opIndex+1, right);
			int L = Integer.parseInt(leftOperand);
			int R = Integer.parseInt(rightOperand);
			Integer value = L + R;
			x.replace(left+1, right, value.toString());
		}
		
		return Integer.parseInt(x.toString());
	}
	/**
	 * Computes the given dice expression and returns the rolled result. A 
	 * random number generator is used to simulate dice rolling. Note that 'X' 
	 * and 'x' may be used for multiplication in the place of '*' and the '%' 
	 * symbol will be expanded to 100 (e.g. "1d%" is same as "1d100").
	 * @param diceExpression A RPG style dice expression (e.g. "(2d6+3)*2-5")
	 * @param diceExpression A d20 style dices expression (e.g. "(2d6+3)*2-5")
	 * @return The value of the expression, using random numbers to roll the 
	 * dice values.
	 */
	public int eval(String diceExpression){
		return eval(diceExpression,false);
	}
	/**
	 * Roles <i>n</i>d<i>s</i>
	 * @param n number of dice
	 * @param s sides per die
	 * @return The rolled value
	 */
	public int roll(int n,int s){
		int sum = 0;
		for(int i = 0; i < n; i++){
			sum += prng.nextInt(s) + 1;
		}
		return sum;
	}
	/**
	 * Similar to the <code>roll(n,s)</code> methods, but instead of rolling 
	 * digital dice, it calculates the statistical average (mean) result.
	 * @param n number of dice
	 * @param s sides per die
	 * @return The average roll value
	 */
	public int averagedRoll(int n,int s){
		double sum = 0;
		for(int i = 0; i < n; i++){
			sum += (1.0 + s)/2;
		}
		return (int)sum;
	}
	
	
	
}
