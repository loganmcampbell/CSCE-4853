import functioncipyer
# START HERE : ENTER A THE KEYWORD TO CIPHER AND UPPERCASE IT
word = input("Enter keyword for encrpyt: ")
while (word == ""):
    word = input("Enter keyword for encrpyt: ")

print("w o r d : ", word)
word = word.upper()
original = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
original = " ".join(original)

# USE FUNCTION TRANSFORMED FUNCTION
talpha = functioncipyer.TRANSFORMEDALPHABET(word)
# PRINT OUT THE ALPHABET'S, YEAH?
print("\n")
print("TRANSFORMED:\t", talpha)
print("ORIGINAL:\t", original)
# SET UP A CONDITIONAL FOR INPUT, READ FILE , AND NOTHING
choice = input("Read From File [1] or Read From Input [2]: ")
# Read FROM FILE TIME ||
if (choice == "1"):
    filename = input("Enter the filename: ")
    fileobject = open(filename, "r")
    filelist = ""
    for line in fileobject:
        if (line == "\n" or line == '\n' or line[:-1] == "\n"):
            filelist = filelist + "\n"
        line = line.upper()
        filelist = filelist + line

# INPUT MESSAGE TIME ||
if (choice == "2"):
    message = input("Enter message to encrpyt : ")
    while (message == ""):
        message = input("Enter message to encrpyt : ")
# INPUT FILE READ TO message
if (choice == "1"):
    message = filelist
message = message.upper()
print("\nm e s s a g e : ", message)

# CREATE LIST AND ADD THE INDEX #'s LETTERS OF THE WORD FROM THE ALPHABET
numberList = []
for i, c in enumerate(message):
    for j, d in enumerate(original):
        if (c == d):
            numberList.append(j)
            if (c == " "):
                numberList.append(c)
        if (c == "\n" or c == '\n' or c[:-1] == "\n"):
            numberList.append("\n")
        else:
                pass

# COMPARE NUMBER INDICES TO THE LIST FROM ALPHABET TO TRANSFORMED ALPHABET
# SET THE CHARACTER FROM THE TRANSFORMED ALPHABET TO A STRING
code = ""
for x in numberList:
    for i, c in enumerate(talpha):
        if(i == x):
            code = code + c
        if (x == "\n" or x == '\n'):
            code = code + "\n"

# LOOK FOR MORE THAN 1 SPACES BECAUSE ENUMERATE LOOKS THROUGH EVERYTHING
# REMOVE THEM...
prev = ' '
for letter in code:
    if letter == prev:
        code = code.replace("  ", "")
        code = code.replace("\n", " ")
        code = code.strip()

# PRINT THE FINAL PRODUCT OF CIPHERTEXT
print("\nc i p h e r - t e x t : ", code)

if (choice != "1"):
    filename = "inputcipher.txt"

if (choice == "1"):
    newFilename = filename.replace(".txt", "")
    print(newFilename)

writer = open(newFilename + "[ciphered].txt", "w+")
writer.write("FROM THE TEXT FILE : " + filename)
writer.write("\n KEYWORD : " + word)
writer.write("\n ALPHABET :\t" + original)
writer.write("\n TRANSFORMED :\t" + talpha)
writer.write("\n TEXT : \n" + message)
writer.write("\n CIPHERTEXT : " + code)

writer.close()
