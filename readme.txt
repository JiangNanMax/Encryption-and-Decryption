1.先说明一下src文件夹中的各个类的作用：
     homework_1类就是程序的入口类，在创建startpage类的实例，进入主程序。
     startpage类实现功能的选择，即选择进行加密或者解密。
     encryption类是加密类，它提供明文和密钥的输入，点击加密按钮后调用encryption_solve类，进行加密并显示加密结果。
     encryption_solve类实现加密和加密结果显示。
     decryption类是解密类，它提供密文和密钥的输入，点击解密按钮后调用decryption_solve类，进行解密并显示解密结果。
     encryption_solve类实现加密和加密结果显示。

2.然后说明我的加密解密算法和支持的字符输入：
     我的加密解密算法包含了替换和置换。首先是替换，通过输入的密钥，得到新的字母表排列，进行替换；然后是置换，我这里设置的置换方法是根据明文的长度，循环移位二分之一长度。
     明文输入支持大小写字母和空格，密钥输入支持大小写字母。为了增加加密的复杂度，这里处理空格的方式如下：给出了一个字符数组，包含字符 #,@,$,%,^,&,*,（,),_ 10种，对每一个空格替换成10个字符的其中一个，通过随机函数来进行随机选择其中一个字符，所以对空格的处理每次都不同，增加了迷惑性。

3.运行方法：
     直接点击运行homework_1.jar,(这里要求电脑已安装java环境)。

4.查看内部代码：
     src文件中包括了所有的类实现。

5.正确性：
     已经测试了多个实例，加密和解密得到的结果是相符合的。
     例如：
         明文：jiangnan homework
         密钥：information
	 加密结果：%tjgrwjpdcbihahih

	然后对加密结果进行解密得到：jiangnan homework
     结果相符合。
