class Solution 
{
    public boolean isPalindrome(int x) 
    {
        int n=x;int s=0;int a;
      if(x<0)
      return false;
      else
      {
          while(n!=0)
          {
              a=n%10;
              s=s*10+a;
              n=n/10;
          }
          if(x==s)
          return true;
          else
          return false;
      }  
    }
}