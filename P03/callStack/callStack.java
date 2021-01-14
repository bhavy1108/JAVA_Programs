public class callStack 
{
    public static void main(String[] args) 
    {
        int x=0;
        int y=1;
        
        new callStack().methodA(y);
        System.out.println("End of call stack");
    }
    public void methodA(int y)
    {
        System.out.println("methodA received value : "+y);
        methodB(y);
    }
    public void methodB(int y)
    {
        System.out.println("methodB received value : "+y);
        methodC();
    }
    public void methodC()
    {
        System.out.println("methodC");
    }
    
}
