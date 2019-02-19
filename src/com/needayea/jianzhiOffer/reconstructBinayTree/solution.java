package com.needayea.jianzhiOffer.reconstructBinayTree;

/**
 * @author lixiaole
 * @date 2018/9/21 15:37
 */

/**
 * ����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡���
 * ������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
 *
 * ˼����
 *      ������
 *          ǰ������ص�   ������
 *          ��������ص�   �����
 *      1 ���ڵ���ǰ�������Ϊ��һ������  ���±�Ϊ0������
 *      2 �ҵ����ڵ��ֵ�ȿ����ҵ����ڵ�����������е�λ��
 *      3 ͨ�����ڵ�����������е�λ�û�����������ĳ���
 *      4 �����䳤�ȹ�������������ǰ�����������
 *      5 �ݹ�
 */
public class solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
       if(pre.length <=0 || in.length<=0 || pre.length!= in.length)
           return null;
       TreeNode root = new TreeNode(pre[0]);
       int i = 0;
       // ��ȡ ���ڵ�����������е�λ��   �Ӷ������Ϊ������������
       while(in[i] != root.val){
           i++;
       }
       // ����������  ǰ�������
       int[] leftPre = new int[i];
       int[] leftIn  = new int[i];

       // ����������ǰ����
        // ����Ϊin.length-i-1 �ǲ�����root�ڵ�
       int[] rightPre = new int[in.length-i-1];
       int[] rightIn = new int[in.length-i-1];

       for(int j = 0 ; j<in.length;j++){
           if(j<i){
               leftPre[j] = pre[j+1];// ǰ������ĵ�һ���ڵ�Ϊ���ڵ� ����
               leftIn[j] = in[j];
           }else if(j>i){
               rightPre[j-i-1] = pre[j];
               rightIn[j-i-1] = in[j];
           }
       }
       // ����������
       root.left = reConstructBinaryTree(leftPre,leftIn);
       // ����������
       root.right = reConstructBinaryTree(rightPre,rightIn);
       return root;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
