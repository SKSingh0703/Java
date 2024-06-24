#include <stdio.h>
#include <stdlib.h>

int main() {
    FILE *sourceFile, *destinationFile;
    char ch;

    // Open source file for reading
    sourceFile = fopen("source.txt", "r");
    if (sourceFile == NULL) {
        printf("Error opening source file\n");
        return 1;
    }

    // Open destination file for writing
    destinationFile = fopen("destination.txt", "w");
    if (destinationFile == NULL) {
        printf("Error opening destination file\n");
        fclose(sourceFile);
        return 1;
    }

    // Copy contents of source file to destination file
    while ((ch = fgetc(sourceFile)) != EOF) {
        fputc(ch, destinationFile);
    }

    // Close files
    fclose(sourceFile);
    fclose(destinationFile);

    printf("File copied successfully\n");

    return 0;
}

