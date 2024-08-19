:books: NFS with AWS and SpringBoot Microservice  


:beginner: **Creating and deploying the product microservie on Amazon Linux**_    

- Generate the JAR file.
```sh
mvn clean package
```

:beginner: **Deploy the JAR File into EC2 Using CLI**

- Launch an EC2 Instance
- Create an EC2 instance with the following configurations:
  - AMI: Amazon Linux 
  - Instance Type: t2.micro
  - Security Group: Allow HTTP and SSH
  - Key Pair: Create a new key pair and download it
  - Launch the instance
  - Security Group: Add inbound rules for HTTP and SSH
  - Custom Type TCP, Port 8081, Source Anywhere
  - Actions: Connect and copy the SSH command
  - SSH into the instance:





```sh
ssh -i "ld3a-ec2-product-microservice-key-pair.pem" ec2-user@ec2-34-236-150-200.compute-1.amazonaws.com

```
- Copy the JAR file to the EC2 instance.
```sh
scp -i "ld3a-ec2-product-microservice-key-pair.pem" product-microservice-0.0.1-SNAPSHOT.jar ec2-34-236-150-200.compute-1.amazonaws.com:/home/ec2-user
```


  - Change directory to the home directory:
  ```sh
  cd /home/ec2-user
  ```

  - Verify the JAR file in the EC2 instance:
```sh
ls
```
  - Install Java 17:
  ```sh
  sudo yum install java-17
  ```

- Run  the springboot Application on the EC2 instance.
```sh
java -jar product-microservice-0.0.1-SNAPSHOT.jar --server.port=8081
```

:beginner: _**Set Up NFS on EC2 Instance**_  

 
- Install NFS utilities:
```sh
sudo yum install nfs-utils
```
- Create a directory to share:
```sh
sudo mkdir -p /var/nfs/general
```
- Change ownership of the directory:
```sh
sudo chown nobody:nobody /var/nfs/general
```
- Edit the `/etc/exports` file to add the following line:
```sh
sudo vi /etc/exports
# press i to insert the following line
/var/nfs/general *(rw,sync,no_subtree_check)
# press esc and type :wq to save and exit
```
```sh
/var/nfs/general *(rw,sync,no_subtree_check)
```
- Export the shared directory:
```sh
sudo exportfs -arv
# This will apply the changes you made to the /etc/exports file.
```
- Start the NFS server:
```sh
sudo systemctl start nfs-server
# Check the status of the NFS server
sudo systemctl status nfs-server
```
- Enable the NFS server to start on boot:
```sh
sudo systemctl enable nfs-server
```

:beginner: _** Connect to NFS from Windows 11 Client Machine Using VS Code**_  

:beginner: _**Set Up NFS on Windows Server**_
- Open PowerShell as Administrator and install NFS client:
```powershell

# Enable-WindowsOptionalFeature -Online -FeatureName NFS-Client

# Enable-WindowsOptionalFeature -Online -FeatureName "ServicesForNFS-ClientOnly"

# Get-WindowsOptionalFeature -Online | Where-Object { $_.FeatureName -like "*NFS*" }

# Enable NFS Administration
Enable-WindowsOptionalFeature -Online -FeatureName NFS-Administration -All

# Enable Services for NFS (Server and Client)
Enable-WindowsOptionalFeature -Online -FeatureName ServicesForNFS-ServerAndClient -All

# Enable Client for NFS Infrastructure
Enable-WindowsOptionalFeature -Online -FeatureName ClientForNFS-Infrastructure -All

# Enable Server for NFS Infrastructure
Enable-WindowsOptionalFeature -Online -FeatureName ServerForNFS-Infrastructure -All
```
`
- Create a directory to mount the NFS share:
```powershell
New-Item -Path "C:\nfs" -ItemType Directory
```
- Mount the NFS share:
```powershell
ping ec2-34-236-150-200.compute-1.amazonaws.com

New-PSDrive -Name "N" -PSProvider FileSystem -Root "\\ec2-34-236-150-200.compute-1.amazonaws.com\var\nfs\general" -Persist
```

<!-- Ensure that the security group associated with your EC2 instance allows inbound ICMP traffic (which is used for ping).

Type: All ICMP - IPv4
Protocol: ICMP
Port Range: N/A
Source: 0.0.0.0/0 (or your specific IP range)
 -->
- Open VS Code and navigate to the mounted directory:
  - Open VS Code.
  -  `Open Folder`.
  - Select `C:\nfs`.

Now you can edit files directly on the NFS share using VS Code on your Windows 11 client machine.

------------------------- 
-------------------------

Given that you have a Windows Server and an Amazon Linux instance running in the same VPC, and you want to mount an NFS share from the Amazon Linux instance to the Windows Server, ensure the following steps are followed:

### Steps to Mount NFS Share on Windows Server

1. **Ensure NFS Server is Running on Amazon Linux**:
   - Make sure the NFS server is installed and running on your Amazon Linux instance.
   - Export the desired directory via NFS.

2. **Open Necessary Ports in Security Groups**:
   - Ensure the security group associated with your Amazon Linux instance allows inbound traffic on the necessary NFS ports.

3. **Mount the NFS Share on Windows Server**:
   - Use the `New-PSDrive` command in PowerShell to mount the NFS share.

### Detailed Steps

#### 1. Ensure NFS Server is Running on Amazon Linux

1. **Install NFS Utilities**:
   ```sh
   sudo yum install -y nfs-utils
   ```

2. **Configure NFS Exports**:
   - Edit the `/etc/exports` file to include the directory you want to share:
     ```sh
     sudo nano /etc/exports
     ```
   - Add the following line (replace `/var/nfs/general` with your directory):
     ```plaintext
     /var/nfs/general *(rw,sync,no_root_squash,no_subtree_check)
     ```

3. **Start NFS Services**:
   ```sh
   sudo systemctl start nfs
   sudo systemctl enable nfs
   ```

4. **Export the Shared Directory**:
   ```sh
   sudo exportfs -a
   ```

#### 2. Open Necessary Ports in Security Groups

1. **Navigate to Security Groups**:
   - In the AWS Management Console, go to `EC2` > `Security Groups`.

2. **Edit Inbound Rules**:
   - Select the security group associated with your Amazon Linux instance.
   - Click on `Edit inbound rules`.
   - Add rules for the necessary ports:
     ```plaintext
     Type: Custom TCP Rule
     Protocol: TCP
     Port Range: 111
     Source: 0.0.0.0/0 (or your specific IP range)

     Type: Custom TCP Rule
     Protocol: TCP
     Port Range: 2049
     Source: 0.0.0.0/0 (or your specific IP range)

     Type: Custom TCP Rule
     Protocol: TCP
     Port Range: 20048
     Source: 0.0.0.0/0 (or your specific IP range)

     Type: Custom TCP Rule
     Protocol: TCP
     Port Range: 875
     Source: 0.0.0.0/0 (or your specific IP range)

     Type: Custom TCP Rule
     Protocol: TCP
     Port Range: 662
     Source: 0.0.0.0/0 (or your specific IP range)

     Type: Custom TCP Rule
     Protocol: TCP
     Port Range: 32769
     Source: 0.0.0.0/0 (or your specific IP range)
     ```

3. **Save the Rules**:
   - Click on `Save rules`.

#### 3. Mount the NFS Share on Windows Server

1. **Open PowerShell**:
   - Open PowerShell on your Windows Server.

2. **Mount the NFS Share**:
   - Use the `New-PSDrive` command to mount the NFS share:
     ```powershell
     New-PSDrive -Name "N" -PSProvider FileSystem -Root "\\ec2-34-236-150-200.compute-1.amazonaws.com\var\nfs\general" -Persist
     ```

By following these steps, you can successfully mount an NFS share from an Amazon Linux instance to a Windows Server running in the same VPC.

# Add some files on the NFS share from the Windows Server and verify that they are accessible from the Amazon Linux instance.

```sh
# change ownership of the NFS share directory
sudo chown -R ec2-user:ec2-user /var/nfs/general
# change pemissions of the NFS share directory
sudo chmod -R 777 /var/nfs/general
# what is -R option in chmod command?
# -R, --recursive which means change files and directories recursively
ls /var/nfs/general
# command to touch aws.txt file and add it to the NFS share
touch /var/nfs/general/aws.txt
# command to cat the aws.txt file from the NFS share to add "Welcome to AWS" text
echo "Welcome to AWS" > /var/nfs/general/aws.txt
```

