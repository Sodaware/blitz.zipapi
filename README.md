# Blitz.ZipApi - Quick Information

## About

Blitz.ZipApi brings zip functionality to BlitzPlus and Blitz3D. Now you
can extract files from zip files, as well as create and modify your own
zips. There is also support for compression and decompression of Blitz
banks.

The userlib binary is based on the work of the Zlib project, which can 
be found at http://www.zlib.net/


## Quick Links

Project Homepage:
: http://www.sodaware.net/dev/blitz/libs/blitz.zipapi/

Online Documentation
: http://docs.sodaware.net/blitz.zipapi/

Source Code
: https://github.com/Sodaware/blitz.zipapi


## Quick Installation

  * Copy "zlibwapi.dll" and "zlibwapi.decls" to the appropriate
    userlibs folder
	  
  * Include "Blitz_File_ZipApi.bb", "Blitz_File_FileName.bb" and 
    "Blitz_Basic_Bank.bb" into your projects.
	
  * To add documentation to the Blitz manual, copy the contents
    of "blitz-docs" to the "help/commands/2d_commands" of your 
    Blitz installation.


## Support

This library has been tested, but some bugs may still be present. You can report 
bugs at the sodaware bug tracker, and also add feature requests.

This software is provided 'as-is', without any express or implied warranty. In no 
event will the authors be held liable for any damages arising from the use of 
this software.


## Version History

### Version 1.2 - August 27th, 2007

  * Added ZipApi_ExtractFileAsBank. Files can be read from a zip straight 
    into a bank.

  * Added ZipApi_CompressBank and ZipApi_UnCompressBank. These are similar to 
    ZipApi_Compress and ZipApi_UnCompress, but they store the original data 
    size, which prevents guesswork and removes buffer errors.

  * Added ZipApi_VerifyZipFileHeader, which checks to see if a file has the 
    correct header for a zip file.

  * Added ZipApi_GetUnpackedSize, which calculates the total uncompressed size 
    of a zip archive.

  * Fixed bug where trying to extract a password protected file without a 
    password would throw no error.

  * Fixed bug where trying to extract a file that didn't exist wouldn't return 
    an error.

  * Fixed several extraction bugs, mostly involving incorrect slashes.


### Version 1.1 - April 23rd, 2007

Fixed several errors in the online documentation, and added the following 
improvements to the library:

  * ZipApi_AddBankAsFile and ZipApi_AddFile now support the "password" field 
    which allows files to be encrypted.

  * ZipApi_ExtractFile now supports optional password field for extracting 
    protected files.

  * Added a new example demonstrating how to use password protected zips. 

### Version 1.0 - September 8th, 2006

Initial release of library. Allows Blitz to open ZIP files and extract files from 
them. Also supports the creation of new ZIP files.
