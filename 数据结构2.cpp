#include <stdio.h>
#include <stdlib.h>
#include <string.h>
char preorder[100000];
char inorder[100000];
// 定义二叉树结点结构
typedef struct TreeNode {
    char data;
    struct TreeNode* left;
    struct TreeNode* right;
} TreeNode;

// 创建二叉树结点
TreeNode* createNode(char data) {
    TreeNode* newNode = (TreeNode*)malloc(sizeof(TreeNode));
    newNode->data = data;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;
}

// 根据先序遍历序列和中序遍历序列还原二叉树
TreeNode* buildTree(char* preorder, char* inorder, int start, int end) {
    static int preIndex = 0;

    if (start > end) {
        return NULL;
    }

    TreeNode* root = createNode(preorder[preIndex++]);

    int inIndex;
    for (int i = start; i <= end; i++) {
        if (inorder[i] == root->data) {
            inIndex = i;
            break;
        }
    }

    root->left = buildTree(preorder, inorder, start, inIndex - 1);
    root->right = buildTree(preorder, inorder, inIndex + 1, end);

    return root;
}

// 计算二叉树的深度
int calculateDepth(TreeNode* root) {
    if (root == NULL) {
        return 0;
    }

    int leftDepth = calculateDepth(root->left);
    int rightDepth = calculateDepth(root->right);

    return (leftDepth > rightDepth) ? (leftDepth + 1) : (rightDepth + 1);
}

// 计算二叉树的叶子节点数量
int calculateLeafCount(TreeNode* root) {
    if (root == NULL) {
        return 0;
    }

    if (root->left == NULL && root->right == NULL) {
        return 1;
    }

    int leftLeafCount = calculateLeafCount(root->left);
    int rightLeafCount = calculateLeafCount(root->right);

    return leftLeafCount + rightLeafCount;
}

// 释放二叉树的内存
//void freeTree(TreeNode* root) {
//    if (root == NULL) {
//        return;
//    }
//
//    freeTree(root->left);
//    freeTree(root->right);
//    free(root);
//}

int main() {

	scanf("%s",preorder);
	scanf("%s",inorder);
    int length = strlen(preorder);

    TreeNode* root = buildTree(preorder, inorder, 0, length - 1);

    int depth = calculateDepth(root);
    int leafCount = calculateLeafCount(root);

    //printf("二叉树的深度为：%d\n", depth);
    //printf("二叉树的叶子节点数量为：%d\n", leafCount);
    printf("%d\n",depth);
    printf("%d\n",leafCount);
    //freeTree(root);

    return 0;
}

