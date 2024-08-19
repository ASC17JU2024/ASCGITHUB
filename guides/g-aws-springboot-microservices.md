## Deploying a Spring Boot Application on AWS

:beginner: _**Eureka on Redhat Linux**_  

<!-- Property for eureka server client -->


### Step 1: Create a Spring Boot Application
- Generate the JAR file.
```sh
mvn clean package
```

### Step 2: Launch an EC2 Instance
- Create an EC2 instance with the following configurations:
  - AMI: Amazon Linux 
  - Instance Type: t2.micro
  - Security Group: Allow HTTP and SSH
  - Key Pair: Create a new key pair and download it
  - Launch the instance
  - security group: add inbound rules for HTTP and SSH
  - custom type TCP, port 8081, source anywhere
  - actions connect and copy the ssh command
  - ssh -i "ld3a-ec2-product-microservice-redhat-linux-server.pem" ec2-user@ec2-52-90-222-78.compute-1.amazonaws.com
- pwd: /home/ec2-user
- install Java 17
```sh
sudo yum install java-17
```

### Step 3: Deploy the JAR File into EC2 Using CLI

- Copy the JAR file to the EC2 instance.
```sh
scp -i "ld3a-ec2-product-microservice-redhat-linux-server.pem" ld2a-aws-eureka-server-0.0.1-SNAPSHOT.jar ec2-user@ec2-52-90-222-78.compute-1.amazonaws.com:/home/ec2-user
```
```sh
ls
# to check the jar file in EC2 instance
```
- Run the JAR file.

```sh
java -jar ld2a-aws-eureka-server-0.0.1-SNAPSHOT.jar
```
- Test from web browser
http://ec2-52-90-222-78.compute-1.amazonaws.com:8761/

:beginner: _**Creating and deploying the product microservie on Amazon Linux**_  
- Generate the JAR file.
```sh
mvn clean package
```
```sh
ssh -i "ld3a-ec2-product-microservice-key-pair.pem" ec2-user@ec2-98-81-96-172.compute-1.amazonaws.com
```
- Copy the JAR file to the EC2 instance.
```sh
scp -i "ld3a-ec2-product-microservice-key-pair.pem" product-microservice-0.0.1-SNAPSHOT.jar ec2-user@ec2-98-81-96-172.compute-1.amazonaws.com:/home/ec2-user
```
```sh
java -jar product-microservice-0.0.1-SNAPSHOT.jar --server.port=8081
```

:beginner: _**Creating and deploying product microservice on Windows Server**_  

:writing_hand: **_Using RDP_**  


To connect to a Windows instance using Remote Desktop Protocol (RDP), follow these steps:

### Step 1: Retrieve the Instance's Public IP or DNS
1. **Login to AWS Management Console:**
   - Go to the AWS Management Console.
   - Navigate to the **EC2** service.

2. **Locate Your Instance:**
   - In the EC2 dashboard, find the instance you want to connect to.
   - Note down the **Public IPv4 address** or **Public DNS** from the instance details.

### Step 2: Retrieve the Windows Administrator Password
1. **Select the Instance:**
   - In the EC2 dashboard, select your Windows instance.

2. **Get the Password:**
   - Click on the **Actions** dropdown.
   - Choose **Security** > **Get Windows Password**.
   - You’ll need to decrypt the password using your PEM key pair:
     - **Browse** to the key pair `.pem` file you used when launching the instance.
     - Click **Decrypt Password**.
   - The decrypted **Administrator** password will be displayed.

### Step 3: Connect Using Remote Desktop
1. **Open Remote Desktop Connection:**
   - On your local machine, search for and open **Remote Desktop Connection**.

2. **Enter the IP Address or DNS:**
   - In the Remote Desktop Connection window, enter the **Public IP** or **Public DNS** of your instance.
   - Click **Connect**.

3. **Enter Credentials:**
   - When prompted, enter **Administrator** as the username.
   - Enter the decrypted password retrieved earlier.
   - You may receive a certificate warning; you can proceed by accepting it.

4. **Connect:**
   - Click **OK** to connect to your Windows instance.

Now, you should be connected to your Windows instance via RDP. Let me know if you need any further assistance!  

-------------------------------

:loudspeaker: *#eureka.client.service-url.defaultZone=http://ec2-52-90-222-78.compute-1.amazonaws.com:8761/eureka/*  

ssh -i "ld3a-ec2-product-microservice-key-pair.pem" ec2-user@ec2-98-81-96-172.compute-1.amazonaws.com