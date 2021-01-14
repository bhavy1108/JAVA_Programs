import java.util.*;

public class equaSolver
{



    private char nextTerm(String Val, int y)
    {

       char value = 0;
        if (y < Val.length())
        {
              value =  Val.charAt(y);

        }
        return value;
    }

    public double solving(String equa)
    {
    
       double soln = 0;
       DsaQ q = parseInfixToPost(equa);
       soln = postFixEval(q);
      return soln;



    }
    
    private int precedent(char operator )
    {

         int answer = 0;
         if( (operator == '-') || ( operator == '+'))
          {

               answer =  1;

          } 
         else if (( operator == '/' ) || (operator == '*'))
          {

               answer = 2;

          }
          return answer;
    }


    private double operationExecute( char operate, double operate1 , double operate2)
    {
    
    
       double soln = 0;
       switch (operate)
       {
       
       
           case '+' :
                   soln = operate1 + operate2;
                   break;
         
           case '*':
                   soln = operate1 * operate2;
                   break;
           case '-':
                   soln = operate1 - operate2;
                   break;
           case '/':
                   soln =  operate1 / operate2;
                  break;
        }
        return soln;
      }



    private double postFixEval(DsaQ postFixQ)
    {

       double solution = 0;
       DsaStack s  = new DsaStack();

       do 
        {

          if (precedent(postFixQ.peek().charAt(0)) ==0)
          {
             
                 s.push(postFixQ.dequeue());
          }
         else 
         {
              char operator = Character.valueOf(postFixQ.dequeue().charAt(0)); 
              double value2 = Double.parseDouble(s.pop());
              double value1 = Double.parseDouble(s.pop());
              solution = operationExecute(operator, value1, value2);
              s.push(Double.toString(solution));
             
          }


       }while(!postFixQ.isEmpty());
       return solution;
    }
    
    private DsaQ parseInfixToPost(String equation)
    {
    
       int position = 0;
       char terms = nextTerm(equation , position);
       String temp = "";
       
       // postfix operation - seperate opertors AND opreand  - hence converting infix to postfix would be easier
       
         while (terms != Character.UNASSIGNED)
         {
            if(precedent(terms) == 0)
            {
               temp = temp + terms;
            }
            else
            {
                temp = temp + "" + terms + "";
            
            }
            position++;
            terms = nextTerm(equation, position);
         }
         
         //remove redundant spaces 
         equation = temp.trim().replaceAll("\\s+", " ");   
         // creates a new stack
         DsaStack s = new DsaStack();
         position = 0;
         String postFix = " ";
         String stringProcess  = "";
         
        do 
        {
           if (terms == '(')
           {
              s.push("(");
           }
           else if (terms  == ')')
           {
              do
              {
                stringProcess = stringProcess + s.pop(); 
              
 	      }while(s.top() != "(");
           }
           else if ( (terms == '+' ) || (terms == '-' ) || (terms == '/') || (terms == '*'))
           {
            
                while ((!s.isEmpty()) && (s.top() != "(") && (precedent(s.top().charAt(0)) >= precedent(terms)))
                {
                
                
                    stringProcess = stringProcess + s.pop();
                 }
                 s.push(Character.toString(terms));
             }
             else
             {
           
                 stringProcess = stringProcess + terms;
                
             }
             position++;
             terms = nextTerm(equation, position);
           
           
                 
         }while(terms != Character.UNASSIGNED);
         
         
         while(!s.isEmpty())
         {
         
             stringProcess = stringProcess + s.pop();
         
         }
         //replace all extra space by single space 
         stringProcess = stringProcess.trim().replaceAll("\\s+", "");
         position = 0;// set possition to 0 - to extract value frm the str stringProcess
         
         terms = nextTerm(stringProcess, position);
         
         while(terms != Character.UNASSIGNED)
          {
             //CHECK NIF NEXT TERM IS AN OPERATOR OR SPACE
             if ((precedent(nextTerm(stringProcess, position + 1))  !=0 ) || nextTerm(stringProcess, position + 1)  == ' ' )
             {
             
                postFix = postFix + terms + ",";
             
             }
             // else add current terms to postFix
             else 
             {
             
                 postFix = postFix + terms;
             }
             position++;
             //next char extracted
             terms = nextTerm(stringProcess , position);
          }
          
          //replace all spaces with nothing
          postFix = postFix.trim().replaceAll("\\s+", "");    
          
          // replace 2 or more consecutive commas with a single comma
          
          postFix = postFix.trim().replaceAll(",,+", ","); 
          
          DsaQ q = new DsaQ();
          String[] tok = postFix.split(",");
          
          for (int w = 0; w < tok.length; w++)
          {
          
             q.enqueue(tok[w]); 
          }  
          return q;
       }  
       
    }   
