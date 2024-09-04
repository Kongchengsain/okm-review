# okm-review
This project is a tool that collects POCs, especially the. exe tool targeting specific vulnerabilities. This project connects users and specific tools through adhesive code, eliminating the hassle of searching and the shortcomings of the original tools.
### Basic Usage (Such As CVE-2024-38077)：

<img width="877" alt="2d35e8cb6acfeb32774399fad08cb6c" src="https://github.com/user-attachments/assets/046aa7b3-9548-4359-9a31-93aa1fc78517">


### Usage：
&nbsp;&nbsp;&nbsp;&nbsp;-i&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Input the target ip address like 192.168.1.1 or ip scope like 192.168.1.1/24<br />
&nbsp;&nbsp;&nbsp;&nbsp;-v&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Print the version of OKM<br />
&nbsp;&nbsp;&nbsp;&nbsp;-if&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Set an input file path which contains a lot of ip address arranged as one per line<br />
&nbsp;&nbsp;&nbsp;&nbsp;-nf&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Set an input file path that Nmap has scanned over and generated.Meanwhile,It's better to contain only two port which are 135 and 3389<br />
&nbsp;&nbsp;&nbsp;&nbsp;-pl&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Show all of the POCs currently included<br />
&nbsp;&nbsp;&nbsp;&nbsp;-poc&nbsp;&nbsp;Set a poc name when scanning,such as CVE-2024-38077<br />
&nbsp;&nbsp;&nbsp;&nbsp;-of&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Set an output file path which contains all of the vulnerable ips and will be generated when scanning over<br />
&nbsp;&nbsp;&nbsp;&nbsp;-h&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Show help document<br />
