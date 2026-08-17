I'm going to give you **6 new problems without telling you the pattern**.

For each, tell me:

**1. Pattern/approach**
**2. Why**
**3. What each pointer represents, if there are pointers**

### 1.

> Given a sorted array `[1, 2, 3, 4, 6, 8]`, determine whether there are two numbers whose difference is `5`.

### 2.

> Given `[2, 1, 5, 1, 3, 2]`, find the minimum sum of any **3 consecutive elements**.

### 3.

> Given `"madam"`, determine whether it is a palindrome.

### 4.

> Given `[3, -2, 7, 1, 4]`, determine whether any two numbers sum to `5`.

### 5.

> Given `[1, 2, 2, 3, 3, 3, 4]`, remove duplicates **in-place** so each value appears only once.

### 6.

> Given `[4, 8, 1, 9, 2, 7]`, find the largest element.

**Don't code them.** I want to see whether you can now recognize the underlying approach rather than recognize the wording from today's notes.

array is sorted we take two pointers and initialize them left =0 right = arr.length-1 we find diff between both positions diff = arr[right] - arr[left] then we check if diff = 5 found, else if diff >5 right--; else left++;

k = 3 , left = 0; right = (left+k)-1; int i = -1, int j = -1;currSum = arr[left]+arr[left+1]+arr[right]; maxSum = currSum; while(right < arr.length){ currSum = currSum - arr[left] + arr[right+1];left++;right++; if(currSum > maxSum){maxSum = currSum; i = left; j= right;} return [i,j];

static boolean Palindrome(String str) {

        boolean pal = true;

        int left = 0;

        int right = str.length();

while (left < right) {

if (str.charAt(left) != str.charAt(right)) {

                pal = false;

break;

            } else {

                left++;

                right--;

            }

        }

return pal;

    }

left = 0; right = arr.length-1;

    while (left < right) {

            int sum = (nums[left] + nums[right]);

if (target == sum) {

                ans[0] = left;

                ans[1] = right;

return ans;

            } else if (target < sum) {

                right--;

            } else {

                left++;

            }

        }

return ans;

slow = 0; fast = slow+1;

    while(slow != fast){

if(arr[slow] ==arr[fast]){fast++;}else{if(fast-1 != slow){for(int i = fast-1;i<arr.length;i++){arr[i] = arr[i+1];}}}

}
