void reverseString(char* s, int sSize){
    int b = 0;
    int e = sSize - 1;
    while (b <= e) {
        char temp = s[b];
        s[b] = s[e];
        s[e] = temp;
        b++;
        e--;
    }
    return s;
}