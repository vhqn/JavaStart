# Linux vs PowerShell 命令对照表

> 适用场景：Trae IDE 终端（Windows PowerShell）

---

## 文件与目录操作

| 操作 | Linux | PowerShell |
|------|-------|------------|
| 列出文件 | `ls -la` | `ls` 或 `Get-ChildItem` |
| 列出文件（含详细信息） | `ls -l` | `ls` 本身就显示详细信息 |
| 按时间排序 | `ls -lt` | `ls \| sort LastWriteTime -Desc` |
| 人类可读大小 | `ls -lh` | `ls \| select Name, @{N="Size";E={"{0:N2} KB" -f ($_.Length/1KB)}}` |
| 递归列出 | `ls -R` | `ls -Recurse` 或 `ls -r` |
| 切换目录 | `cd /path` | `cd C:\path` |
| 当前目录 | `pwd` | `pwd` 或 `Get-Location` |
| 创建目录 | `mkdir dir` | `mkdir dir` |
| 创建文件 | `touch file.txt` | `New-Item file.txt` |
| 复制文件 | `cp a b` | `cp a b` 或 `Copy-Item a b` |
| 移动/重命名 | `mv a b` | `mv a b` 或 `Move-Item a b` |
| 删除文件 | `rm file` | `rm file` 或 `Remove-Item file` |
| 删除目录 | `rm -rf dir` | `rm -Recurse -Force dir` |
| 创建符号链接 | `ln -s target link` | `New-Item -ItemType SymbolicLink -Path link -Target target` |

---

## 查看文件内容

| 操作 | Linux | PowerShell |
|------|-------|------------|
| 查看全部 | `cat file` | `cat file` 或 `Get-Content file` |
| 查看前 N 行 | `head -n 10 file` | `cat file -Head 10` |
| 查看后 N 行 | `tail -n 10 file` | `cat file -Tail 10` |
| 实时追踪 | `tail -f file` | `cat file -Wait` |
| 分页查看 | `less file` | `more file` |

---

## 文本搜索与处理

| 操作 | Linux | PowerShell |
|------|-------|------------|
| 搜索文本 | `grep "pattern" file` | `Select-String "pattern" file` 或 `sls "pattern" file` |
| 递归搜索 | `grep -r "pattern" .` | `sls "pattern" (ls -r)` |
| 统计行数 | `wc -l file` | `(cat file).Count` |
| 比较文件 | `diff a b` | `Compare-Object (cat a) (cat b)` 或 `fc a b`（cmd 命令） |

---

## 进程与系统

| 操作 | Linux | PowerShell |
|------|-------|------------|
| 查看进程 | `ps aux` | `ps` 或 `Get-Process` |
| 结束进程 | `kill PID` | `kill PID` 或 `Stop-Process -Id PID` |
| 磁盘空间 | `df -h` | `Get-PSDrive` |
| 目录大小 | `du -sh dir` | `(ls dir -r \| measure Length -s).Sum / 1MB` |
| 环境变量 | `echo $VAR` | `$env:VAR` 或 `echo $env:VAR` |
| 设置环境变量 | `export VAR=val` | `$env:VAR = "val"` |
| 系统信息 | `uname -a` | `$PSVersionTable` 或 `systeminfo` |

---

## 网络

| 操作 | Linux | PowerShell |
|------|-------|------------|
| 下载文件 | `wget url` | `Invoke-WebRequest url -OutFile file` |
| 测试连通 | `ping host` | `ping host` 或 `Test-Connection host` |
| 查看端口 | `netstat -tlnp` | `netstat -ano` |

---

## 其他常用

| 操作 | Linux | PowerShell |
|------|-------|------------|
| 清屏 | `clear` | `clear` 或 `cls` |
| 命令历史 | `history` | `history` 或 `h` |
| 帮助 | `man cmd` | `help cmd` 或 `Get-Help cmd` |
| 查找命令位置 | `which cmd` | `Get-Command cmd` |
| 管道 | `\|` | `\|`（传递对象而非文本） |
| 重定向 | `>` | `>` 或 `\| Out-File` |
| 命令串联 | `cmd1 && cmd2` | `cmd1; cmd2` |
| 脚本执行 | `./script.sh` | `.\script.ps1` |
| 管理员权限 | `sudo cmd` | 以管理员身份运行终端 |

---

## 核心差异

| | Linux | PowerShell |
|------|-------|------------|
| 管道传递 | 纯文本 | .NET 对象 |
| 命令风格 | `-短选项` / `--长选项` | `-参数名 值` |
| 路径分隔符 | `/` | `\` 或 `/` |
| 大小写 | 严格区分 | 不区分 |
| 脚本扩展名 | `.sh` | `.ps1` |

---

## 常用速记

```powershell
ls -r              # 递归列出（-Recurse 的简写）
ls -fi "*.java"    # 按文件名过滤（-Filter 的简写）
cat file -Head 20  # 看前 20 行
sls "error" *.log  # 搜索文本（Select-String 的简写）
```
