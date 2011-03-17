; --------------------------------------------------
; --
; -- examples/example5.bb
; --
; -- Using passwords in ZIP files
; --
; --------------------------------------------------

; Include required libraries
Include "../Blitz_Basic_Bank.bb"
Include "../Blitz_File_FileName.bb"
Include "../Blitz_File_ZipApi.bb"

; Open our new archive
Local zipOut	= ZipApi_CreateZip("my-protected-test.zip")

; Add some test files with passwords
;  - The "true" param is the default value for this function, and
;    tells the zip api to include path information.
;  - Note how we can have different passwords for different files
ZipApi_AddFile(zipOut, "example1.bb", True, "password")
ZipApi_AddFile(zipOut, "example2.bb", True, "password")
ZipApi_AddFile(zipOut, "example3.bb", True, "password2")

; Create a bank, and add that too!
Local testData$	= "I never existed as a file!"
Local bankToAdd	= CreateBank(Len(testData) + 1)
PokeString(bankToAdd, 0, testData)
ZipApi_AddBankAsFile(zipOut, bankToAdd, "test-file.txt", "password3")
FreeBank bankToAdd

; Close the zip
ZipApi_CloseZip(zipOut)

; We're all done, so let's check it out
Local zipIn		= ZipApi_Open("my-protected-test.zip")

; Get some information
Local zipInfo.ZIPAPI_GlobalInfo = ZipApi_GetGlobalInfo(zipIn)
Print "my-test.zip contains " + zipInfo\NumberOfEntries + " entries"

Local fileName$	= ""

; Extract file 1 with its password
fileName$		= ZipApi_ExtractFile(zipIn, "example1.bb", "", "password")
If fileName = "" Then Print "Error" Else Print "Extracted '" + fileName$ + "'"

; Extract file 2 with an incorrect password
fileName$		= ZipApi_ExtractFile(zipIn, "example2.bb", "", "password-is-wrong")
If fileName = "" Then Print "Error" Else Print "Extracted '" + fileName$ + "'"

; Finally, we'll extract the bank
fileName$		= ZipApi_ExtractFile(zipIn, "test-file.txt", "", "password3")
If fileName = "" Then Print "Error" Else Print "Extracted '" + fileName$ + "'"

; Cleanup
ZipApi_Close(zipIn)
Delete zipInfo