使用方法：

1. 下载 `NLPIR-ICTCLAS` 目录
```
命令行> svn checkout https://github.com/NLPIR-team/NLPIR/trunk/NLPIR%20SDK/NLPIR-ICTCLAS
```

2. 放置文件 (可直接运行脚本 `copy-nlpir.sh` )

```
命令行> cp -a NLPIR-ICTCLAS/Data .
命令行> src/main/resources/{darwin,linux-x86,linux-x86-64,win32-x86,win32-x86-64} 
命令行> cp -a NLPIR-ICTCLAS/lib/ios/libNLPIR.so src/main/resources/darwin/libNLPIR.dylib
命令行> cp -a NLPIR-ICTCLAS/lib/linux32/libNLPIR.so src/main/resources/linux-x86/libNLPIR.so
命令行> cp -a NLPIR-ICTCLAS/lib/linux64/libNLPIR.so src/main/resources/linux-x86-64/libNLPIR.so
命令行> cp -a NLPIR-ICTCLAS/lib/win32/NLPIR.dll src/main/resources/win32-x86/NLPIR.dll
命令行> cp -a NLPIR-ICTCLAS/lib/win64/NLPIR.dll src/main/resources/win32-x86-64/NLPIR.dll
```
