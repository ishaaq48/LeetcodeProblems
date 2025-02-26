class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         int n1 = nums1.length;
         int n2 = nums2.length;
         int n = n1 + n2;
         int ind2 = n / 2;
         int ind1 = ind2 - 1;
         int i =0, j = 0;
         int cnt = 0;
         int ind1_el = 1, ind2_el = 1;
         while(i < n1 && j < n2){
            if(nums1[i] < nums2[j]){
                if(cnt == ind1) ind1_el = nums1[i];
                if(cnt == ind2) ind2_el = nums1[i];
                cnt++;
                i++;
            } else {
                if(cnt == ind1) ind1_el = nums2[j];
                if(cnt == ind2) ind2_el = nums2[j];
                cnt++;
                j++;
            }
         }

         while(i < n1){
            if(cnt == ind1) ind1_el = nums1[i];
            if(cnt == ind2) ind2_el = nums1[i];

            cnt++;
            i++;
         }

          while(j < n2){
            if(cnt == ind1) ind1_el = nums2[j];
            if(cnt == ind2) ind2_el = nums2[j];

            cnt++;
            j++;
         }

         if( n % 2 == 1) return (double) ind2_el;

         return (double)((double) ind1_el + ind2_el) / 2.0;
    }
}