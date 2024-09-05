# okm-review 
## [English](README.md) | [中文](README_zh.md)
okm-review是一个收集POC工具的项目，尤其是针对特定漏洞的.exe工具。
### 基本用法 （以CVE-2024-38077为例）：

![image](https://github.com/user-attachments/assets/8f5c3f21-b7ab-41c7-8db7-a4d808ec01f2)

### 参数说明：
&nbsp;&nbsp;&nbsp;&nbsp;-i&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;输入IP地址（段），如 192.168.1.1 或 192.168.1.1/24<br />
&nbsp;&nbsp;&nbsp;&nbsp;-v&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;打印OKM的版本<br />
&nbsp;&nbsp;&nbsp;&nbsp;-if&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;输入IP文件路径，每行一个IP地址<br />
&nbsp;&nbsp;&nbsp;&nbsp;-nf&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;将Nmap扫描结果文件作为输入时用到此参数，使用场景是在扫描完端口后用okm进行下一步验证。以CVE-2024-38077为例，Nmap扫描时应只扫135和3389端口，这样可以获得标准的Nmap输出文件<br />
&nbsp;&nbsp;&nbsp;&nbsp;-pl&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;显示目前包含的所有POC工具<br />
&nbsp;&nbsp;&nbsp;&nbsp;-poc&nbsp;&nbsp;指定扫描使用的POC，例如CVE-2024-38077<br />
&nbsp;&nbsp;&nbsp;&nbsp;-of&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;设置输出文件路径，并在扫描完成时生成<br />
&nbsp;&nbsp;&nbsp;&nbsp;-h&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;帮助文档<br />

### 总结
| 序号 | 目前支持的POC  |
| ---- | ----  |
|  1   | CVE-2024-38077 |
