C:
-----------
cat /etc/os-release
cat /etc/issue
cat /etc/os-release
cat /etc/lsb-release
cat /etc/apt/sources.list


D:
----------
df -h
df -Th
dmesg

E:
----------

echo $(uname -r)
echo $LANG

H:
--------------
hostnamectl


F:
----------

fuser -m MOUNT_POINT

L:
-------------
lsb_release -a
lsb_release -d
lsb_release -cs
locale
lsmod | egrep 'cifs'



G
------------
gnome-system-monitor


M:
---------
mount /var/backups
mount 10.10.0.10:/backups
mount.cifs --version


S:
----------

sudo nano /etc/fstab
sudo nano /etc/fstab   --------->  sudo mount -a
sudo nano /etc/environment
source /etc/environment

sudo apt install linux-modules-extra-$(uname -r)
sudo apt install linux-generic
sudo apt remove firefox --pruge (to remove a software)
sudo dpkg -i code.deb ( to install a software) 

systemctl -t service -a |grep Samba

sudo apt-get install 

sudo apt install ./google-chrome-stable_current_amd64.deb	

sudo passwd ====> to change root user password from current user
sudo snap install notepad-plus-plus
sudo apt-get update 
sudo apt-get upgrade
sudo apt-get install 
sudo apt-get remove
sudo apt-get check
dpkg --list
sudo apt-get remove <package-name>
sudo apt-get purge <package-name>
sudo apt-get autoremove
sudo apt install ./google-chrome-stable_current_amd64.deb
sudo lsblk -o NAME,FSTYPE,SIZE,MOUNTPOINT,LABEL
sudo apt update
sudo apt install openjdk-8-jdk


sudo apt update
sudo apt update
sudo apt install cifs-utils
sudo apt-get update && apt-get install -y iputils-ping
sudo dnf install cifs-utils
sudo apt install nfs-common
sudo mkdir /var/backups
sudo mount -t nfs 10.10.0.10:/backups /var/backups

sudo mkdir /var/backups
sudo mkdir /mnt/win_share

sudo mount -t cifs -o username=<win_share_user> //WIN_SHARE_IP/<share_name> /mnt/win_share
sudo mount -t cifs -o username=<win_share_user>,password=<win_share_password> //WIN_SHARE_IP/<share_name> /mnt/win_share
sudo mount -t cifs -o username=<win_share_user>,domain=<win_domain> //WIN_SHARE_IP/<share_name> /mnt/win_share
sudo chown root: /etc/win-credentials
sudo chmod 600 /etc/win-credentials
sudo mount -t cifs -o credentials=/etc/win-credentials //WIN_SHARE_IP/<share_name> /mnt/win_share
sudo umount /mnt/win_share

systemctl -t service -a 
systemctl status docker
sudo systemctl -t service -a | grep 'Samba'




U
----
umount 10.10.0.10:/backups 
umount /var/backups
umount -l MOUNT_POINT
umount -f MOUNT_POINT

W:
-----------------
wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb


Very General Commands
--------------------

ls
cd
mv
rm
mkdir
history
df
du
free
uname -a
top
man man
man intro 
info
man -h 
man -help
whatis cd
whatis man
whatis help

Others:
=====================

1) in  /etc/fstab  for network Share
10.10.0.10:/backups /var/backups  nfs      defaults    0       0
