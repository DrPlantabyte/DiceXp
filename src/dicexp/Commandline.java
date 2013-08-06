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

package dicexp;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import hall.collin.christopher.dicexp.DiceXp;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;


import javax.swing.*;
/**
 * This is the "Program" part of DiceXp. It is a commandline program by default, 
 * but has a GUI mode for average gamers to use. The .jar should be configured 
 * in such a way that double-clicking on the jar automatically launches the GUI.<p/>
 * DiceXp interprets standard dice notation (such as 1d20+1d4-3) and evaluates 
 * it. It has two evaluation modes: rolling and averaged. In rolling mode (the 
 * default), a random number generator is used to roll digital dice and evaluate 
 * the expression is if it were being rolled on the table. In averaged mode, 
 * random numbers are not used and instead the statistical average result is 
 * computed (such that '2d6' would return '7' every time).
 * @author Christopher Collin Hall (GitHub id Cyanobacteruim)
 */
public class Commandline {

	final static String INFO = "DiceXp Dice Expression Interpreter\n\n"
			+ "\tThis java program parses role-playing game (RPG) dice notation as "
			+ "described on http://en.wikipedia.org/wiki/Dice_notation and "
			+ "returns the result. \n\n"
			+ "Usage: \tjava dicexp.run [-aceghi] expressions...\n"
			+ "or     \tjava dicexp.CommandLine [-aceghi] expressions...\n\n"
			+ "Example:\n"
			+ "$ java dicexp.run 1d20\n"
			+ "prints 12 (or any random number from 1-20)\n"
			+ "$ java dicexp.run -ce 1d% 1d20+7 3d6x10 1d4*(1d6+1)\n"
			+ "prints 1d%=12,1d20+7=18,3d6x10=140,1d4*(1d6+1)=14\n"
			+ "$ java dicexp.run -a 8d10+2d6+2d10+12*2+3\n"
			+ "prints 89 (89 being the average result of the expression)\n\n"
			+ "Options:\n"
			+ "-a\tAverage result\nNo dice are rolled. Instead the results "
			+ "will be the average (statistical mean) result for the given "
			+ "expressions.\n\n"
			+ "-c\tComma seperated values\nDelimit the resulting numbers with "
			+ "commas (default is to use the new-line character).\n\n"
			+ "-e\tEcho Expressions\nPrepends the input expression in front of "
			+ "each responce.\n\n"
			+ "-g\tGUI mode\nLaunches a window for typing in dice expressions. "
			+ "Other options will be ignored.\n\n"
			+ "-h\tHelp message\nShows this page and exits.\n\n"
			+ "-i\tInteractive mode\nInstead of parsing commandline arguments, "
			+ "this program will ask you for expressions one at a time and "
			+ "evaluate them as they are entered.\n\n";
	
	
	
	/**
	 * Commandline interface for the DiceXp dice expression interpreter.
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// flags
		boolean average  = false;
		boolean commas = false;
		boolean echo = false;
		boolean gui = false;
		boolean interactive = false;
		String delimiter = "\n";
		
		List<String> options  = new ArrayList<>();
		List<String> expressions  = new ArrayList<>();
		for(int i = 0; i < args.length; i++){
			if(args[i].startsWith("-")){
				options.add(args[i]);
			} else {
				expressions.add(args[i]);
			}
		}
		// parse options
		for(String o : options){
			for(int i = 0; i < o.length(); i++){
				if(o.charAt(i) == '-'){continue;}
				String flag = (new Character(o.charAt(i))).toString();
				switch (flag){
					case "a":
						average = true;
						break;
					case "c":
						commas = true;
						break;
					case "e":
						echo = true;
						break;
					case "g":
						gui = true;
						break;
					case "h":
						println(INFO);
						System.exit(0);
						break;
					case "i":
						interactive = true;
						break;
					default:
						throw new IllegalArgumentException ("Option '"+flag+"'  not recognized");
				}
			}
		}
		
		if(gui){
			println("Starting GUI...");
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					createAndShowGUI();
				}
			});
			return;
		}
		
		if(commas){
			delimiter = ",";
		}
		
		if(interactive){
			DiceXp dicex = new DiceXp(new java.util.Random());
			// interactive mode
			println("Entering DiceX Interactive mode.");
			if(average){println("The average option (-a) has been specified. All dice rolls will be averaged.");}
			println("Enter dice expressions for evaluation (type EXIT to terminate this program):");
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			try{
				String input = in.readLine();
				while(input.equalsIgnoreCase("exit") == false){
					
					if(echo){
						print(input + "=");
					} else {
						print( "\t");
					}
					println(dicex.eval(input,average) );
					input = in.readLine();
				}
			} catch (Exception ex){
				Logger.getLogger(Commandline.class.getCanonicalName()).log(Level.SEVERE, "Exception occured!", ex);
				System.exit(ex.getClass().getSimpleName().hashCode());
			}
			println("\nExiting DiceXp");
			System.exit(0);
		} else {
			DiceXp dicex = new DiceXp(new java.util.Random());

			boolean first = true;
			for(String x : expressions){
				if(first == false){
					print(delimiter);
				}
				first = false;
				if(echo){
					print(x + "=");
				}
				print( dicex.eval(x,average) );
			}
			print("\n");
		}
		
		// TODO options and evaluation
		
		
		if(args.length == 0){
			
		}
	}

	static void println(Object o) {
		System.out.println(o.toString());
	}
	static void print(Object o) {
		System.out.print(o.toString());
	}
	
	private static void createAndShowGUI() {
		final JFrame frame = new JFrame("DiceXp - Dice Expression Interpreter");
		
		final DiceXp dicex = new DiceXp(new Random());
		
		final JTextField inputField = new JTextField();
		final JButton evalButton = new JButton();
		final JTextArea log = new JTextArea(16,50);
		final JCheckBox aveCheck = new JCheckBox();
		final JScrollPane scroller = new JScrollPane(log);
		
		log.setTabSize(8);
		log.setEditable(false);
		aveCheck.setText("Average Result");
		aveCheck.setSelected(false);
		inputField.setColumns(24);
		inputField.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					int v = dicex.eval(inputField.getText(), aveCheck.isSelected());
					log.append(timestamp() + "\t" + inputField.getText() + " = " + v+"\n");
				} catch (Exception ex){
					JOptionPane.showMessageDialog(frame, ex, "Error!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		evalButton.setText("Evaluate");
		evalButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					int v = dicex.eval(inputField.getText(), aveCheck.isSelected());
					log.append(timestamp() + " \t" + inputField.getText() + " = " + v+"\n");
				} catch (Exception ex){
					Logger.getLogger(Commandline.class.getCanonicalName()).log(Level.SEVERE, ex.getClass().getSimpleName(), ex);
					JOptionPane.showMessageDialog(frame, ex, "Error!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
		JPanel mp = new JPanel();
		mp.setLayout(new BoxLayout(mp,BoxLayout.Y_AXIS));
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		p1.add(inputField);
		p1.add(evalButton);
		p1.add(aveCheck);
		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		p2.add(scroller);
		mp.add(p2);
		mp.add(p1);
		
		frame.getContentPane().add(mp);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	static DateFormat formatter = null ;
	private synchronized static String timestamp(){
		Date now = new Date();
		if(formatter == null )formatter = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
		return formatter.format(now);
	}
}
