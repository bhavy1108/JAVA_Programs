/********************************************************
* Refence : Seenarain.B(2020).DSA/P10/practical 10.pdf
*********************************************************/

import java.util.Scanner;
import java.io.*; 
import java.math.*;

// class for hash entry 
class HashEntry 
{

 String key; 
 int val;   
 
 
 HashEntry(int val, String key) 
 {
 
  this.val = val;
  this.key = key;  
        
 }
 
}
 
 // class for hash table
 
class HashTab
{

  private int sizes; 
  private int TabSize;
  private HashEntry[] tab;
  private int Psizes;
 
 //constructor for hash table
 public HashTab(int t) 
 {
   TabSize = t;
   sizes = 0;
   tab = new HashEntry[TabSize];
  
   for (int i = 0; i < TabSize; i++)
   { 
      tab[i] = null;
      Psizes = getpsizes();       
   }
  } 
 
 // function getpsizes
 public int getpsizes()
 {
    for (int i = TabSize - 1; i >= 1; i--)
    {
       int facts = 0;
   
      for (int j = 2; j <= (int) Math.sqrt(i); j++)
      {  
         if (i % j == 0)
         {
           facts++;
         }
         if (facts == 0)
         {
          return i;
         }
       }
      }
    return 3;
 }
//getters 
 public int getSizes()
 {
  return sizes;
 }
 
 public boolean isEmpty()
 {
  return sizes == 0;
 }

 public void makeEmpty()
 {
   sizes = 0;
  
   for (int i = 0; i < TabSize; i++)
   { 
      tab[i] = null;
   }
 }
 

// function to insert key in table
 public void insertion(String key, int val) 
 {
   if (sizes == TabSize)
   {
      System.out.println(" Hashing table  is full."); 
      
      return;
    }           
  
    int hash01 = myhash01(key);
    int hash02 = myhash02(key);        
  
  while (tab[hash01] != null)
  {
  
   hash01 += hash02;
   hash01 %= TabSize;
   
  }
  
     tab[hash01] = new HashEntry( val, key);        
     sizes++;
 }
  
 // function to remove key in hash table
 public void removeKey(String key) 
 {
   int hash01 = myhash01(key);
   int hash02 = myhash02(key);        
  
   while (tab[hash01] != null && !tab[hash01].key.equals(key))
   { 
      hash01 += hash02;
      hash01 %= TabSize;
   }
   
    tab[hash01] = null;
    sizes--;
  }
 
 
 //function get a key
 public int get(String key) 
 {
   int hash01 = myhash01( key );
   int hash02 = myhash02( key );
 
  while (tab[hash01] != null && !tab[hash01].key.equals(key))
  {
     hash01 += hash02;
     hash01 %= TabSize;
  }
  
    return tab[hash01].val;
 }
 // function myhash01
 private int myhash01(String s)
 {
    int valHash;
    valHash = s.hashCode( );
    valHash %= TabSize;
  
  if (valHash < 0)
  {
   
   valHash += TabSize;
   
  }
  return valHash;
   
 }
 
 //function myhash02
 private int myhash02(String n )
 {
     int valHash;
     valHash = n.hashCode( );
     valHash %= TabSize;
  
   if (valHash < 0)
   {
     valHash += TabSize;
   }
   
  return Psizes - valHash % Psizes;
  
 }
 
 //function to display hash table 
 public void displayingHashTab()
 {
  System.out.println("\nThe Hash Table values:");
  
  for (int i = 0; i < TabSize; i++)
  {
   if (tab[i] != null)
   { 
    System.out.println(tab[i].key +" "+tab[i].val);
   }
  }
 }
 
 // code to read RandomNames7000.csv files
 public void readFile()
 { 
    int counter = 0;   
    int num = counterNumberlines() ;
 
    HashTab hash = new HashTab(num + 1);  
    String alpha[] = new String[num];         
    FileInputStream fileStrm = null;
  
     InputStreamReader rdr;
     BufferedReader bufrdr;
     String fileName = "RandomNames7000.csv";
 
  try
  {
  
   fileStrm = new FileInputStream(fileName);
   rdr = new InputStreamReader(fileStrm);
   bufrdr = new BufferedReader(rdr);
   String line;
   line = bufrdr.readLine();
  
  while (line != null)
  {               
    String [] Str = line.split(","); 
    int l = Integer.parseInt(Str[0]);
    String val= Str[1];
    hash.insertion(val, l);
    alpha[counter] = val;
    
    counter++;
    line = bufrdr.readLine();
    
   }
   
   fileStrm.close();
  }
  catch (FileNotFoundException e)
  {
   System.out.println("File not found " + e.getMessage());
  }
  catch (IOException ex2)
  {
  }   
  CreateFile(hash, alpha);  
 }

 public static void CreateFile(HashTab hash, String alpha[])
 { 
   String name = "HashTab.txt";
   String line;
  
  for(int i = 0; i < alpha.length ; i++)
  {
   line =( hash.get(alpha[i])+ " "+ alpha[i] );
   
   try
   {
    FileWriter fstream = new FileWriter(name, true);
    BufferedWriter out = new BufferedWriter(fstream);
    out.write(line+"\n");
    out.close();
   }
   catch (IOException e)
   {
   }
  }
  
  System.out.println("The file  HashTab.txt has been created \n");
 }

 public int counterNumberlines()
 {
 
  int counter = 0;
  FileInputStream fileStrm = null;
  InputStreamReader rdr;
  BufferedReader bufrdr;
  String fileName = "RandomNames7000.csv";
  
  try
  {
   fileStrm = new FileInputStream(fileName);
   rdr = new InputStreamReader(fileStrm);
   bufrdr = new BufferedReader(rdr);
   String line;
   line = bufrdr.readLine();
  
   while (line!= null)
   {
    counter = counter + 1;
    line = bufrdr.readLine();
   }
   fileStrm.close();
  }
  catch (FileNotFoundException e)
  {
   System.out.println(" File not been found " + e.getMessage());
  }
  catch (IOException ex2)
  {
  }      
  return counter;
 }
 
}


