# leet-code
LeetCode

## config
- TempFilePath:
  - LeetCode 代码的 src 源目录
  - PS: leet-code\src\main\java


- Custom Template 选中！

- Code FileName:

    - >P$!{question.frontendQuestionId}$!velocityTool.camelCaseName(${question.titleSlug})


- Code Template:
  - ```java
    package leetcode.editor.cn;
    
    ${question.content}
    public class P$!{question.frontendQuestionId}$!velocityTool.camelCaseName(${question.titleSlug}){
    
        public static void main(String[] args) {
            Solution solution = new P$!{question.frontendQuestionId}$!velocityTool.camelCaseName(${question.titleSlug})().new Solution();
        }
    
    ${question.code}
    }
    ```