;===============================================================================
; Name : bassrecord.bb 
; Include this for record help functions !
;===============================================================================

Function BASS_RecordGetDeviceCount%()
   Local I =0
   While True
      If BASS_RecordGetInputName (I) Then
         I = I + 1
      Else
         Return I 
      EndIf
   Wend
End Function

Function BASS_RecordGetDeviceDescriptionString$(device%)
   Local Pointer,BnkDescription,Description$,I,Char
   Pointer = BASS_RecordGetDeviceDescription(device)
   If Not Pointer Then
      Return ""
   Else
      BnkDescription = CreateBank(256)
      BASS_RtlMoveMemory1(BnkDescription,Pointer,256)
      For I = 0 To 255
         Char = PeekByte(BnkDescription,I)
         If Char = 0 Then Exit
         Description$ = Description$ + Chr$(Char)
      Next
   EndIf
   FreeBank BnkDescription : Return Description$
End Function 


Function BASS_RecordGetInputNameString$(device%)
   Local Pointer,BnkDescription,Description$,I,Char
   Pointer = BASS_RecordGetInputName(device)
   If Not Pointer Then
      Return ""
   Else
      BnkDescription = CreateBank(256)
      BASS_RtlMoveMemory1(BnkDescription,Pointer,256)
      For I = 0 To 255
         Char = PeekByte(BnkDescription,I)
         If Char = 0 Then Exit
         Description$ = Description$ + Chr$(Char)
      Next
   EndIf
FreeBank BnkDescription : Return Description$
End Function

Function BASS_RecordGetInputVolume% (inp%) 
		Local temp = BASS_RecordGetInput (inp)
		Local vol = BASS_MakeLoWord (temp)
	If vol = $0000FFFF Return -1
Return vol
End Function

Function BASS_RecordGetInputFlag% (inp%)
	Local flag1 = BASS_RecordGetInput (inp) 
			Local flag2 =flag1 Shr 20
				flag1 = flag2 Shl 20
	If flag1 = $FFF00000 Return -1
Return  flag1
End Function

Function BASS_RecordGetFlagName$ (flag%)
Local temp$ = ""
	Select flag
			Case $10000 temp = "BASS_INPUT_OFF" 
			Case $20000 temp = "BASS_INPUT_ON"
			Case $40000 temp = "BASS_INPUT_LEVEL"
			Case $00000000 temp = "BASS_INPUT_TYPE_UNDEF"
			Case $01000000 temp = "BASS_INPUT_TYPE_DIGITAL"
			Case $02000000 temp = "BASS_INPUT_TYPE_LINE"
			Case $03000000 temp = "BASS_INPUT_TYPE_MIC"
			Case $04000000 temp = "BASS_INPUT_TYPE_SYNTH"
			Case $05000000 temp = "BASS_INPUT_TYPE_CD"
			Case $06000000 temp = "BASS_INPUT_TYPE_PHONE"
			Case $07000000 temp = "BASS_INPUT_TYPE_SPEAKER"
			Case $08000000 temp = "BASS_INPUT_TYPE_WAVE"
			Case $09000000 temp = "BASS_INPUT_TYPE_AUX"
			Case $0a000000 temp = "BASS_INPUT_TYPE_ANALOG"
		Default flag = "Not a valid flag"
	End Select
Return temp
End Function

Function BASS_RecordGetInputOn%(inp%)
Local on = BASS_RecordGetInput (inp) 
Local on2 = BASS_MakeHiWord (on)
	on = on2 Shl 28
		If on > 0 Return 0
		If on = 0 Return 1
End Function

Function BASS_RecordStartSimple%(freq%,chans%,flags%)
	Local temp%
		temp = BASS_RecordStartInt%(freq,chans,flags,0,0)
	Return temp
End Function

Function BASS_RecordSetInputVolume%(inp%,vol%)
Local temp2 = BASS_MakeLong(vol,$4)
Local temp = BASS_RecordSetInput(inp,temp2)
Return temp
End Function

;~IDEal Editor Parameters:
;~C#Blitz3D