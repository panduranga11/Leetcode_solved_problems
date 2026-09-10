class MyCalendarThree {
    int max=0;
    class Pair{
        int val;
        int sign;

        Pair(int val,int sign){
            this.val=val;
            this.sign=sign;
        }
        public String toString(){
return this.val+" "+this.sign;
        }
    }
ArrayList<Pair>ls;
    public MyCalendarThree() {
        this.ls=new ArrayList<>();
    }
    
    public int book(int startTime, int endTime) {
       ls.add(new Pair(startTime,1));
       ls.add(new Pair(endTime,-1));
       //System.out.println(ls);
       ls.sort((a,b)->{
        if(Integer.compare(a.val,b.val)==0){
            return Integer.compare(a.sign,b.sign);
        }
        return Integer.compare(a.val,b.val);
       });
       int c=0;
       
       for(Pair p:ls){
        c+=p.sign;
max=Math.max(max,c);
       }
       return max;
    }
    
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */