#!/bin/bash

if [ -z $1 ] ;then
  NLPIR_ICTCLAS="NLPIR-ICTCLAS"
else
  NLPIR_ICTCLAS="$1"
fi

if [ ! -d "${NLPIR_ICTCLAS}" ]; then
  echo "checking out NLPIR-ICTCLAS, please wait..."
  svn checkout https://github.com/NLPIR-team/NLPIR/trunk/NLPIR%20SDK/NLPIR-ICTCLAS/Data "${NLPIR_ICTCLAS}/Data"
  for platform in ios linux32 linux64 win32 win64; do
    svn checkout https://github.com/NLPIR-team/NLPIR/trunk/NLPIR%20SDK/NLPIR-ICTCLAS/lib/${platform} "${NLPIR_ICTCLAS}/lib/${platform}"
  done
fi

set -e

cp -av "${NLPIR_ICTCLAS}"/Data .
mkdir -p src/main/resources/{darwin,linux-x86,linux-x86-64,win32-x86,win32-x86-64} 
cp -av "${NLPIR_ICTCLAS}"/lib/ios/libNLPIR.so src/main/resources/darwin/libNLPIR.dylib
cp -av "${NLPIR_ICTCLAS}"/lib/linux32/libNLPIR.so src/main/resources/linux-x86/libNLPIR.so
cp -av "${NLPIR_ICTCLAS}"/lib/linux64/libNLPIR.so src/main/resources/linux-x86-64/libNLPIR.so
cp -av "${NLPIR_ICTCLAS}"/lib/win32/NLPIR.dll src/main/resources/win32-x86/NLPIR.dll
cp -av "${NLPIR_ICTCLAS}"/lib/win64/NLPIR.dll src/main/resources/win32-x86-64/NLPIR.dll
