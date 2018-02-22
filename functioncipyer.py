def TRANSFORMEDALPHABET(word):

    # SET ALPHABET BECAUSE YOLO SWAG
    alphabet = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z"

    # GET THE FIRST KEYWORD ONLY, BECAUSE THEY'RE PARANOID ANYWAY...
    realWord = word
    word = word.split()[0]
    # print("K E Y W O R D : ", word)

    # CYCLE THROUGH THE LETTERS FROM THE WORD
    # MOVE LETTERS AND SET THE TRANSFORMED ALPHABET
    word2 = ""
    for i, c in enumerate(realWord):
        for j, d in enumerate(alphabet):
            if (c == d and c != " "):
                # print(c, d)
                alphabet = alphabet.replace(d, "")
                # print("complete")
                word2 = word2 + d

    # SHOWCASE YOUR THE DERIVED KEYWORD AND DERIVED ALPHABET
    # print(alphabet)
    # print(word2)
    # ATTACH KEYWORD TO ALPHABET AND SHOWCASE ALPHABET(S)
    talpha = word2 + alphabet
    for characters in enumerate(talpha):
        talpha = talpha.replace(" ", "")
    talpha = " ".join(talpha)

    return (talpha)
