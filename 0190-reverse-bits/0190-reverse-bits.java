class Solution {
    public int reverseBits(int n) {
        String b=String.format("%32s",Integer.toBinaryString(n)).replace(' ','0');
        StringBuffer sb=new StringBuffer(b);
        sb.reverse();
        b=sb.toString();
        return (int)Long.parseLong(b,2);
    }
}