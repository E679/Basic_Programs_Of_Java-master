# 🌐 Upload & Share Patch Files Online - Cross-OS Guide

## Complete Guide to Upload Patch Files and Download from Other OS

---

## 📋 Table of Contents

1. [Quick Methods (No Account Needed)](#quick-methods)
2. [Cloud Storage Services](#cloud-storage)
3. [GitHub Gist](#github-gist)
4. [Pastebin Services](#pastebin)
5. [File Transfer Services](#file-transfer)
6. [Command Line Tools](#command-line)
7. [Best Practices](#best-practices)

---

## ⚡ Quick Methods (No Account Needed) {#quick-methods}

### 1. **transfer.sh** (Easiest - Command Line)

```bash
# Upload patch file
curl --upload-file my_changes.patch https://transfer.sh/my_changes.patch

# Output: https://transfer.sh/abc123/my_changes.patch
# Copy this URL and use it on your other system

# Download on other system
curl https://transfer.sh/abc123/my_changes.patch -o my_changes.patch

# Or with wget
wget https://transfer.sh/abc123/my_changes.patch
```

**Features:**
- ✅ No account needed
- ✅ Files kept for 14 days
- ✅ Max 10GB per file
- ✅ Works on all OS (Mac, Linux, Windows with curl)

---

### 2. **file.io** (One-time Download)

```bash
# Upload
curl -F "file=@my_changes.patch" https://file.io

# Output: {"success":true,"key":"abc123","link":"https://file.io/abc123"}

# Download on other system (ONE TIME ONLY)
curl https://file.io/abc123 -o my_changes.patch
```

**Features:**
- ✅ No account needed
- ✅ Self-destructs after first download (secure)
- ✅ Max 100MB per file

---

### 3. **0x0.st** (Simple Upload)

```bash
# Upload
curl -F'file=@my_changes.patch' https://0x0.st

# Output: https://0x0.st/abc.patch

# Download
curl https://0x0.st/abc.patch -o my_changes.patch
```

---

## ☁️ Cloud Storage Services {#cloud-storage}

### 1. **Google Drive** (Recommended for Large Files)

#### **Upload via Web:**
1. Go to https://drive.google.com
2. Click **New → File upload**
3. Select your `.patch` file
4. Right-click on uploaded file → **Get link**
5. Set to **Anyone with the link**
6. Copy the link

#### **Download on Other System:**
```bash
# If link is: https://drive.google.com/file/d/FILE_ID/view?usp=sharing

# Method 1: Using gdown (install: pip install gdown)
gdown https://drive.google.com/uc?id=FILE_ID

# Method 2: Using wget
wget --no-check-certificate 'https://docs.google.com/uc?export=download&id=FILE_ID' -O my_changes.patch

# Method 3: Using curl
curl -L 'https://drive.google.com/uc?export=download&id=FILE_ID' -o my_changes.patch
```

#### **Upload via Command Line (gdrive):**
```bash
# Install gdrive: https://github.com/prasmussen/gdrive
# Mac: brew install gdrive
# Linux: Download from releases

# Upload
gdrive upload my_changes.patch

# Share
gdrive share <file-id>

# Get download link
gdrive info <file-id>
```

---

### 2. **Dropbox**

#### **Upload via Web:**
1. Go to https://www.dropbox.com
2. Upload file
3. Click **Share** → **Create link**
4. Copy link

#### **Download:**
```bash
# Change ?dl=0 to ?dl=1 in the URL
wget "https://www.dropbox.com/s/abc123/my_changes.patch?dl=1" -O my_changes.patch

# Or use curl
curl -L "https://www.dropbox.com/s/abc123/my_changes.patch?dl=1" -o my_changes.patch
```

---

### 3. **OneDrive**

#### **Upload via Web:**
1. Go to https://onedrive.live.com
2. Upload file
3. Right-click → **Share** → **Copy link**

#### **Download:**
```bash
# Replace 'redir' with 'download' in the URL
# Original: https://1drv.ms/u/s!abc123
# Download: https://1drv.ms/u/s!abc123?download=1

wget "https://1drv.ms/u/s!abc123?download=1" -O my_changes.patch
```

---

## 🐙 GitHub Gist {#github-gist}

### **Method 1: Via Web Interface**

1. Go to https://gist.github.com
2. Paste patch content or drag file
3. Set filename: `my_changes.patch`
4. Click **Create public gist** (or secret gist)
5. Copy the URL

**Download:**
```bash
# If gist URL is: https://gist.github.com/username/abc123

# Download raw file
wget https://gist.githubusercontent.com/username/abc123/raw/my_changes.patch

# Or clone the gist
git clone https://gist.github.com/abc123.git
```

### **Method 2: Via Command Line (gh CLI)**

```bash
# Install GitHub CLI
# Mac: brew install gh
# Linux: https://github.com/cli/cli#installation

# Login
gh auth login

# Create gist from file
gh gist create my_changes.patch --public

# Output: https://gist.github.com/abc123

# Download on other system
gh gist view abc123 --raw > my_changes.patch
```

### **Method 3: Via API**

```bash
# Create gist
curl -X POST https://api.github.com/gists \
  -H "Authorization: token YOUR_GITHUB_TOKEN" \
  -d '{
    "public": true,
    "files": {
      "my_changes.patch": {
        "content": "'"$(cat my_changes.patch)"'"
      }
    }
  }'

# Download
curl https://gist.githubusercontent.com/username/abc123/raw/my_changes.patch -o my_changes.patch
```

---

## 📝 Pastebin Services {#pastebin}

### 1. **Pastebin.com**

```bash
# Upload using API
curl -X POST https://pastebin.com/api/api_post.php \
  -d "api_dev_key=YOUR_API_KEY" \
  -d "api_option=paste" \
  -d "api_paste_code=$(cat my_changes.patch)"

# Download
wget https://pastebin.com/raw/abc123 -O my_changes.patch
```

### 2. **paste.ubuntu.com**

```bash
# Upload
curl -F 'content=<my_changes.patch' https://paste.ubuntu.com/

# Download
wget https://paste.ubuntu.com/p/abc123/plain/ -O my_changes.patch
```

### 3. **dpaste.com**

```bash
# Upload
curl -X POST https://dpaste.com/api/v2/ \
  -F "content=@my_changes.patch" \
  -F "syntax=diff"

# Download
wget https://dpaste.com/abc123.txt -O my_changes.patch
```

---

## 📤 File Transfer Services {#file-transfer}

### 1. **WeTransfer** (Up to 2GB Free)

**Web Interface:**
1. Go to https://wetransfer.com
2. Click **Add files**
3. Enter recipient email or get link
4. Click **Transfer**

**Features:**
- ✅ Up to 2GB free
- ✅ Files kept for 7 days
- ✅ No account needed

---

### 2. **Send Anywhere** (Cross-Platform)

**Web Interface:**
1. Go to https://send-anywhere.com
2. Upload file
3. Get 6-digit code or link
4. Share code/link

**Command Line:**
```bash
# Install: npm install -g send-cli

# Send
send my_changes.patch

# Receive (on other system)
send receive <6-digit-code>
```

---

### 3. **Firefox Send Alternative - send.vis.ee**

```bash
# Upload
curl -F "file=@my_changes.patch" https://send.vis.ee/upload

# Download
curl https://send.vis.ee/download/abc123 -o my_changes.patch
```

---

## 💻 Command Line Tools {#command-line}

### 1. **Using SCP (if you have SSH access to a server)**

```bash
# Upload to your server
scp my_changes.patch user@yourserver.com:/path/to/public/

# Download from other system
scp user@yourserver.com:/path/to/public/my_changes.patch .
```

---

### 2. **Using rsync**

```bash
# Upload
rsync -avz my_changes.patch user@yourserver.com:/path/to/public/

# Download
rsync -avz user@yourserver.com:/path/to/public/my_changes.patch .
```

---

### 3. **Using Python HTTP Server (Local Network)**

```bash
# On system with patch file (start server)
python3 -m http.server 8000

# Output: Serving HTTP on 0.0.0.0 port 8000

# Find your IP address
# Mac/Linux: ifconfig | grep "inet "
# Windows: ipconfig

# On other system (same network)
wget http://YOUR_IP:8000/my_changes.patch
# Or open in browser: http://YOUR_IP:8000
```

---

## 🚀 Automated Upload Script

Let me create a script for you:


