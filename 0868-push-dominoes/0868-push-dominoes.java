class Solution {
    public String pushDominoes(String dominoes) {
        char[] dom = dominoes.toCharArray();
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < dom.length; i++) {
            if(dom[i] != '.'){
                q.add(new int[] {i, dom[i]});
            }
        }

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int i = curr[0];
            char d = (char) curr[1];

            if(d == 'L') {
                if (i > 0 && dom[i - 1] == '.') {
                    q.add(new int[] {i-1, 'L'});
                    dom[i-1] = 'L';
                }
            }
            else if(d == 'R') {
                if(i + 1 < dom.length && dom[i + 1] == '.') {
                    if(i + 2 < dom.length && dom[i + 2] == 'L'){
                        q.poll();
                    }
                    else {
                        q.add(new int[]{i + 1, 'R'});
                        dom[i + 1] = 'R';
                    }
                }
            }
        }

        return new String(dom);
    }
}