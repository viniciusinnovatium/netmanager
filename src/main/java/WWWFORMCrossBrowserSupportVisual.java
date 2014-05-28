//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWFORMCrossBrowserSupportVisual
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:13:28
//*****************************************************************************

import mLibrary.*;


//<< WWWFORMCrossBrowserSupportVisual
public class WWWFORMCrossBrowserSupportVisual extends mClass {

  public void main() {
    _WWWFORMCrossBrowserSupportVisual();
  }

  public void _WWWFORMCrossBrowserSupportVisual() {
  }

  //<< 
  //<< Gray(pstrValue)
  public Object Gray(Object ... _p) {
    mVar pstrValue = m$.newVarRef("pstrValue",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Returns a filter for graying out disables buttons.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 02-Aug-2010   shobby      SR17481: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strText
    mVar strText = m$.var("strText");
    m$.newVar(strText);
    //<< 
    //<< if $get(YUSERAGENT)="MSIE" {
    if (mOp.Equal(m$.Fnc.$get(m$.var("YUSERAGENT")),"MSIE")) {
      //<< set strText = " filter:Alpha(opacity="_pstrValue_") gray();"
      strText.set(mOp.Concat(mOp.Concat(" filter:Alpha(opacity=",pstrValue.get()),") gray();"));
    }
    //<< 
    //<< } elseif $get(YUSERAGENT)="GECKO" {  ;(firefox)
    else if (mOp.Equal(m$.Fnc.$get(m$.var("YUSERAGENT")),"GECKO")) {
      //<< set strText = " opacity:"_$justify(pstrValue/100,1,2)_";"
      strText.set(mOp.Concat(mOp.Concat(" opacity:",m$.Fnc.$justify(mOp.Divide(pstrValue.get(),100),1,2)),";"));
    }
    //<< 
    //<< } else {
    else {
      //<< set strText = ""
      strText.set("");
    }
    //<< }
    //<< quit strText
    return strText.get();
  }

  //<< 
  //<< 
  //<< ImageTransformGradient(pstrColor1,pstrColor2)
  public Object ImageTransformGradient(Object ... _p) {
    mVar pstrColor1 = m$.newVarRef("pstrColor1",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar pstrColor2 = m$.newVarRef("pstrColor2",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; DXImageTransform is a MSIE thing.  So redirect to an equivalent if using a
    //<< ; different browser.
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 07-Dec-2010   shobby  SR17624: Don't do anything clever if pstrColor2 is empty.
    //<< ; 21-Apr-2010   shobby  SR17253: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strText
    mVar strText = m$.var("strText");
    m$.newVar(strText);
    //<< 
    //<< set strText = ""
    strText.set("");
    //<< 
    //<< if ($get(YUSERAGENT)="MSIE") && (pstrColor2'="") {
    if ((mOp.Equal(m$.Fnc.$get(m$.var("YUSERAGENT")),"MSIE")) && (mOp.NotEqual(pstrColor2.get(),""))) {
      //<< set strText = strText_" filter:progid:DXImageTransform.Microsoft.Gradient(GradientType=1, StartColorStr="_pstrColor1_", EndColorStr="_pstrColor2_")"
      strText.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strText.get()," filter:progid:DXImageTransform.Microsoft.Gradient(GradientType=1, StartColorStr="),pstrColor1.get()),", EndColorStr="),pstrColor2.get()),")"));
    }
    //<< 
    //<< } elseif ($get(YUSERAGENT)="GECKO") && (pstrColor2'="") {  ;(firefox)
    else if ((mOp.Equal(m$.Fnc.$get(m$.var("YUSERAGENT")),"GECKO")) && (mOp.NotEqual(pstrColor2.get(),""))) {
      //<< set strText = strText_"background-image:-moz-linear-gradient(left, #"_$$Lookup(pstrColor1)_", #"_$$Lookup(pstrColor2)_");"
      strText.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strText.get(),"background-image:-moz-linear-gradient(left, #"),m$.fnc$("Lookup",pstrColor1.get())),", #"),m$.fnc$("Lookup",pstrColor2.get())),");"));
    }
    //<< 
    //<< } elseif ($get(YUSERAGENT)="CHROME") && (pstrColor2'="") {
    else if ((mOp.Equal(m$.Fnc.$get(m$.var("YUSERAGENT")),"CHROME")) && (mOp.NotEqual(pstrColor2.get(),""))) {
      //<< set strText = strText_"background:-webkit-gradient(linear,left top, right top, from(#"_$$Lookup(pstrColor1)_"), to(#"_$$Lookup(pstrColor2)_"));"
      strText.set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(strText.get(),"background:-webkit-gradient(linear,left top, right top, from(#"),m$.fnc$("Lookup",pstrColor1.get())),"), to(#"),m$.fnc$("Lookup",pstrColor2.get())),"));"));
    }
    //<< 
    //<< } else {
    else {
      //<< set strText = strText_"background:"_$$Lookup(pstrColor1)_";"
      strText.set(mOp.Concat(mOp.Concat(mOp.Concat(strText.get(),"background:"),m$.fnc$("Lookup",pstrColor1.get())),";"));
    }
    //<< }
    //<< quit strText
    return strText.get();
  }

  //<< 
  //<< 
  //<< 
  //<< 
  //<< Lookup(pstrColor)
  public Object Lookup(Object ... _p) {
    mVar pstrColor = m$.newVarRef("pstrColor",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ; Translate colour text to RGB.  (Couldn't find a cache function to do this)
    //<< ;
    //<< ; Inputs:
    //<< ;
    //<< ; Returns:
    //<< ;
    //<< ; History:
    //<< ; 07-Dec-2010   shobby  SR17624: Handled the case where pstrColor is not one in
    //<< ;                           the list. eg.  "" (Empty string)
    //<< ; 21-Apr-2010   shobby  SR17253: Created
    //<< ;-------------------------------------------------------------------------------
    //<< new strColor
    mVar strColor = m$.var("strColor");
    m$.newVar(strColor);
    //<< 
    //<< set strColor = $case($zcvt(pstrColor,"l"),
    //<< "aliceblue"             :"f0f8ff",
    //<< "antiquewhite"          :"faebd7",
    //<< "aqua"                  :"00ffff",
    //<< "aquamarine"            :"7fffd4",
    //<< "azure"                 :"f0ffff",
    //<< "beige"                 :"f5f5d0",
    //<< "bisque"                :"ffe4c4",
    //<< "black"                 :"000000",
    //<< "blanchedalmond"        :"ffebcd",
    //<< "blue"                  :"0000ff",
    //<< "blueviolet"            :"8a2be2",
    //<< "brown"                 :"a52a2a",
    //<< "burlywood"             :"deb887",
    //<< "cadetblue"             :"5f9ea0",
    //<< "chartreuse"            :"7fff00",
    //<< "chocolate"             :"d2691e",
    //<< "coral"                 :"ff7f50",
    //<< "cornflowerblue"        :"6495ed",
    //<< "cornsilk"              :"fff8dc",
    //<< "crimson"               :"dc143c",
    //<< "cyan"                  :"00ffff",
    //<< "darkblue"              :"00008b",
    //<< "darkcyan"              :"008b8b",
    //<< "darkgoldenrod"         :"b8860b",
    //<< "darkgray"              :"a9a9a9",
    //<< "darkgreen"             :"006400",
    //<< "darkkhaki"             :"bdb76b",
    //<< "darkmagenta"           :"8b008b",
    //<< "darkolivegreen"        :"556b2f",
    //<< "darkorange"            :"ff8c00",
    //<< "darkorchid"            :"9932cc",
    //<< "darkred"               :"8b0000",
    //<< "darksalmon"            :"e9967a",
    //<< "darkseagreen"          :"8fbc8f",
    //<< "darkslateblue"         :"483d8b",
    //<< "darkslategray"         :"2f4f4f",
    //<< "darkturquoise"         :"00ced1",
    //<< "darkviolet"            :"9400d3",
    //<< "deeppink"              :"ff1493",
    //<< "deepskyblue"           :"00bfff",
    //<< "dimgray"               :"696969",
    //<< "dodgerblue"            :"1e90ff",
    //<< "feldspar"              :"d19275",
    //<< "firebrick"             :"b22222",
    //<< "floralwhite"           :"fffaf0",
    //<< "forestgreen"           :"228b22",
    //<< "fuchsia"               :"ff00ff",
    //<< "gainsboro"             :"dcdcdc",
    //<< "ghostwhite"            :"f8f8ff",
    //<< "gold"                  :"ffd700",
    //<< "goldenrod"             :"daa520",
    //<< "gray"                  :"808080",
    //<< "green"                 :"008000",
    //<< "greenyellow"           :"adff2f",
    //<< "honeydew"              :"f0fff0",
    //<< "hotpink"               :"ff69b4",
    //<< "indianred"             :"cd5c5c",
    //<< "indigo"                :"4b0082",
    //<< "ivory"                 :"fffff0",
    //<< "khaki"                 :"f0e68c",
    //<< "lavender"              :"e6e6fa",
    //<< "lavenderblush"         :"fff0f5",
    //<< "lawngreen"             :"7cfc00",
    //<< "lemonchiffon"          :"fffacd",
    //<< "lightblue"             :"add8e6",
    //<< "lightcoral"            :"f08080",
    //<< "lightcyan"             :"e0ffff",
    //<< "lightgoldenrodyellow"  :"fafad2",
    //<< "lightgrey"             :"d3d3d3",
    //<< "lightgreen"            :"90ee90",
    //<< "lightpink"             :"ffb6c1",
    //<< "lightsalmon"           :"ffa07a",
    //<< "lightseagreen"         :"20b2aa",
    //<< "lightskyblue"          :"87cefa",
    //<< "lightslateblue"        :"8470ff",
    //<< "lightslategray"        :"778899",
    //<< "lightsteelblue"        :"b0c4de",
    //<< "lightyellow"           :"ffffe0",
    //<< "lime"                  :"00ff00",
    //<< "limegreen"             :"32cd32",
    //<< "linen"                 :"faf0e6",
    //<< "magenta"               :"ff00ff",
    //<< "maroon"                :"800000",
    //<< "mediumaquamarine"      :"66cdaa",
    //<< "mediumblue"            :"0000cd",
    //<< "mediumorchid"          :"ba55d3",
    //<< "mediumpurple"          :"9370d8",
    //<< "mediumseagreen"        :"3cb371",
    //<< "mediumslateblue"       :"7b68ee",
    //<< "mediumspringgreen"     :"00fa9a",
    //<< "mediumturquoise"       :"48d1cc",
    //<< "mediumvioletred"       :"c71585",
    //<< "midnightblue"          :"191970",
    //<< "mintcream"             :"f5fffa",
    //<< "mistyrose"             :"ffe4e1",
    //<< "moccasin"              :"ffe4b5",
    //<< "navajowhite"           :"ffdead",
    //<< "navy"                  :"000080",
    //<< "oldlace"               :"fdf5e6",
    //<< "olive"                 :"808000",
    //<< "olivedrab"             :"6b8e23",
    //<< "orange"                :"ffa500",
    //<< "orangered"             :"ff4500",
    //<< "orchid"                :"da70d6",
    //<< "palegoldenrod"         :"eee8aa",
    //<< "palegreen"             :"98fb98",
    //<< "paleturquoise"         :"afeeee",
    //<< "palevioletred"         :"d87093",
    //<< "papayawhip"            :"ffefd5",
    //<< "peachpuff"             :"ffdab9",
    //<< "peru"                  :"cd853f",
    //<< "pink"                  :"ffc0cb",
    //<< "plum"                  :"dda0dd",
    //<< "powderblue"            :"b0e0e6",
    //<< "purple"                :"800080",
    //<< "red"                   :"ff0000",
    //<< "rosybrown"             :"bc8f8f",
    //<< "royalblue"             :"4169e1",
    //<< "saddlebrown"           :"8b4513",
    //<< "salmon"                :"fa8072",
    //<< "sandybrown"            :"f4a460",
    //<< "seagreen"              :"2e8b57",
    //<< "seashell"              :"fff5ee",
    //<< "sienna"                :"a0522d",
    //<< "silver"                :"c0c0c0",
    //<< "skyblue"               :"87ceeb",
    //<< "slateblue"             :"6a5acd",
    //<< "slategray"             :"708090",
    //<< "snow"                  :"fffafa",
    //<< "springgreen"           :"00ff7f",
    //<< "steelblue"             :"4682b4",
    //<< "tan"                   :"d2b48c",
    //<< "teal"                  :"008080",
    //<< "thistle"               :"d8bfd8",
    //<< "tomato"                :"ff6347",
    //<< "turquoise"             :"40e0d0",
    //<< "violet"                :"ee82ee",
    //<< "violetred"             :"d02090",
    //<< "wheat"                 :"f5deb3",
    //<< "white"                 :"ffffff",
    //<< "whitesmoke"            :"f5f5f5",
    //<< "yellow"                :"ffff00",
    //<< "yellowgreen"           :"9acd32",
    //<< : ""
    //<< )
    strColor.set(m$.Fnc.$case(m$.Fnc.$zconvert(pstrColor.get(),"l"),"aliceblue","f0f8ff","antiquewhite","faebd7","aqua","00ffff","aquamarine","7fffd4","azure","f0ffff","beige","f5f5d0","bisque","ffe4c4","black","000000","blanchedalmond","ffebcd","blue","0000ff","blueviolet","8a2be2","brown","a52a2a","burlywood","deb887","cadetblue","5f9ea0","chartreuse","7fff00","chocolate","d2691e","coral","ff7f50","cornflowerblue","6495ed","cornsilk","fff8dc","crimson","dc143c","cyan","00ffff","darkblue","00008b","darkcyan","008b8b","darkgoldenrod","b8860b","darkgray","a9a9a9","darkgreen","006400","darkkhaki","bdb76b","darkmagenta","8b008b","darkolivegreen","556b2f","darkorange","ff8c00","darkorchid","9932cc","darkred","8b0000","darksalmon","e9967a","darkseagreen","8fbc8f","darkslateblue","483d8b","darkslategray","2f4f4f","darkturquoise","00ced1","darkviolet","9400d3","deeppink","ff1493","deepskyblue","00bfff","dimgray","696969","dodgerblue","1e90ff","feldspar","d19275","firebrick","b22222","floralwhite","fffaf0","forestgreen","228b22","fuchsia","ff00ff","gainsboro","dcdcdc","ghostwhite","f8f8ff","gold","ffd700","goldenrod","daa520","gray","808080","green","008000","greenyellow","adff2f","honeydew","f0fff0","hotpink","ff69b4","indianred","cd5c5c","indigo","4b0082","ivory","fffff0","khaki","f0e68c","lavender","e6e6fa","lavenderblush","fff0f5","lawngreen","7cfc00","lemonchiffon","fffacd","lightblue","add8e6","lightcoral","f08080","lightcyan","e0ffff","lightgoldenrodyellow","fafad2","lightgrey","d3d3d3","lightgreen","90ee90","lightpink","ffb6c1","lightsalmon","ffa07a","lightseagreen","20b2aa","lightskyblue","87cefa","lightslateblue","8470ff","lightslategray","778899","lightsteelblue","b0c4de","lightyellow","ffffe0","lime","00ff00","limegreen","32cd32","linen","faf0e6","magenta","ff00ff","maroon","800000","mediumaquamarine","66cdaa","mediumblue","0000cd","mediumorchid","ba55d3","mediumpurple","9370d8","mediumseagreen","3cb371","mediumslateblue","7b68ee","mediumspringgreen","00fa9a","mediumturquoise","48d1cc","mediumvioletred","c71585","midnightblue","191970","mintcream","f5fffa","mistyrose","ffe4e1","moccasin","ffe4b5","navajowhite","ffdead","navy","000080","oldlace","fdf5e6","olive","808000","olivedrab","6b8e23","orange","ffa500","orangered","ff4500","orchid","da70d6","palegoldenrod","eee8aa","palegreen","98fb98","paleturquoise","afeeee","palevioletred","d87093","papayawhip","ffefd5","peachpuff","ffdab9","peru","cd853f","pink","ffc0cb","plum","dda0dd","powderblue","b0e0e6","purple","800080","red","ff0000","rosybrown","bc8f8f","royalblue","4169e1","saddlebrown","8b4513","salmon","fa8072","sandybrown","f4a460","seagreen","2e8b57","seashell","fff5ee","sienna","a0522d","silver","c0c0c0","skyblue","87ceeb","slateblue","6a5acd","slategray","708090","snow","fffafa","springgreen","00ff7f","steelblue","4682b4","tan","d2b48c","teal","008080","thistle","d8bfd8","tomato","ff6347","turquoise","40e0d0","violet","ee82ee","violetred","d02090","wheat","f5deb3","white","ffffff","whitesmoke","f5f5f5","yellow","ffff00","yellowgreen","9acd32",""));
    //<< quit strColor
    return strColor.get();
  }

  //<< 
  //<< 
  //<< Opacity(pstrValue)
  public Object Opacity(Object ... _p) {
    mVar pstrValue = m$.newVarRef("pstrValue",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    //<< ;-------------------------------------------------------------------------------
    //<< ;
    //<< ; Called By: Doesn't currently appear to be in use - see SALCSTIntDate for possibility
    //<< ;-------------------------------------------------------------------------------
    //<< new strOpacity
    mVar strOpacity = m$.var("strOpacity");
    m$.newVar(strOpacity);
    //<< 
    //<< if $get(YUSERAGENT)="MSIE" {
    if (mOp.Equal(m$.Fnc.$get(m$.var("YUSERAGENT")),"MSIE")) {
      //<< set strOpacity = "Filter:Alpha(opacity="_pstrValue_");"
      strOpacity.set(mOp.Concat(mOp.Concat("Filter:Alpha(opacity=",pstrValue.get()),");"));
    }
    //<< 
    //<< ;} elseif $get(YUSERAGENT)="GECKO" {  ;(firefox)
    //<< ;   set strOpacity = "-moz-opacity:"_$justify(pstrValue/100,1,2)_";"
    //<< 
    //<< } else {
    else {
      //<< set strOpacity = "opacity:"_$justify(pstrValue/100,1,2)_";"
      strOpacity.set(mOp.Concat(mOp.Concat("opacity:",m$.Fnc.$justify(mOp.Divide(pstrValue.get(),100),1,2)),";"));
    }
    //<< }
    //<< quit strOpacity  ;SR17481 ****
    return strOpacity.get();
  }

//<< 
//<< 
//<< 
//<< 
}
