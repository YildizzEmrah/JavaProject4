/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emrahyildiz_hw4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author emrah
 */
public class HW4_Hash implements HW4_Interface {
    
    
   public myList first;
   public myList last;
   public int arrsize;
   public myList[] hashArr;
   public String[] word;
   public String[] cleanWord;
   public String[] outWord;
   public int strcount;
   public int[] countNumber;
   public int sum;
   public int NumberofC;
   
   public HW4_Hash () {
   
       first=null;
   
   }

     @Override
    public Integer GetHash(String mystring) {
        int sum=0;
        int E;
        int c=1;
        char[] convert=new char[mystring.length()];
        convert=mystring.toCharArray();
         for(int m=0;m<mystring.length();m++){
         
         E=m*(c*c);
         c++;
         char x =convert[m];
         int ascii=x;
         sum+=(E*ascii);
         }
           return sum;
    }

    
    public void ReadFileandGenerateHash(String filename, int size) {
      try{  
        arrsize=size;
      /*  hashArr = new myList[arrsize];
        for(int i=0;i<arrsize;i++) {
        
        hashArr[i]=new myList();
        hashArr[i].value=-1;
        }*/      
        hashArr=new myList[arrsize];
         for (int i = 0; i < arrsize; i++){
           hashArr[i] = null;        
        }
        FileReader frr = new FileReader(filename);
        BufferedReader brr = new BufferedReader(frr);
        String linee=brr.readLine();
        int strcountt=1;
        String[] strr;
       while (linee!= null) {
          strr=linee.split(" ");        
              strcountt+=strr.length;
                              
        linee=brr.readLine();
        
       }
       strcount=strcountt;
       brr.close();
         
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String line=br.readLine();
        String[] str= line.split(" ");
        word=new String[strcount];
        int j=0;
         int ey=0;
       while (line!= null) {
          str= line.split(" ");
                 
               for(int i=ey;i<str.length;i++) {
                   String a=str[i].replace(",","");
                   String b=a.replace(".","");
                   String c=b.replace("?","");
                   String d=c.replace(";","");
                   String e=d.replace(":","");
                   String f=e.replace(" ","");
                   String g=f.replace("“","");
                   String h=g.replace("”","");
                   String k=h.replace("!","");
                   
                   word[j]=k.toLowerCase();
                   
                 //  System.out.println(word[j]);
                
                j++;
            }       
                              
        line=br.readLine();
        
       }
       br.close();
       int hashTable;
    
      for(int k=0;word[k]!=null;k++) {
      //    System.out.println(word[k]);
        int eyildiz=GetHash(word[k]);
        hashTable=(eyildiz % arrsize);
   //  System.out.println(eyildiz);
        if(hashArr[hashTable]==null) {
  
                hashArr[hashTable]=new myList(eyildiz);
            // System.out.println("Position "+ hashTable + " for" + hashArr[hashTable].value);
        }
        else {
            myList entry = hashArr[hashTable];
          while (entry.next != null && entry.value!=eyildiz) {
              
              entry=entry.next;
          }
          if(entry.value==eyildiz) {
              entry.value=eyildiz;
          
        }
          
          else {
          
          entry.next=new myList(eyildiz);
          }
        }
        
       }
      
    
      }
      
    
    
    catch (Exception e) {
    
    System.out.println("You are entered something wrong");
    }
    }

   
    public void DisplayResult(String Outputfile) {
       outWord=new String[strcount];
        int l=0;
        int counterr=0;
        
        for(int c=0;word[c]!=null;c++) {
        for(int d=0;word[d]!=null;d++) {
        if(word[c].equals(outWord[d])) {
             counterr++;
        }
    }
        if(counterr<1) {
         outWord[l]=word[c];
        l++;
        
        }
        counterr=0;
        }
       countNumber=new int[strcount];
        int count=0;
        for(int b=0;outWord[b]!=null;b++) {
        for(int a=0;word[a]!=null;a++) {
          if(outWord[b].equals(word[a])) {
              count++;
        }
       }
        countNumber[b]=count;
        count=0;
       }
       try {
      FileWriter fw = new FileWriter(Outputfile);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for(int y=0;outWord[y]!=null;y++) {
                bw.write(outWord[y]+" " +countNumber[y]);
                bw.write(" \n");
            }     
            bw.close();
        }

        catch(Exception e){
            System.out.println("File could not be read");
        }
        
        
        
    }
 
    public void DisplayResult() {
        cleanWord=new String[strcount];
        int l=0;
        int counterr=0;
        
        for(int c=0;word[c]!=null;c++) {
        for(int d=0;word[d]!=null;d++) {
        if(word[c].equals(cleanWord[d])) {
             counterr++;
        }
      
        
        }
        if(counterr<1) {
         cleanWord[l]=word[c];
        l++;
        
        }
        counterr=0;
        }
        
        
    
        int count=0;
        for(int b=0;cleanWord[b]!=null;b++) {
        for(int a=0;word[a]!=null;a++) {
          if(cleanWord[b].equals(word[a])) {
              count++;
        }
       
        }
         System.out.println("The word " + "“ " + cleanWord[b]+ " ”" + " is used " + count + " times. ");
        count=0;
        
        }
    }

  
    public void DisplayResultOrdered(String Outputfile) {
         outWord=new String[strcount];
        int l=0;
        int counterr=0;
        
        for(int c=0;word[c]!=null;c++) {
        for(int d=0;word[d]!=null;d++) {
        if(word[c].equals(outWord[d])) {
             counterr++;
        }
      
        
        }
        if(counterr<1) {
         outWord[l]=word[c];
        l++;
        
        }
        counterr=0;
        }
        
        countNumber=new int[strcount];
        int count=0;
        for(int b=0;outWord[b]!=null;b++) {
        for(int a=0;word[a]!=null;a++) {
          if(outWord[b].equals(word[a])) {
              count++;
        }
       
        }
        countNumber[b]=count;
        count=0;
        
        }
        for (int k=0; k<countNumber.length;k++) {
            
            int max=k;
           for(int t=k+1;t<countNumber.length;t++) {
               if(countNumber[t]>countNumber[max]) {
               max=t;
               }    
           } 
           int temp=countNumber[k];
           String p=outWord[k];
           countNumber[k]=countNumber[max];
           outWord[k]=outWord[max];
           countNumber[max]=temp;
           outWord[max]=p;
            
        
        }
        
   
        try {


            FileWriter fw = new FileWriter(Outputfile);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for(int y=0;outWord[y]!=null;y++) {
                bw.write(outWord[y]+" " +countNumber[y]);
                bw.write(" \n");
            }
         
            bw.close();


        }

        catch(Exception e){
            System.out.println("File could not be read");
        }
        
        
      
    }
    
      
    public int showFrequency(String myword) {
        int count=0;
        for(int a=0;word[a]!=null;a++) {
        if(myword.equals(word[a])) {
        count++;
        }        
        }
        if(count>0) {
            System.out.println("Frequency is "+ " “" + myword+"”  : " + count);
        }
        
        else 
        {
        System.out.println( myword+ " is not found in the text ");
      

        }
    return -1;
    }

 
    public String showMaxRepeatedWord() {
        
        
       String maxRepeat=word[0];
        int oldcount=0;
        int count=0;
        for(int b=0;word[b]!=null;b++) {
        for(int a=0;word[a]!=null;a++) {
          if(word[b].equals(word[a])) {
              count++;
        }}
        
          if(count>oldcount) {
          oldcount=count;
          maxRepeat=word[b];
          count=0;
          
          }
          count=0;
          
              
        }
       
       System.out.println("The most repeated word is : " + maxRepeat);
       
        return maxRepeat;
    }

    
    public int checkWord(String myword) {
  try {    
      int countt=0;
     String mynewword=myword.toLowerCase();
      for(int a=0;word[a]!=null;a++) {
      if(word[a].equals(myword)) {
      countt++;      
      }    
      }
      
      if(countt!=0) {
        int location;
      location=GetHash(mynewword)%arrsize;

      
      System.out.print("Your word location is " + location);
      
         int konum=0;
         int count=0;
         int k=0;
           
       if(GetHash(mynewword)==hashArr[location].value){
           
       System.out.print(" and first veriable in this location. ");

       }
  
       
       else {
       while(hashArr[location].next!=null) {
        {
           count++;
         
          if(hashArr[location].next.value==GetHash(mynewword))
          {
              
              System.out.println(" and position is " + count);
          break;
          }
         hashArr[location]=hashArr[location].next;
         
       }       
       }
       }
        
      System.out.println(""); }
      
      else  {
      System.out.println("Your word is not on the list.");
      }
  
  }
        catch (Exception e) {
    
    System.out.println("Your word is not on the list.");
    }
  String mynewword=myword.toLowerCase();
    int s=GetHash(mynewword)%arrsize;
        return s;
    }

    
    public float TestEfficiency() {
        float TE=NumberofC/arrsize;
                if(TE<arrsize*10) {
                System.out.println("Test Efficiency is " + TE );
                
                }
                
                else {
                 System.out.println("Test Efficiency is unsuccessful" );

                }
                return TE;

    }


    public int NumberOfCollusion() {
           
          int k=0;
            int Noc=0;
      while(hashArr[k]!=null) {
       while(hashArr[k].next!=null) {
           Noc++;
        hashArr[k]=hashArr[k].next;
       
       }
      // if(k!=arrsize) {
     k++;
     //  }
     //  else {    
     //  break;}
     }
        System.out.println("Number of collusion is = " + Noc);
       NumberofC=Noc;
        return Noc;
    }
    
    
     public void testing() {
         
       int i=0;
       while(i<arrsize) {
       
        System.out.println(hashArr[i].value);
        i++;
       }
       int k=0;
       int b=0;
     while(hashArr[k].next!=null) {
       while(hashArr[k].next!=null) {
        System.out.println(hashArr[k].next.value);
        hashArr[k]=hashArr[k].next;
       
       }
       if(k!=arrsize-1) {
     k++;
       }
       else {
       
       break;}
     }
       }
     
    
}
      /*  for(int q=0;q<arrsize;q++) {
       System.out.println("k = " +hashArr[q].next.value);
        hashArr[q]=hashArr[q].next;
        
        }*/
        
