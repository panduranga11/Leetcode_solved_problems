class Solution {
   
    public int minLights(int[] lights) {
        int n=lights.length;
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            int v=lights[i];
            if(v>0){
                int l=Math.max(0,i-v);
                int r=Math.min(n-1,i+v);
                arr[l]++;
                if(r+1<n){
                arr[r+1]--;
                }

            }
        }
        int cur=0;
        for(int i=0;i<n;i++){
            cur+=arr[i];
           arr[i]=cur;
        }
        int ind=0;
        int count=0;
        while(ind<n){
            if(arr[ind]>0){
                ind++;
                continue;
            }
            int j=ind;
            while(j<n && arr[j]==0){
                j++;
            }
            count+=(j-ind+2)/3;
            ind=j;
        }
        return count;
        
}
}




//  class Pair{
//         int ind;
//         int st;
//         int end;
//         Pair(int ind,int st,int end){
//             this.ind=ind;
//             this.st=st;
//             this.end=end;
//         }
       
        
//     }


// int n=lights.length;
//         int ans[]=new int[n];
//         ArrayList<Pair>p=new ArrayList<>();
//         for(int i=0;i<n;i++){
//             int v=lights[i];
//             if(v>0){
//          Pair pp=new Pair(i,Math.max(0, i - v),Math.min(n - 1, i + v));
//                 p.add(pp);
//             }
//         }
//         if(p.size()==0){
//             return (n+2)/3;
//         }
//         p.sort((a,b)->{
//             if(Integer.compare(a.st,b.st)==0){
//                 return Integer.compare(b.end,a.end);
//             }else{
//                 return Integer.compare(a.st,b.st);
//             }
//         });
//         // System.out.println(Arrays.toString(p));
//         int st=p.get(0).st;
//         int end=p.get(0).end;
//         for(int i=1;i<p.size();i++){
//             int curst=p.get(i).st;
//             int curend=p.get(i).end;
//             if(curst<=end){
//                 end=Math.max(curend,end);
//             }else{
//                 // System.out.println(st+" "+end);
//                 if(st<=end){
//                 for(int j=st;j<=end;j++){
//                     ans[j]=1;
//                 }
//                 }
//                 st=curst;
//                 end=curend;
//             }
//         }
//         //System.out.println(st+" "+end);
//         if(st<=end){
//         for(int i=st;i<=end;i++){
//             ans[i]=1;
//         }
//         }
//         // System.out.println(Arrays.toString(ans));
        
        
//         int ind=0;
//         int count=0;
//         while(ind<n){
//             if(ans[ind]==1){
//                 ind++;
//                 continue;
//             }
//             int j=ind;
//             while(j<n && ans[j]==0){
//                 j++;
//             }
//             count+=(j-ind+2)/3;
//             ind=j;
//         }
        
        
//         return count;
        
//     }