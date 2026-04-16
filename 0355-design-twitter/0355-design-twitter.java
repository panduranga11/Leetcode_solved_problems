class Twitter {
    
    class Pair {  
        int uid;
        int tid;
        
        Pair(int uid, int tid) {
            this.uid = uid;
            this.tid = tid;
        }
    }

    Deque<Pair> q = new ArrayDeque<>();
   
    HashMap<Integer, Set<Integer>> map = new HashMap<>();

    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
       q.offerFirst(new Pair(userId, tweetId));
    
    }
    
    public List<Integer> getNewsFeed(int userId) {
       List<Integer>ls=new ArrayList<>();
       for(Pair p:q){
        int uid=p.uid;
        int tid=p.tid;
        if(uid==userId || (map.containsKey(userId) && map.get(userId).contains(uid))){           if(ls.size()<10){
            ls.add(tid);
        }else{
            break;
        }
        }

       }
       System.out.println(ls);
       return ls;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            
            return;

        }

        if (map.containsKey(followerId)) {
            map.get(followerId).add(followeeId);
           
        } else {
            Set<Integer> set = new HashSet<>();
            set.add(followeeId);
            
        
            map.put(followerId, set);  
        }
        //System.out.println(map.get(followerId));
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }

        if (map.containsKey(followerId)) {
            if (map.get(followerId).contains(followeeId)) {
                map.get(followerId).remove(followeeId);
                if(map.get(followerId)==null){
                    map.remove(followerId);
                }
            }
        }
      //  System.out.println(map.get(followerId));
    }
}