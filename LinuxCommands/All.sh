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
sudo apt install nfs-common
sudo mkdir /var/backups
sudo mount -t nfs 10.10.0.10:/backups /var/backups
sudo nano /etc/fstab
sudo mkdir /var/backups
sudo mkdir /mnt/win_share
sudo nano /etc/fstab

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
