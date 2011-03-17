; --------------------------------------------------
; --
; -- examples/example2.bb
; --
; -- How to open a zip file an extract a file from
; -- it.
; --
; --------------------------------------------------

; Include required libraries
Include "../Blitz_Basic_Bank.bb"
Include "../Blitz_File_FileName.bb"
Include "../Blitz_File_ZipApi.bb"

; Open the zip file for reading
Local zipIn = ZipApi_Open("example.zip")

; Check the zip file was valid
If zipIn = 0 Then
	; Not a valid ZIP file - display error and exit program
	Print "There was an error whilst trying to open the zip file."
	End
EndIf

; Extract our file
Local fileName$		= ZipApi_ExtractFile(zipIn, "example.txt")

; Print some file information
Print "File was extracted to '" + fileName + "'"
Print "Extracted size : " + FileSize(fileName) + " bytes"

; Close & cleanup
ZipApi_Close(zipIn)
DeleteFile(fileName)