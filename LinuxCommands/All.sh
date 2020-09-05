D:
----------

F:
----------

fuser -m MOUNT_POINT

df -h

M:
---------
mount /var/backups
mount 10.10.0.10:/backups


S:
----------
sudo apt update
sudo apt update
sudo apt install cifs-utils
sudo dnf install cifs-utils
sudo apt install nfs-common
sudo mkdir /var/backups
sudo mount -t nfs 10.10.0.10:/backups /var/backups
sudo nano /etc/fstab
sudo mkdir /var/backups
sudo mkdir /mnt/win_share
sudo nano /etc/fstab
sudo mount -t cifs -o username=<win_share_user> //WIN_SHARE_IP/<share_name> /mnt/win_share
sudo mount -t cifs -o username=<win_share_user>,password=<win_share_password> //WIN_SHARE_IP/<share_name> /mnt/win_share
sudo mount -t cifs -o username=<win_share_user>,domain=<win_domain> //WIN_SHARE_IP/<share_name> /mnt/win_share
sudo chown root: /etc/win-credentials
sudo chmod 600 /etc/win-credentials
sudo mount -t cifs -o credentials=/etc/win-credentials //WIN_SHARE_IP/<share_name> /mnt/win_share
sudo umount /mnt/win_share

U
----
umount 10.10.0.10:/backups 
umount /var/backups
umount -l MOUNT_POINT
umount -f MOUNT_POINT



Others:
=====================

1) in  /etc/fstab  for network Share
10.10.0.10:/backups /var/backups  nfs      defaults    0       0
