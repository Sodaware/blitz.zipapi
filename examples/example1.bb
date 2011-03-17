; --------------------------------------------------
; --
; -- examples/example1.bb
; --
; -- A short example of how to iterate through a 
; -- ZIP file's contents using the ZipApi library.
; --
; --------------------------------------------------

; Include required libraries
Include "../Blitz_Basic_Bank.bb"
Include "../Blitz_File_FileName.bb"
Include "../../../Blitz_File_ZipApi.bb"

; Open the zip file
Local zipIn = ZipApi_Open("test-file.zip")

; Check the zip file was valid
If zipIn = 0 Then
	; Not a valid ZIP file - display error and exit program
	Print "There was an error whilst trying to open the zip file."
	End
EndIf

; Set file pointer to first file
ZipApi_GotoFirstFile(zipIn)

; Print a fancy header
Print LSet("FileName", 30) + RSet("Packed Size", 14) + RSet("Normal Size", 14) + RSet("Ratio", 10)

; Begin iterating through files
Repeat
	
	; Get the current file's information
	Local fileInfo.ZIPAPI_UnzFileInfo	= ZipApi_GetCurrentFileInfo(zipIn)
	
	; Generate fancy file data, containing file name, size and compression ratio
	Local fileData$	= ""
	Local compressionRatio# = Float((fileInfo\CompressedSize) / Float(fileInfo\UnCompressedSize)) * 100.0
	
	fileData$	= LSet(fileInfo\FileName, 30)
	fileData 	= fileData + RSet(fileInfo\CompressedSize, 14)
	fileData 	= fileData + RSet(fileInfo\UnCompressedSize, 14)
	fileData 	= fileData + RSet(compressionRatio + "%", 10)
	
	; Cleanup & output
	ZIPAPI_UnzFileInfo_Dispose(fileInfo)
	Print fileData
	
Until ZipApi_GotoNextFile(zipIn) = ZIPAPI_END_OF_LIST_OF_FILE

; Close & Cleanup
ZipApi_Close(zipIn)