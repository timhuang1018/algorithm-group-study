/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
bool* camelMatch(char ** queries, int queriesSize, char * pattern, int* returnSize){

  *returnSize = queriesSize;
  bool *result = malloc(*returnSize * sizeof(*result));
  
  for (int i = 0; i < queriesSize; ++i) {

    char tmp[100];
    int n_tmp = 0; 
    for (int j = 0, k = 0; queries[i][j]; ++j) {
      if (isupper(queries[i][j]))
        tmp[n_tmp++] = queries[i][j], ++k;
      else if (k <= strlen(pattern) && islower(pattern[k]) &&
               queries[i][j] == pattern[k])
      tmp[n_tmp++] = queries[i][j], ++k;
    }

    tmp[n_tmp] = '\0';
    printf("%s\n", tmp);
    result[i] = !strcmp(tmp, pattern);
  }
  
  return result;
}
