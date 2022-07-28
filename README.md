# JavaStringUtils
desicription: JAVA字符串常用功能

## 1、MatchIPAddress
 - 判断字符串是否是IP地址
   - 对于IPv4，以“.”分隔，依次验证分组为4，每组字符数量num ∈ (0,4]，只包含数字且没有前缀0，数字在0-255范围内。
   - 对于IPv6，以“:”分隔，依次验证分组为8，分割不能缺省，每组字符数量num ∈ (0,4]，不能出现除数字和大小写a-f以外的字符。