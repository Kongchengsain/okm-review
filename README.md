# okm-review
This project is a tool that collects POCs, especially the. exe tool targeting specific vulnerabilities. This project connects users and specific tools through adhesive code, eliminating the hassle of searching and the shortcomings of the original tools.
# Basic Usage：
<img width="776" alt="ff05e36698439b7ea8d28bf94858ee1" src="https://github.com/user-attachments/assets/69c17ee4-a747-4162-a58b-ee65c33790ac">

# Usage：
  -i    Input the target ip address like 192.168.1.1 or ip scope like 192.168.1.1/24<br />
  -v    Print the version of OKM<br />
  -if   Set an input file path which contains a lot of ip address arranged as one per line<br />
  -nf   Set an input file path that Nmap has scanned over and generated.Meanwhile,It's better to contain only two port which are 135 and 3389<br />
  -pl   Show all of the POCs currently included<br />
  -poc  Set a poc name when scanning,such as CVE-2024-38077<br />
  -of   Set an output file path which contains all of the vulnerable ips and will be generated when scanning over<br />
  -h    Show help document<br />
