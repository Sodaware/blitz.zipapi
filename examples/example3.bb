; --------------------------------------------------
; --
; -- examples/example3.bb
; --
; -- Quick example of creating a new zip archive 
; -- and adding some files to it.
; --
; --------------------------------------------------

; Include required libraries
Include "../Blitz_Basic_Bank.bb"
Include "../Blitz_File_FileName.bb"
Include "../Blitz_File_ZipApi.bb"

; Open our new archive
Local zipOut	= ZipApi_CreateZip("my-test.zip")

; Add some test files
ZipApi_AddFile(zipOut, "example1.bb")
ZipApi_AddFile(zipOut, "example2.bb")
ZipApi_AddFile(zipOut, "example3.bb")

; Create a bank, and add that too!
Local testData$	= "I never existed as a file!"
Local bankToAdd	= CreateBank(Len(testData) + 1)
PokeString(bankToAdd, 0, testData)
ZipApi_AddBankAsFile(zipOut, bankToAdd, "test-file.txt")
FreeBank bankToAdd

; Close the zip
ZipApi_CloseZip(zipOut)

; We're all done, so let's check it out
Local zipIn		= ZipApi_Open("my-test.zip")

; Get some information
Local zipInfo.ZIPAPI_GlobalInfo = ZipApi_GetGlobalInfo(zipIn)

Print "my-test.zip contains " + zipInfo\NumberOfEntries + " entries"

; Cleanup
ZipApi_Close(zipIn)
Delete zipInfo