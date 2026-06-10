def minToMaxHeap(nums):
    n = len(nums)

    for i in range(n//2 - 1, -1, -1):
        heapify(i,nums)

    return nums
  
def heapify(i , nums):
    largest = i
    left = 2*i + 1
    right = 2*i +2
    n = len(nums)

    if left<n and nums[largest]<nums[left]:
        largest = left
    if right<n and nums[largest]<nums[right]:
        largest = right

    if largest!=i:
        nums[i] , nums[largest] = nums[largest] , nums[i]

        heapify(largest,nums)

    return

nums = [10, 20, 30, 21, 23]
print(minToMaxHeap(nums))