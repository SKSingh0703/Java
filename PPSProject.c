#include <stdio.h>
#include <math.h>

// Function to scan a vector in order
void scan_vector(float vector[], int length) {
    for (int i = 0; i < length; i++) {
        printf("Enter no. %d element of the vector: \n", i+1);
        scanf("%f", &vector[i]);
    }
}

// Function to normalize a vector according to the formula
void normalize_vector(float vector[], int length) {
    float sum_of_squares = 0;
    // Calculate the sum of squares of all elements
    for (int i = 0; i < length; i++) {
        sum_of_squares += vector[i] * vector[i];
    }
    // Calculate the square root of the sum of squares
    float magnitude = sqrt(sum_of_squares);
    // Normalize each element of the vector
    for (int i = 0; i < length; i++) {
        vector[i] =vector[i]/ magnitude;
    }
}

// Function to print a vector
void print_vector(float vector[], int length) {
    printf("Normalized vector: \n");
    for (int i = 0; i < length; i++) {
        printf("x%d=%f \n",(i+1), vector[i]);
    }
    printf("\n");
}

int main() {
    int length;

    // Repeat scanning and normalizing vectors
    char choice;
    do {
        printf("Enter the length of the vector: ");
        scanf("%d", &length);

        //To Store the value of diffferent components of vector in order
        float vector[length];

        scan_vector(vector, length);
        normalize_vector(vector, length);
        print_vector(vector, length);

        printf("Do you want to enter another vector? (y/n): ");
        scanf(" %c", &choice); // Note the space before %c to consume the newline character

    } while (choice == 'y' || choice == 'Y');

    return 0;
}