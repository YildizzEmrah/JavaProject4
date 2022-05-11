/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package emrahyildiz_hw4;

import java.util.Scanner;

/**
 *
 * @author emrah
 */
public class EmrahYildiz_Hw4 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
         Scanner input=new Scanner(System.in);
        HW4_Hash d1=new HW4_Hash();
       
       d1.ReadFileandGenerateHash("F:\\Java öğrenme denemeleri\\EmrahYildiz_Hw4\\input.txt", 10);
  
    /*   System.out.print("Please enter the word : ");
    String word=input.nextLine();
    d1.showFrequency(word);*/

        
    //d1.DisplayResult();

       d1.DisplayResultOrdered("F:\\Java öğrenme denemeleri\\EmrahYildiz_Hw4\\outputfile.txt");

       d1.showFrequency("the");
    // d1.testing();
       d1.showMaxRepeatedWord();
       d1.checkWord("matter");
       d1.TestEfficiency();
       d1.NumberOfCollusion();
    }
    
}
