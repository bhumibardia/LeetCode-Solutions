bool canAliceWin(int n) {

   if (n < 10) {
        return false;
    }

    int a = 10, b = 9;
    int left = n - a;
    char turn = 'b';

while(left>0)
{
    if(b<=left && turn == 'b')
    {
        left=left-b;
        a=b-1;
        turn='a'; 
    }
    else if(turn == 'b')
    {
        return true;
    }
    else if(a<=left && turn == 'a')
    {
        turn='b';
        left=left-a;
        b=a-1;
    }
    else 
    {
        return false;
    }
    
}
if (turn=='a')
   {
        return false;
    }

else
{
    return true;
}

}



