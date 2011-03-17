; --------------------------------------------------
; --
; -- examples/example4.bb
; --
; -- Demonstrates compressing data stored in a 
; -- Blitz bank, and then decompressing it.
; --
; --------------------------------------------------

; Include required libraries
Include "../Blitz_Basic_Bank.bb"
Include "../Blitz_File_FileName.bb"
Include "../Blitz_File_ZipApi.bb"

Const TEST_STRING$	= "Repetition is good for compression. Repetition is good for compression."

; Create a bank to be compressed
Local testBank	= CreateBank(Len(TEST_STRING) + 1)

; Store our test string
PokeString(testBank, 0, TEST_STRING)

; Compress the data
Local compressedBank = ZipApi_Compress(testBank)

; Output statistics
Print "Old Size: " + BankSize(testBank)
Print "New Size: " + BankSize(compressedBank)

Local ratio# =  (Float(BankSize(compressedBank))) / (Float(BankSize(testBank)))
Print "Compression Ratio: " + (ratio * 100.0) + "%" 

; Decompress the bank & output contents
Local unCompressedBank = ZipApi_UnCompress(compressedBank)
Print "Unpacked Data: " + PeekString(unCompressedBank, 0)

; Cleanup
FreeBank testBank
FreeBank compressedBank
FreeBank unCompressedBank