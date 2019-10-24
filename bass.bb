;===============================================================================
; Name : bass.bb 
; Bass for Blitzbasic.
; Remember ! Bass is not freeware ! See http://www.un4seen/ for more informations
; Blitzbasic version by Abrexxes 2007 -2009 (Previous versions by Rob Hutchinson & Oliver Skawronek aka Vertex)
;===============================================================================
; To record with bass also include the bassrecord.bb!
;===============================================================================

Const BASSVERSION = 33751043 ; (Hex: 02030003)
Const BASS_TRUE = 1 ; Use this for "TRUE"
Const BASS_FALSE = 0 ; Use this for "FALSE"
Const BASS_NULL = 0 ; Use this For "NULL"

Const BASS_Max_Supported_File_Size =  1073741824 ; = 1 Gigabyte
; max = 2147483647 bytes aka 2,1 Gigabyte [QWORD Protection]
Const BASS_Min_Supported_File_Size = 4 ;bytes ,we will never have problems. ;)

;===== Const ======================================================================

; Initialization flags
Const BASS_DEVICE_8BITS  = 1 
Const BASS_DEVICE_MONO = 2 
Const BASS_DEVICE_3D = 4 
Const BASS_DEVICE_LATENCY = 256 
Const BASS_DEVICE_SPEAKERS = 2048 
Const BASS_DEVICE_NOSPEAKER = 4096 

; DirectSound interfaces 
Const BASS_OBJECT_DS = 1	
Const BASS_OBJECT_DS3DL = 2

; BASS_INFO flags (dsound.h)
Const DSCAPS_CONTINUOUSRATE = $00000010
Const DSCAPS_EMULDRIVER = $00000020
Const DSCAPS_CERTIFIED = $00000040
Const DSCAPS_SECONDARYMONO = $00000100
Const DSCAPS_SECONDARYSTEREO = $00000200
Const DSCAPS_SECONDARY8BIT = $00000400
Const DSCAPS_SECONDARY16BIT = $00000800

; BASS_RECORDINFO flags (dsound.h)
Const DSCCAPS_EMULDRIVER = DSCAPS_EMULDRIVER
Const DSCCAPS_CERTIFIED = DSCAPS_CERTIFIED

; BASS_RECORDINFO (mmsystem.h)
Const WAVE_FORMAT_1M08 = $00000001
Const WAVE_FORMAT_1S08 = $00000002
Const WAVE_FORMAT_1M16 = $00000004
Const WAVE_FORMAT_1S16 = $00000008
Const WAVE_FORMAT_2M08 = $00000010
Const WAVE_FORMAT_2S08 = $00000020
Const WAVE_FORMAT_2M16 = $00000040
Const WAVE_FORMAT_2S16 = $00000080
Const WAVE_FORMAT_4M08 = $00000100
Const WAVE_FORMAT_4S08 = $00000200
Const WAVE_FORMAT_4M16 = $00000400
Const WAVE_FORMAT_4S16 = $00000800

; Music attributes
Const BASS_MUSIC_ATTRIB_AMPLIFY = 0
Const BASS_MUSIC_ATTRIB_PANSEP = 1 
Const BASS_MUSIC_ATTRIB_PSCALER = 2
Const BASS_MUSIC_ATTRIB_BPM = 3
Const BASS_MUSIC_ATTRIB_SPEED = 4
Const BASS_MUSIC_ATTRIB_VOL_GLOBAL = 5
Const BASS_MUSIC_ATTRIB_VOL_CHAN = $100 
Const BASS_MUSIC_ATTRIB_VOL_INST = $200 

; Config options
Const BASS_CONFIG_BUFFER = 0
Const BASS_CONFIG_UPDATEPERIOD = 1
Const BASS_CONFIG_MAXVOL = 3
Const BASS_CONFIG_GVOL_SAMPLE = 4
Const BASS_CONFIG_GVOL_STREAM = 5
Const BASS_CONFIG_GVOL_MUSIC = 6
Const BASS_CONFIG_CURVE_VOL = 7
Const BASS_CONFIG_CURVE_PAN = 8
Const BASS_CONFIG_FLOATDSP = 9
Const BASS_CONFIG_3DALGORITHM = 10
Const BASS_CONFIG_NET_TIMEOUT = 11
Const BASS_CONFIG_NET_BUFFER = 12
Const BASS_CONFIG_PAUSE_NOPLAY = 13
Const BASS_CONFIG_NET_PREBUF = 15
Const BASS_CONFIG_NET_AGENT =16
Const BASS_CONFIG_NET_PROXY = 17
Const BASS_CONFIG_NET_PASSIVE = 18
Const BASS_CONFIG_REC_BUFFER = 19
Const BASS_CONFIG_NET_PLAYLIST = 21
Const BASS_CONFIG_MUSIC_VIRTUAL = 22

; Sample options
Const BASS_SAMPLE_8BITS = 1	
Const BASS_SAMPLE_FLOAT = 256	
Const BASS_SAMPLE_MONO = 2	
Const BASS_SAMPLE_LOOP = 4	
Const BASS_SAMPLE_3D = 8	
Const BASS_SAMPLE_SOFTWARE = 16	
Const BASS_SAMPLE_MUTEMAX = 32	
Const BASS_SAMPLE_VAM = 64	
Const BASS_SAMPLE_FX = 128	
Const BASS_SAMPLE_OVER_VOL = $10000	
Const BASS_SAMPLE_OVER_POS = $20000	
Const BASS_SAMPLE_OVER_DIST = $30000 

; Stream options
Const BASS_STREAM_PRESCAN = $20000 
Const BASS_MP3_SETPOS = BASS_STREAM_PRESCAN
Const BASS_STREAM_AUTOFREE = $40000	
Const BASS_STREAM_RESTRATE = $80000	
Const BASS_STREAM_BLOCK = $100000
Const BASS_STREAM_DECODE = $200000
Const BASS_STREAM_STATUS = $800000

; BASS_ChannelIsActive  values
Const BASS_ACTIVE_STOPPED = 0
Const BASS_ACTIVE_PLAYING = 1
Const BASS_ACTIVE_STALLED = 2
Const BASS_ACTIVE_PAUSED = 3 

; BASS_ChannelIsSliding return flags
Const BASS_SLIDE_FREQ = 1
Const BASS_SLIDE_VOL = 2
Const BASS_SLIDE_PAN = 4 

; BASS_ChannelSetFlags
Const BASS_MUSIC_FLOAT = BASS_SAMPLE_FLOAT 
Const BASS_MUSIC_MONO = BASS_SAMPLE_MONO 
Const BASS_MUSIC_LOOP = BASS_SAMPLE_LOOP 
Const BASS_MUSIC_3D = BASS_SAMPLE_3D 
Const BASS_MUSIC_FX = BASS_SAMPLE_FX 
Const BASS_MUSIC_AUTOFREE = BASS_STREAM_AUTOFREE 
Const BASS_MUSIC_DECODE = BASS_STREAM_DECODE 
Const BASS_MUSIC_PRESCAN = BASS_STREAM_PRESCAN	
Const BASS_MUSIC_CALCLEN = BASS_MUSIC_PRESCAN
Const BASS_MUSIC_RAMP = $200
Const BASS_MUSIC_RAMPS = $400
Const BASS_MUSIC_SURROUND = $800	
Const BASS_MUSIC_SURROUND2 = $1000	
Const BASS_MUSIC_FT2MOD = $2000
Const BASS_MUSIC_PT1MOD = $4000
Const BASS_MUSIC_NONINTER = $10000
Const BASS_MUSIC_POSRESET = $8000	
Const BASS_MUSIC_POSRESETEX = $400000
Const BASS_MUSIC_STOPBACK = $80000
Const BASS_MUSIC_NOSAMPLE = $100000

; Speaker assignment flags
Const BASS_SPEAKER_FRONT = $1000000
Const BASS_SPEAKER_REAR = $2000000
Const BASS_SPEAKER_CENLFE = $3000000
Const BASS_SPEAKER_REAR2 = $4000000
Const BASS_SPEAKER_N = 0 
Const BASS_SPEAKER_LEFT = $10000000	
Const BASS_SPEAKER_RIGHT = $20000000
Const BASS_SPEAKER_FRONTLEFT = BASS_SPEAKER_FRONT+BASS_SPEAKER_LEFT
Const BASS_SPEAKER_FRONTRIGHT = BASS_SPEAKER_FRONT+BASS_SPEAKER_RIGHT
Const BASS_SPEAKER_REARLEFT = BASS_SPEAKER_REAR+BASS_SPEAKER_LEFT
Const BASS_SPEAKER_REARRIGHT = BASS_SPEAKER_REAR+BASS_SPEAKER_RIGHT
Const BASS_SPEAKER_CENTER = BASS_SPEAKER_CENLFE+BASS_SPEAKER_LEFT
Const BASS_SPEAKER_LFE = BASS_SPEAKER_CENLFE+BASS_SPEAKER_RIGHT
Const BASS_SPEAKER_REAR2LEFT = BASS_SPEAKER_REAR2+BASS_SPEAKER_LEFT
Const BASS_SPEAKER_REAR2RIGHT = BASS_SPEAKER_REAR2+BASS_SPEAKER_RIGHT

Const BASS_UNICODE = $80000000

Const BASS_RECORD_PAUSE = $8000

; DX7 voice allocation flags
Const BASS_VAM_HARDWARE = 1
Const BASS_VAM_SOFTWARE = 2

; DX7 voice management flags
Const BASS_VAM_TERM_TIME = 4
Const BASS_VAM_TERM_DIST = 8
Const BASS_VAM_TERM_PRIO = 16

; BASS_CHANNELINFO types
Const BASS_CTYPE_SAMPLE = 1
Const BASS_CTYPE_RECORD = 2
Const BASS_CTYPE_STREAM = $10000
Const BASS_CTYPE_STREAM_OGG = $10002
Const BASS_CTYPE_STREAM_MP1 = $10003
Const BASS_CTYPE_STREAM_MP2 = $10004
Const BASS_CTYPE_STREAM_MP3 = $10005
Const BASS_CTYPE_STREAM_AIFF = $10006
Const BASS_CTYPE_STREAM_WAV = $40000
Const BASS_CTYPE_STREAM_WAV_PCM = $50001
Const BASS_CTYPE_STREAM_WAV_FLOAT = $50003
Const BASS_CTYPE_STREAM_WAV_MP3 = $50055
Const BASS_CTYPE_MUSIC_MOD = $20000
Const BASS_CTYPE_MUSIC_MTM = $20001
Const BASS_CTYPE_MUSIC_S3M= $20002
Const BASS_CTYPE_MUSIC_XM = $20003
Const BASS_CTYPE_MUSIC_IT = $20004
Const BASS_CTYPE_MUSIC_MO3 = $00100

; 3D channel modes
Const BASS_3DMODE_NORMAL = 0
Const BASS_3DMODE_RELATIVE = 1
Const BASS_3DMODE_OFF = 2

; EAX_Environment generic
Const EAX_ENVIRONMENT_GENERIC = 0
Const EAX_ENVIRONMENT_PADDEDCELL = 1
Const EAX_ENVIRONMENT_ROOM = 2
Const EAX_ENVIRONMENT_BATHROOM = 3
Const EAX_ENVIRONMENT_LIVINGROOM = 4
Const EAX_ENVIRONMENT_STONEROOM = 5
Const EAX_ENVIRONMENT_AUDITORIUM = 6
Const EAX_ENVIRONMENT_CONCERTHALL = 7
Const EAX_ENVIRONMENT_CAVE = 8
Const EAX_ENVIRONMENT_ARENA = 9
Const EAX_ENVIRONMENT_HANGAR = 10
Const EAX_ENVIRONMENT_CARPETEDHALLWAY = 11
Const EAX_ENVIRONMENT_HALLWAY = 12
Const EAX_ENVIRONMENT_STONECORRIDOR = 13
Const EAX_ENVIRONMENT_ALLEY = 14
Const EAX_ENVIRONMENT_FOREST = 15
Const EAX_ENVIRONMENT_CITY = 16
Const EAX_ENVIRONMENT_MOUNTAINS = 17
Const EAX_ENVIRONMENT_QUARRY = 18
Const EAX_ENVIRONMENT_PLAIN = 19
Const EAX_ENVIRONMENT_PARKINGLOT = 20
Const EAX_ENVIRONMENT_SEWERPIPE = 21
Const EAX_ENVIRONMENT_UNDERWATER = 22
Const EAX_ENVIRONMENT_DRUGGED = 23
Const EAX_ENVIRONMENT_DIZZY = 24
Const EAX_ENVIRONMENT_PSYCHOTIC = 25
Const EAX_ENVIRONMENT_COUNT = 26

; software 3D mixing algorithm modes 
Const BASS_3DALG_DEFAULT = 0
Const BASS_3DALG_OFF = 1
Const BASS_3DALG_FULL = 2
Const BASS_3DALG_LIGHT = 3

; end of user stream flag
Const BASS_STREAMPROC_END = $80000000

; StreamGetFilePosition modes
Const BASS_FILEPOS_CURRENT = 0
Const BASS_FILEPOS_DECODE = BASS_FILEPOS_CURRENT
Const BASS_FILEPOS_DOWNLOAD = 1
Const BASS_FILEPOS_END = 2
Const BASS_FILEPOS_START = 3
Const BASS_FILEPOS_CONNECTED = 4

; STREAMFILEPROC actions
Const BASS_FILE_CLOSE = 0
Const BASS_FILE_READ = 1
Const BASS_FILE_LEN = 3
Const BASS_FILE_SEEK = 4

; Sync types 
Const BASS_SYNC_POS = 0
Const BASS_SYNC_MUSICINST = 1
Const BASS_SYNC_END = 2
Const BASS_SYNC_MUSICFX = 3
Const BASS_SYNC_META = 4
Const BASS_SYNC_SLIDE = 5
Const BASS_SYNC_STALL = 6
Const BASS_SYNC_DOWNLOAD = 7
Const BASS_SYNC_FREE = 8
Const BASS_SYNC_MUSICPOS = 10
Const BASS_SYNC_SETPOS = 11
Const BASS_SYNC_MESSAGE = $20000000	
Const BASS_SYNC_MIXTIME = $40000000	
Const BASS_SYNC_ONETIME = $80000000

; BASS_ChannelGetData flags
Const BASS_DATA_AVAILABLE = 0
Const BASS_DATA_FLOAT = $40000000
Const BASS_DATA_FFT512 = $80000000
Const BASS_DATA_FFT1024 = $80000001
Const BASS_DATA_FFT2048 = $80000002
Const BASS_DATA_FFT4096 = $80000003
Const BASS_DATA_FFT8192 = $80000004
Const BASS_DATA_FFT_INDIVIDUAL = $10
Const BASS_DATA_FFT_NOWINDOW = $20
 
; BASS_ChannelGetTags types 
Const BASS_TAG_ID3 = 0	
Const BASS_TAG_ID3V2 = 1
Const BASS_TAG_OGG = 2
Const BASS_TAG_HTTP = 3
Const BASS_TAG_ICY = 4
Const BASS_TAG_META = 5
Const BASS_TAG_VENDOR = 9
Const BASS_TAG_LYRICS3 = 10
Const BASS_TAG_RIFF_INFO = $100 
Const BASS_TAG_MUSIC_NAME = $10000	
Const BASS_TAG_MUSIC_MESSAGE = $10001
Const BASS_TAG_MUSIC_INST = $10100
Const BASS_TAG_MUSIC_SAMPLE = $10300
 
 ; DX8 effect types, use with BASS_ChannelSetFX
Const BASS_FX_CHORUS = 0
Const BASS_FX_COMPRESSOR = 1
Const BASS_FX_DISTORTION = 2
Const BASS_FX_ECHO = 3
Const BASS_FX_FLANGER = 4
Const BASS_FX_GARGLE = 5
Const BASS_FX_I3DL2REVERB = 6
Const BASS_FX_PARAMEQ = 7
Const BASS_FX_REVERB = 8

; Bass phase 
Const BASS_FX_PHASE_NEG_180 = 0
Const BASS_FX_PHASE_NEG_90 = 1
Const BASS_FX_PHASE_ZERO = 2
Const BASS_FX_PHASE_90 = 3
Const BASS_FX_PHASE_180 = 4

; BASS_RecordSetInput flags
Const BASS_INPUT_OFF = $10000
Const BASS_INPUT_ON = $20000
Const BASS_INPUT_LEVEL = $40000

Const BASS_INPUT_TYPE_MASK = $ff000000
Const BASS_INPUT_TYPE_UNDEF = $00000000
Const BASS_INPUT_TYPE_DIGITAL = $01000000
Const BASS_INPUT_TYPE_LINE = $02000000
Const BASS_INPUT_TYPE_MIC	 = $03000000
Const BASS_INPUT_TYPE_SYNTH = $04000000
Const BASS_INPUT_TYPE_CD = $05000000
Const BASS_INPUT_TYPE_PHONE = $06000000
Const BASS_INPUT_TYPE_SPEAKER = $07000000
Const BASS_INPUT_TYPE_WAVE = $08000000
Const BASS_INPUT_TYPE_AUX = $09000000
Const BASS_INPUT_TYPE_ANALOG = $0a000000


;===== Help & Debug functions ===============================================================

Function BASS_CheckVersion% ()
Local temp%
	temp = BASS_GetVersion()
		If temp <> BASSVERSION	RuntimeError "Sorry, wrong BASS Version "+Hex$(temp) +" loaded !"
Return 0
End Function

Function BASS_Debug%(message$="none")
	Local errorstring$
	Local current% = BASS_ErrorGetCode()
		If current <>0 
			errorstring = BASS_GetErrorString()
			BASS_Free()
			If message <> "none"  RuntimeError message +" : " +errorstring
			If message = "none"  RuntimeError errorstring
		EndIf	
	
	Return 0
End Function


Function BASS_GetErrorString$ ()
		Local basserrortemp
		Local temp$ 
		basserrortemp = BASS_ErrorGetCode ()
		Select basserrortemp
				
				Case 0 temp = "BASS_OK" 
				Case 1 temp = "BASS_ERROR_MEM"   
				Case 2 temp = "BASS_ERROR_FILEOPEN"  
				Case 3 temp = "BASS_ERROR_DRIVER"  
				Case 4 temp = "BASS_ERROR_BUFLOST"  
				Case 5 temp = "BASS_ERROR_HANDLE"  
				Case 6 temp = "BASS_ERROR_FORMAT"  
				Case 7 temp = "BASS_ERROR_POSITION"  
				Case 8 temp = "BASS_ERROR_INIT"  
				Case 9 temp = "BASS_ERROR_START"  
				Case 12 temp = "BASS_ERROR_NOCD"
				Case 13 temp = "BASS_ERROR_CDTRACK"
				Case 14 temp = "BASS_ERROR_ALREADY"  
				Case 16 temp = "BASS_ERROR_NOPAUSE"  
				Case 17 temp = "BASS_ERROR_NOTAUDIO"
				Case 18 temp = "BASS_ERROR_NOCHAN"  
				Case 19 temp = "BASS_ERROR_ILLTYPE"  
				Case 20 temp = "BASS_ERROR_ILLPARAM"  
				Case 21 temp = "BASS_ERROR_NO3D"  
				Case 22 temp = "BASS_ERROR_NOEAX"  
				Case 23 temp = "BASS_ERROR_DEVICE"  
				Case 24 temp = "BASS_ERROR_NOPLAY"  
				Case 25 temp = "BASS_ERROR_FREQ"  
				Case 27 temp = "BASS_ERROR_NOTFILE"  
				Case 29 temp = "BASS_ERROR_NOHW"  
				Case 31 temp = "BASS_ERROR_EMPTY"  
				Case 32 temp = "BASS_ERROR_NONET"  
				Case 33 temp = "BASS_ERROR_CREATE"  
				Case 34 temp = "BASS_ERROR_NOFX"  
				Case 35 temp = "BASS_ERROR_PLAYING"  
				Case 37 temp = "BASS_ERROR_NOTAVAIL"  
				Case 38 temp = "BASS_ERROR_DECODE"  
				Case 39 temp = "BASS_ERROR_DX"  
				Case 40 temp = "BASS_ERROR_TIMEOUT"  
				Case 41 temp = "BASS_ERROR_FILEFORM"  
				Case 42 temp = "BASS_ERROR_SPEAKER"  
				Case 43 temp = "BASS_ERROR_VERSION"  
				Case 44 temp = "BASS_ERROR_CODEC"  
				Case 100 temp = "BASS_FX_ERROR_NODECODE	"
				Case 101 temp = "BASS_FX_ERROR_BPMINUSE"	
				Case 1000 temp = "BASS_ERROR_WMA_LICENSE"
				Case 1001 temp = "BASS_ERROR_WMA_WM9"
				Case 1002 temp = "BASS_ERROR_WMA_DENIED"	
				Case 1004 temp  = "BASS_ERROR_WMA_INDIVIDUAL"	
				Case 2000 temp = "BASS_ERROR_ACM_CANCEL"	
				Case 2100 temp = "BASS_ERROR_CAST_DENIED"

				Case -1 temp = "BASS_ERROR_UNKNOWN" 
				Default temp = "BASS_CODE_UNKNOWN_BY_FUNCTION"
				
				End Select
		Return temp
End Function

;===== DX8 FX  functions ===========================================================

Function BASS_FXGetValue#(han_dle%,effect%,number%)
		Local temp#
		Local Bank = CreateBank(48) 
		BASS_FXGetParameters(han_dle,Bank) 
				If number = 0 Then temp = 0
				If effect = 0  Then ;Chorus 
								If number = 1 Then temp = PeekFloat (Bank,0)
								If number = 2 Then temp = PeekFloat (Bank,4)
								If number = 3 Then temp = PeekFloat (Bank,8)
								If number = 4 Then temp = PeekFloat (Bank,12)
								If number = 5 Then temp = PeekInt (Bank,16)
								If number = 6 Then temp = PeekFloat (Bank,20)
								If number = 7 Then temp = PeekInt (Bank,24)
								If number > 7 Then temp = 0
				EndIf
				If effect = 1 Then ;Compressor
								If number = 1 Then temp = PeekFloat (Bank,0)
								If number = 2 Then temp = PeekFloat (Bank,4)
								If number = 3 Then temp = PeekFloat (Bank,8)
								If number = 4 Then temp = PeekFloat (Bank,12)
								If number = 5 Then temp = PeekFloat (Bank,16)
								If number = 6 Then temp = PeekFloat (Bank,20)
								If number > 6 Then temp = 0
				EndIf				
				If effect = 2 Then ;Distortion
								If number = 1 Then temp = PeekFloat (Bank,0)
								If number = 2 Then temp = PeekFloat (Bank,4)
								If number = 3 Then temp = PeekFloat (Bank,8)
								If number = 4 Then temp = PeekFloat (Bank,12)
								If number = 5 Then temp = PeekFloat (Bank,16)
								If number > 5 Then temp = 0
				EndIf
				If effect = 3 Then ;Echo
								If number = 1 Then temp = PeekFloat (Bank,0)
								If number = 2 Then temp = PeekFloat (Bank,4)
								If number = 3 Then temp = PeekFloat (Bank,8)
								If number = 4 Then temp = PeekFloat (Bank,12)
								If number = 5 Then temp = PeekInt (Bank,16)
								If number > 5 Then temp = 0
				EndIf
				
				If effect = 4 Then ;Flanger
								If number = 1 Then temp = PeekFloat (Bank,0)
								If number = 2 Then temp = PeekFloat (Bank,4)
								If number = 3 Then temp = PeekFloat (Bank,8)
								If number = 4 Then temp = PeekFloat (Bank,12)
								If number = 5 Then temp = PeekInt (Bank,16)
								If number = 6 Then temp = PeekFloat (Bank,20)
								If number = 7 Then temp = PeekInt (Bank,24)
								If number > 7 Then temp = 0
				EndIf
				
				If effect = 5 Then ;Gargle
								If number = 1 Then temp = PeekInt (Bank,0)
								If number = 2 Then temp = PeekInt (Bank,4)
								If number > 2 Then temp = 0
				EndIf
				
				If effect = 6 Then ;I3DL2Reverb
								If number = 1 Then temp = PeekInt (Bank,0)
								If number = 2 Then temp = PeekInt (Bank,4)
								If number = 3 Then temp = PeekFloat (Bank,8)
								If number = 4 Then temp = PeekFloat (Bank,12)
								If number = 5 Then temp = PeekFloat (Bank,16)
								If number = 6 Then temp = PeekInt (Bank,20)
								If number = 7 Then temp = PeekFloat (Bank,24)
								If number = 8 Then temp = PeekInt (Bank,28)
								If number = 9 Then temp = PeekFloat (Bank,32)
								If number = 10 Then temp = PeekFloat (Bank,36)
								If number = 11 Then temp = PeekFloat (Bank,40)
								If number = 12 Then temp = PeekFloat(Bank,44)
								If number > 12 Then temp = 0
				EndIf
				
				If effect = 7 Then ; ParamEQ
								If number = 1 Then temp = PeekFloat (Bank,0)
								If number = 2 Then temp = PeekFloat (Bank,4)
								If number = 3 Then temp = PeekFloat (Bank,8)
								If number > 3 Then temp = 0
				EndIf
								
				If effect = 8 Then ;	Reverb		
								If number = 1 Then temp = PeekFloat (Bank,0)
								If number = 2 Then temp = PeekFloat (Bank,4)
								If number = 3 Then temp = PeekFloat (Bank,8)
								If number = 4 Then temp = PeekFloat (Bank,12)
								If number > 4 Then temp = 0
				EndIf
		FreeBank Bank
		Return temp		
End Function 		
		
Function BASS_FXSetReverb%(han_dle%,fInGain#,fReverbMix#,fReverbTime#,fHighFreqRTRatio#)
		Local goal
		Local Bank = CreateBank(16)
		PokeFloat Bank,00,fInGain#
		PokeFloat Bank,04,fReverbMix#
		PokeFloat Bank,08,fReverbTime#
		PokeFloat Bank,12,fHighFreqRTRatio#
		goal = BASS_FXSetParameters(han_dle,Bank)	
		FreeBank Bank
		Return goal
End Function

Function BASS_FXSetParamEQ%(han_dle%,fCenter#,fBandwidth#,fGain#)
		Local goal
		Local Bank = CreateBank(12)
		PokeFloat Bank,00,fCenter#
		PokeFloat Bank,04,fBandwidth#
		PokeFloat Bank,08,fGain#
		goal = BASS_FXSetParameters(han_dle,Bank)	
		FreeBank Bank
		Return goal
End Function 

Function BASS_FXSetI3DL2Reverb%(han_dle%,lRoom%,lRoomHF%,flRoomRolloffFactor#,flDecayTime#,flDecayHFRatio#, lReflections%,flReflectionsDelay#,lReverb%,flReverbDelay#, flDiffusion#,flDensity#,flHFReference#)
		Local goal
		Local Bank = CreateBank(48)
		PokeInt   Bank,00,lRoom%
		PokeInt   Bank,04,lRoomHF%
		PokeFloat Bank,08,flRoomRolloffFactor#
		PokeFloat Bank,12,flDecayTime#
		PokeFloat Bank,16,flDecayHFRatio#
		PokeInt   Bank,20,lReflections%
		PokeFloat Bank,24,flReflectionsDelay#
		PokeInt   Bank,28,lReverb%
		PokeFloat Bank,32,flReverbDelay#
		PokeFloat Bank,36,flDiffusion#
		PokeFloat Bank,40,flDensity#
		PokeFloat Bank,44,flHFReference#
		goal = BASS_FXSetParameters(han_dle,Bank)	
		FreeBank Bank
		Return goal
End Function

Function BASS_FXSetGargle(han_dle%,dwRateHz%,dwWaveShape%)
		Local goal
		Local Bank = CreateBank(8)
		PokeInt   Bank,00,dwRateHz%
		PokeInt   Bank,04,dwWaveShape%
		goal = BASS_FXSetParameters(han_dle,Bank)	
		FreeBank Bank
		Return goal
End Function

Function BASS_FXSetFlanger%(han_dle%,fWetDryMix#,fDepth#,fFeedback#,fFrequency#,lWaveform%,fDelay#,lPhase%)
		Local goal
		Local Bank = CreateBank(28)
		PokeFloat Bank,00,fWetDryMix#
		PokeFloat Bank,04,fDepth#
		PokeFloat Bank,08,fFeedback#
		PokeFloat Bank,12,fFrequency#
		PokeInt   Bank,16,lWaveform%
		PokeFloat Bank,20,fDelay#
		PokeInt   Bank,24,lPhase%
		goal = BASS_FXSetParameters(han_dle,Bank)	
		FreeBank Bank
		Return goal
End Function

Function BASS_FXSetDistortion%(han_dle%,fGain#,fEdge#,fPostEQCenterFrequency#,fPostEQBandwidth#,fPreLowpassCutoff#)
		Local goal
		Local Bank = CreateBank(20)
		PokeFloat Bank,00,fGain#
		PokeFloat Bank,04,fEdge#
		PokeFloat Bank,08,fPostEQCenterFrequency#
		PokeFloat Bank,12,fPostEQBandwidth#
		PokeFloat Bank,16,fPreLowpassCutoff#
		goal = BASS_FXSetParameters(han_dle,Bank)	
		FreeBank Bank
		Return goal
End Function

Function BASS_FXSetCompressor%(han_dle%,fGain#,fAttack#,fRelease#,fThreshold#,fRatio#,fPredelay#)
		Local goal
		Local Bank = CreateBank(24)
		PokeFloat Bank,00,fGain#
		PokeFloat Bank,04,fAttack#
		PokeFloat Bank,08,fRelease#
		PokeFloat Bank,12,fThreshold#
		PokeFloat Bank,16,fRatio#
		PokeFloat Bank,20,fPredelay#
		goal = BASS_FXSetParameters(han_dle,Bank)	
		FreeBank Bank
		Return goal
End Function

Function BASS_FXSetChorus%(han_dle%,fWetDryMix#,fDepth#,fFeedback#,fFrequency#,lWaveform%,fDelay#,lPhase%)
		Local goal
		Local Bank = CreateBank(28)
		PokeFloat Bank,00,fWetDryMix#
		PokeFloat Bank,04,fDepth#
		PokeFloat Bank,08,fFeedback#
		PokeFloat Bank,12,fFrequency#
		PokeInt   Bank,16,lWaveform%
		PokeFloat Bank,20,fDelay#
		PokeInt   Bank,24,lPhase%
		goal = BASS_FXSetParameters(han_dle,Bank)	
    FreeBank Bank
		Return goal
End Function 

Function BASS_FXSetEcho% (han_dle%,fWetDryMix#,fFeedback#,fLeftDelay#,fRightDelay#,lPanDelay%)
		Local goal
		Local Bank = CreateBank(20)
		PokeFloat Bank,00,fWetDryMix#
		PokeFloat Bank,04,fFeedback#
		PokeFloat Bank,08,fLeftDelay#
		PokeFloat Bank,12,fRightDelay#
		PokeInt   Bank,16,lPanDelay%
		goal = BASS_FXSetParameters(han_dle,Bank)
		FreeBank Bank
		Return goal
End Function

;===== Hardware functions ===============================================================

Function BASS_GetDeviceDescriptionString$(device%)
	Local Pointer,BnkDescription,Description$,I,Char
	Pointer = BASS_GetDeviceDescription(device)
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

;===== EAX functions ===============================================================

Function BASS_SetEAXParameters%(env%,vol#,decay#,damp#)
		Local temp
		Local  vo#, dec#, dam#

If env = 0 Then : vo = 0.5 : dec = 1.493 : dam = 0.5 : EndIf 
If env = 1 Then : vo = 0.25 : dec = 0.1 : dam = 0.0 : EndIf 
If env = 2 Then : vo = 0.417 : dec = 1.4 : dam = 0.666 : EndIf 
If env = 3 Then : vo = 0.653 : dec = 1.499 : dam = 0.166 : EndIf 
If env = 4 Then : vo = 0.208 : dec = 0.478 : dam = 0.0 : EndIf 
If env = 5 Then : vo = 0.5 : dec = 2.309 : dam = 0.888 : EndIf 
If env = 6 Then : vo = 0.403 : dec = 4.279 : dam = 0.5 : EndIf 
If env = 7 Then : vo = 0.5 : dec = 3.961 : dam = 0.5 : EndIf 
If env = 8 Then : vo = 0.5 : dec = 2.886 : dam = 1.304 : EndIf 
If env = 9 Then : vo = 0.361 : dec = 7.284 : dam = 0.332 : EndIf 
If env = 10 Then : vo = 0.5 : dec = 10.0 : dam = 0.3 : EndIf 
If env = 11 Then : vo = 0.153 : dec = 0.259 : dam = 2.0 : EndIf 
If env = 12 Then : vo = 0.361 : dec = 1.493 : dam = 0.0 : EndIf 
If env = 13 Then : vo = 0.444 : dec = 2.697 : dam = 0.638 : EndIf 
If env = 17 Then : vo = 0.25: dec = 1.752 : dam = 0.776 : EndIf 
If env = 15 Then : vo = 0.111 : dec = 3.145 : dam = 0.427 : EndIf 
If env = 16 Then : vo = 0.111 : dec = 2.767 : dam = 0.224 : EndIf 
If env = 18 Then : vo = 0.194 : dec = 7.841 : dam = 0.472 : EndIf 
If env = 19 Then : vo = 1.0 : dec = 1.499 : dam = 0.5 : EndIf 
If env = 20 Then : vo = 0.097 : dec = 2.767 : dam = 0.224 : EndIf 
If env = 21 Then : vo = 0.208 : dec = 1.652 : dam = 1.5 : EndIf 
If env = 22 Then : vo = 0.652 : dec = 2.886 : dam = 0.25 : EndIf 
If env = 23 Then : vo = 1.0 : dec = 1.499 : dam = 0.0 : EndIf 
If env = 24 Then : vo = 0.875 : dec = 8.392 : dam = 1.388 : EndIf 
If env = 25 Then : vo = 0.139 : dec = 17.234 : dam = 0.666 : EndIf 
If env = 26 Then : vo = 0.486 : dec = 7.563 : dam = 0.806 : EndIf 

If Not vol = 0.0 Then vo = vol
If Not decay = 0.0 Then dec = decay
If Not damp =  0.0 Then dam = damp

temp = BASS_SetEAXParametersInt%(env,vo,dec,dam)
Return temp
End Function

;===== Help functions ===============================================================

Function BASS_GetDeviceCount() 
	Local I
	While True
		If BASS_GetDeviceDescription(I) Then
			I = I + 1
		Else
			Return I
		EndIf
	Wend
End Function

Function BASS_MakeLong%(lo%,hi%)
	Return (hi Shl 16) Or (lo And $0000FFFF)
End Function

Function BASS_MakeLoWord%(val%)
		Local temp%
		temp = val And $0000FFFF 
		Return temp
End Function

Function BASS_MakeHiWord%(val%)
		Local temp%
		temp = val And $FFFF0000 
		temp = temp Shr 16
		Return temp
End Function 

Function BASS_MakeMusicPos%(order%,row%) 
		Local temp%
		temp = $80000000 Or BASS_MakeLong(order, row)
		Return temp
End Function

; === 3D Functions ===============================================================

Function BASS_Set3DPositionPos%(posX#,posY#,posZ#)
	Local Bank,temp
	Bank  = CreateBank(3 * 4)
	PokeFloat Bank,0,posX#
	PokeFloat Bank,4,posY#
	PokeFloat Bank,8,posZ#
	temp = BASS_Set3DPositionPosP%(Bank,0,0,0) 
	FreeBank Bank
	Return temp
End Function

Function BASS_Set3DPositionVel%(velX#,velY#,velZ#)
	Local Bank,temp
	Bank  = CreateBank(3 * 4)
	PokeFloat Bank,0,velX#
	PokeFloat Bank,4,velY#
	PokeFloat Bank,8,velZ#
	temp = BASS_Set3DPositionVelP%(0,Bank,0,0) 
	FreeBank Bank
	Return temp
End Function

Function BASS_Set3DPositionFront%(frontX#,frontY#,frontZ#)
	Local Bank,temp
	Bank  = CreateBank(3 * 4)
	PokeFloat Bank,0,frontX#
	PokeFloat Bank,4,frontY#
	PokeFloat Bank,8,frontZ#
	temp = BASS_Set3DPositionFrontP%(0,0,Bank,0) 
	FreeBank Bank
	Return temp
End Function

Function BASS_Set3DPositionTop%(topX#,topY#,topZ#)
	Local Bank,temp
	Bank  = CreateBank(3 * 4)
	PokeFloat Bank,0,topX#
	PokeFloat Bank,4,topY#
	PokeFloat Bank,8,topZ#
	temp = BASS_Set3DPositionTopP%(0,0,0,Bank) 
	FreeBank Bank
	Return temp
End Function

Function BASS_Set3DPositionFrontTop%(frontX#,frontY#,frontZ#,topX#,topY#,topZ#)
	Local Bank,Bank2,temp
	Bank  = CreateBank(3 * 4)
	Bank2 = CreateBank(3 * 4)
	PokeFloat Bank,0,frontX#
	PokeFloat Bank,4,frontY#
	PokeFloat Bank,8,frontZ#
	PokeFloat Bank2,0,topX#
	PokeFloat Bank2,4,topY#
	PokeFloat Bank2,8,topZ#
	temp = BASS_Set3DPositionFrontTopP%(0,0,Bank,Bank2) 
	FreeBank Bank
	FreeBank Bank2
	Return temp
End Function

Function BASS_Update3DListener%(entity%) 
	Local Bank,temp
	Local fx#,fy#,fz#,tx#,ty#,tz# 
		Bank  = CreateBank(3 * 4)
			PokeFloat Bank,0,EntityX(entity)
			PokeFloat Bank,4,EntityY(entity)
			PokeFloat Bank,8,EntityZ(entity)
		If Not  BASS_Set3DPositionPosP%(Bank,0,0,0) BASS_Debug()
	FreeBank Bank

      ;LookAt Vector (Front)
	TFormVector 0,0,1,entity,0 
		fx = TFormedX() 
		fy = TFormedY() 
		fz = TFormedZ() 
	;UpVector (Top)
	TFormVector 0,1,0,entity,0 
		tx = TFormedX() 
		ty = TFormedY() 
		tz = TFormedZ() 
      Return BASS_Set3DPositionFrontTop(fx,fy,fz,tx,ty,tz) 
 End Function 

Function BASS_ChannelSet3DPositionPos% (channel%,posX#,posY#,posZ#)
Local Bank, temp
	Bank  = CreateBank(3 * 4)
	PokeFloat Bank,0,posX#
	PokeFloat Bank,4,posY#
	PokeFloat Bank,8,posZ#
	temp = BASS_ChannelSet3DPositionPosP(channel,Bank,0,0) 
	FreeBank Bank
	Return temp
End Function

Function BASS_ChannelSet3DPositionOri% (channel%,oriX#,oriY#,oriZ#)
Local Bank, temp
	Bank  = CreateBank(3 * 4)
	PokeFloat Bank,0,oriX#
	PokeFloat Bank,4,oriY#
	PokeFloat Bank,8,oriZ#
	temp = BASS_ChannelSet3DPositionOriP(channel,0,Bank,0) 
	FreeBank Bank
	Return temp
End Function

Function BASS_ChannelSet3DPositionVel% (channel%,velX#,velY#,velZ#)
Local Bank, temp
	Bank  = CreateBank(3 * 4)
	PokeFloat Bank,0,velX#
	PokeFloat Bank,4,velY#
	PokeFloat Bank,8,velZ#
	temp = BASS_ChannelSet3DPositionVelP(channel,0,0,Bank) 
	FreeBank Bank
	Return temp
End Function

; === QWORD Returns ===============================================================

Function BASS_ChannelBytes2Seconds#(Han_dle,pos%)
		Local temp#
		temp = BASS_ChannelBytes2SecondsQ#(Han_dle,pos%,0)
		Return temp
End Function 

Function BASS_ChannelSetPosition%(Han_dle,pos%)
		Local temp
		temp = BASS_ChannelSetPositionQ%(Han_dle,pos%,0)
		Return temp
End Function

; ==== QWORD Protection ===========================================================

Function BASS_MusicLoad%(mem%,file$,offset%,length%,flags%,freq%)
Local temp, big
big = FileSize (file$)
If big > BASS_Max_Supported_File_Size Return 0
If big < BASS_Min_Supported_File_Size Return 0
temp = BASS_MusicLoadQ%(mem%,file$,offset%,length%,flags%,freq%)
Return temp
End Function

Function BASS_SampleLoad%(mem%,file$,offset%,length%,max%,flags%)
Local temp, big
big = FileSize (file$)
If big > BASS_Max_Supported_File_Size Return 0
If big < BASS_Min_Supported_File_Size Return 0
temp = BASS_SampleLoadQ%(mem%,file$,offset%,length%,max%,flags%)
Return temp
End Function

Function BASS_StreamCreateFile%(mem%,file$,offset%,lenght%,flags%)
Local temp, big
big = FileSize (file$)
If big > BASS_Max_Supported_File_Size Return 0
If big < BASS_Min_Supported_File_Size Return 0
temp = BASS_StreamCreateFileQ%(mem%,file$,offset%,lenght%,flags%)
Return temp
End Function

; ==== Beep & Chiptunes =============================================================

Function BASS_CreateBeep%(art% = 1 ,hz% = 900,time% = 100 ,freq# = 44100 , chans% = 1, max% = 1, flags% = 0, onlynew% = 0)
	
	Local q%, y%, yy% , stemp%, length%, tbank%, hfinal%, hchannel%
		length = (((freq*chans)*time) / 1000)*2
			stemp = BASS_SampleCreate(length,freq,chans,max,flags)
				tbank = CreateBank (length*2)
				For q = 0 To (length-1)
						;this 4 are for 44100/mono/16bit (default values)
						If art=1 y=Sin(q/freq*360*hz)*32767
						If art=2 yy=yy+Rand(hz/8,hz*3):y=Sin(yy/freq*360)*16384
						If art=3 yy=yy+Rand(1000.0*hz/(q+1),1000.0*hz/(q+1)*10):y=Sin(yy/freq*360)*16384
						If art=4 y=y+hz*1.45:If y>32767 y=-32767
					
						;feel free to add your own stuff. :)
				PokeShort tbank, q*2, y
				Next
				BASS_RtlMoveMemory2(stemp, tbank, length)
			FreeBank tbank
		hfinal = BASS_SampleCreateDone()
	hchannel = BASS_SampleGetChannel (hfinal, onlynew)
Return hchannel

End Function    



;~IDEal Editor Parameters:
;~C#Blitz3D