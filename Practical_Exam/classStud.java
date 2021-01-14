public class classStud
{

    private String studentName;
    private int studentId;

   public String getStudentName()
   {
        return studentName;
   }
   public int getStudentId()
   {
       return studentId;
   }
   public classStud()
   {
      studentName = null;
      studentId = 0;
   }
   public classStud(int u, String v) 
   {
       studentId = u;
       studentName = v;
   }
   public String toString()
   {

      return studentId + "," +
studentName;

    }

}
