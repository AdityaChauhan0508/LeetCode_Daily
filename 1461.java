class Solution {
    public boolean hasAllCodes(String s, int k) {
        
        int n = s.length();
        if (k > n) return false;
        
        boolean[] seen = new boolean[1 << k];
        int count = 0;
        int mask = (1 << k) - 1;
        int hash = 0;
        
        for (int i = 0; i < n; i++) {
            // Build rolling hash
            hash = ((hash << 1) & mask) | (s.charAt(i) - '0');
            
            if (i >= k - 1) {
                if (!seen[hash]) {
                    seen[hash] = true;
                    count++;
                    
                    if (count == (1 << k))
                        return true;
                }
            }
        }
        
        return false;
    }
}