wmic computersystem get domain
wmic bios get serialnumber

ipconfig /all
ipconfig /flushdns

rndc reload

ncpa.cpl

inetcpl.cpl

nslookup www.google.com

netstat -ano | find "80"
netstat -anb -p tcp | find "80"
taskkill /PID 4 /F

To Disable port 80
------------------

1) net stop http

OR

2) Device Manager -> Show Hidden Devices -> plug and play -> Http -> Stop

C:\windows\System32\drivers\Http.sys

msconfig | compmgmt | Device Manager
