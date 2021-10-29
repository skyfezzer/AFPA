D:
cd D:\TP_CMD\

IF NOT EXIST repertoire1\r5\ mkdir repertoire1\r5
IF NOT EXIST r2 mkdir r2
IF NOT EXIST r3 mkdir r3
IF NOT EXIST r4\r6 mkdir r4\r6
IF NOT EXIST r4\r7 mkdir r4\r7
IF NOT EXIST r4\r8 mkdir r4\r8
IF NOT EXIST repertoire1\fichier1 copy NUL repertoire1\fichier1
IF NOT EXIST repertoire1\f2 copy NUL repertoire1\f2
IF NOT EXIST r4\r8\f1 copy NUL r4\r8\f1
echo Arborescence créée.