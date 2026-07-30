Iterating Through Arrays

Learn
int myarray[] = {10,20,30,40,50,60,70};
for:

for(int i =0;i < myarray.length;i++){
System.out.println("Element at index "+ i + " position "+ (i+1) + " is "+ myarray[i]);
}

Enhanced for:
int i = 0;
for(int items : myarray){
System.out.println("Element at index "+ i + " position "+ (i+1) + " is " + items);
i++;
}

while (practice):
int i =0;
while(i < myarray.length-1){
System.out.println("Element at index "+ i + " position "+ (i+1) + " is "+ myarray[i]);
i++;
}

Common Array Operations

Implement:

Sum
Average
Maximum
Minimum
Count even numbers
Count odd numbers

int arr[] = {10,20,30,40,50,60};

// sum
int sum = 0;
for (int i = 0;i< arr.length;i++){
sum += arr[i];

}
System.out.println("Sum of the entire array is: "+ sum);

//Average
double avg = sum/(double)arr.length ;
System.out.println("Avg of the entire array is: "+ avg);

//Maximum

int max = arr[0];
for(int i =1; i < arr.length ; i++){
if(max <= arr[i]){
max = arr[i];
}
}

System.out.println("Max of entire array is: "+ max);

//minimum
int min = arr[0];
for(int i = 1 ; i < arr.length ; i++){
if(min >= arr[i]){
min= arr[i];
}
}

System.out.println("Min of entire array is: "+ min);

// Count even numbers

int counteven = 0;
for(int i =0; i< arr.length ; i++){
if(arr[i] % 2 == 0){
counteven++;
}
}
System.out.println("no of even elements in array is : "+ counteven);

//count of odd number
int countodd = 0;
for(int i =0; i< arr.length ; i++){
if(arr[i] % 2 != 0){
countodd++;
}
}
System.out.println("no of odd elements in array is : "+ countodd);
